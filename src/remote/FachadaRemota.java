package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import clases.Reto;
import clases.SesionEntrenamiento;
import clases.Usuario;
import clases.UsuarioLocal;
import dto.RetoAssembler;
import dto.RetoDTO;
import dto.SesionEntrenamientoAssembler;
import dto.SesionEntrenamientoDTO;
import dto.UsuarioTipoDTO;
import services.LogInAppService;
import services.StravaAppService;

public class FachadaRemota extends UnicastRemoteObject implements IFachadaRemota{
	
	public FachadaRemota() throws RemoteException {
		super();

	}

	private static final long serialVersionUID = 1L;

	private Map<Long, Usuario> servidorEstado = new HashMap<>();
	
	List<Reto> retosActivos = new ArrayList<>();
	
	private LogInAppService logInService = new LogInAppService();
	private StravaAppService stravaService = new StravaAppService();
	
	
	@Override
	public boolean registrarLocal(String nombre, String email, String contrasena, String fechaNac, double peso, 
			double altura, double fcm, double fcr, UsuarioTipoDTO usuarioTipo) throws RemoteException{
		
		if(logInService.registrarLocal(nombre, email, contrasena, fechaNac, peso, 
				altura, fcm, fcr, usuarioTipo) == true) {
			
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean registrarGoogle(String nombre, String email, String fechaNac, double peso, double altura, 
			double fcm, double fcr, UsuarioTipoDTO usuarioTipo) throws RemoteException{
		
		if(logInService.registrarGoogle(nombre, email, fechaNac, peso, altura, fcm, fcr, usuarioTipo)==true) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean registrarFacebook(String nombre, String email, String fechaNac, double peso, double altura,
			double fcm, double fcr, UsuarioTipoDTO usuarioTipo) throws RemoteException {
		if(logInService.registrarFacebook(nombre, email, fechaNac, peso, altura, fcm, fcr, usuarioTipo)==true) {
			return true;
		}else {
			return false;
		}
	}
	
	
	@Override
	public long loginLocal(String email, String contrasena) throws RemoteException{
		
		UsuarioLocal usuarioLocal = logInService.loginLocal(email, contrasena);
		
		Long token = (long) -1;
		
		if(!(usuarioLocal.getEmail() == "" && usuarioLocal.getContrasena() == "")) {
			
			if(!this.servidorEstado.containsValue(usuarioLocal)) {
				
				token = Calendar.getInstance().getTimeInMillis();
				System.out.println(token);
				this.servidorEstado.put(token, usuarioLocal);
				System.out.println(usuarioLocal);
				return token;
			
			}else {
				
				throw new RemoteException("El usuario no está registrado");
				
			}
			
		}else {
			
			throw new RemoteException("El loginLocal ha fallado");
		}
	}
	
	public long loginGoogle(String email) throws RemoteException{
		
		Usuario usuario = logInService.loginGoogle(email);
		
		Long token = (long) -1;
		
		if(!(usuario.getEmail() == "")) {
			
			if(!this.servidorEstado.containsValue(usuario)) {
				
				token = Calendar.getInstance().getTimeInMillis();
				this.servidorEstado.put(token, usuario);
				return token;
			
			}else {
				
				throw new RemoteException("El usuario no esta registrado");
			}
			
		}else {
			throw new RemoteException("El loginGoogle ha fallado");
		}
	}
	
	public long loginFacebook(String email) throws RemoteException{
		
		Usuario usuario = logInService.loginFacebook(email);
		
		Long token = (long) -1;
		
		if(!(usuario.getEmail() == "")) {
			
			if(!this.servidorEstado.containsValue(usuario)) {
				
				token = Calendar.getInstance().getTimeInMillis();
				this.servidorEstado.put(token, usuario);
				return token;
			
			}else {
				
				throw new RemoteException("El usuario no esta registrado");
			}
			
		}else {
			throw new RemoteException("El loginFacebook ha fallado");
		}
	}
	
	@Override
	public void logout(long token) throws RemoteException{
		System.out.println(" * Fachada Remota logout(): " + token);
		if(this.servidorEstado.containsKey(token)) {
			this.servidorEstado.remove(token);
		}else {
			throw new RemoteException("El usuario no habia iniciado sesion");
		}
	}
		
	@Override
	public List<SesionEntrenamientoDTO> getSesiones() throws RemoteException {
		
		System.out.println(" * FachadaRemota getSesiones()");
		
		List<SesionEntrenamiento> sesiones = stravaService.getSesiones();
		
		if(sesiones != null) {
			return SesionEntrenamientoAssembler.getInstance().sesionEntrenamientoToDTO(sesiones);
		}else {
			throw new RemoteException("getSesiones() ha fallado");
		}
			
	}
	
	@Override
	public List<RetoDTO> getRetos() throws RemoteException {
		
		System.out.println(" * FachadaRemota getRetos()");
		
		List<Reto> retos = stravaService.getRetos();
		
		if(retos != null) {
			return RetoAssembler.getInstance().retosDTO(retos);
		}else {
			throw new RemoteException("getRetos() ha fallado");
		}
	}
	
	@Override
	public boolean crearSesionEntrenamiento(long token, SesionEntrenamientoDTO sesionDTO) throws RemoteException {
		
		List<SesionEntrenamiento> sesiones = stravaService.getSesiones();
		
		if (this.servidorEstado.containsKey(token)) {
			SesionEntrenamientoAssembler assembler = new SesionEntrenamientoAssembler();
			SesionEntrenamiento sesion = assembler.dtoToSesionEntrenamiento(sesionDTO);
			if (!stravaService.crearManualSesionEntre(sesion)==false) {
				sesiones.add(sesion);
				return true;
			}else {
				throw new RemoteException("crearSesionEntrenamiento ha fallado");
			}
		}else {
			throw new RemoteException("El usuario no ha iniciado sesion");
		}
	}
	
	@Override
	public boolean crearReto(long token, RetoDTO retoDTO) throws RemoteException {
		System.out.println(" * FachadaRemota Crear Reto");
	
		List<Reto> retos = stravaService.getRetos();
		
		if (this.servidorEstado.containsKey(token)) {
			RetoAssembler assembler = new RetoAssembler();
			Reto reto = assembler.dtoToReto(retoDTO);
			if (stravaService.crearReto(reto)==true) {
				retos.add(reto);
				return true;
			}else {
				throw new RemoteException("crearReto ha fallado");
			}
		}else {
			throw new RemoteException("El usuario no ha iniciado sesion");
		}
	}

	@Override
	public List<RetoDTO> obtenerRetosActivos(long token) throws RemoteException {
	
		System.out.println(" * FachadaRemota Obtener Retos Activos");
		
		if(this.servidorEstado.containsKey(token)) {
			List<Reto> retos = stravaService.obtenerRetosActivos();
			
			if(retos != null) {
				List<RetoDTO> retosActivos = new ArrayList<>();
				retosActivos = RetoAssembler.getInstance().retosDTO(retos);
				return retosActivos;
			
			}else {
				
				throw new RemoteException("ObtenerRetosActivos ha fallado");
			}
			
		}else {
			throw new RemoteException("El usuario tiene que haber iniciado sesion");
		}
		
	}
	
	public boolean aceptarReto(long token, RetoDTO retoDto) throws RemoteException{
		
		boolean resultado = false;
		
		if (this.servidorEstado.containsKey(token)) {
			RetoAssembler assembler = new RetoAssembler();
			Reto reto = assembler.dtoToReto(retoDto);
			
			if(stravaService.aceptarReto(this.servidorEstado.get(token), reto)) {	
				List<Reto> retosActivos = stravaService.obtenerRetosActivos();
				retosActivos.add(reto);
				resultado = true;	
			
			}else {
				throw new RemoteException("aceptarReto ha fallado");
			}
			
		}else {
			throw new RemoteException("El usuario tiene que haber iniciado sesión");	
		}	
		return resultado;
	}
}