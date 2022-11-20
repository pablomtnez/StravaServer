package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
//import java.util.Date;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;
import java.util.Map;
import clases.Deporte;
import clases.Reto;
import clases.SesionEntrenamiento;
//import clases.SesionEntrenamiento;
import clases.Usuario;
import clases.UsuarioLocal;
import dto.RetoAssembler;
import dto.RetoDTO;
import dto.SesionEntrenamientoAssembler;
import dto.SesionEntrenamientoDTO;
import dto.UsuarioDTO;
import dto.UsuarioLocalDTO;
import services.LogInAppService;
import services.RegisterAppService;
import services.StravaAppService;

public class FachadaRemota extends UnicastRemoteObject implements IFachadaRemota{
	
	protected FachadaRemota() throws RemoteException {
		super();

	}

	private static final long serialVersionUID = 1L;

	//de este hashmap no estoy segura
	private Map<Long, UsuarioDTO> registroEstado = new HashMap<>();
	private Map<Long, Usuario> servidorEstado = new HashMap<>();
	//mapa.containsKey(long), si esta bien lo meto y sino error(excepcion)
	
	private LogInAppService logInService = new LogInAppService();
	//private LogOutAppService logOutService = new LogOutAppService();
	private RegisterAppService registerService = new RegisterAppService();
	private StravaAppService stravaService = new StravaAppService();
	
	
	@Override
	public long registro(UsuarioLocalDTO usuario) throws RemoteException {
		
		System.out.println(" * FachadaRemota registro(): " + usuario.getNombre()+ " / " + usuario.getEmail()+ " / " + usuario.getContrasena() + " / " + usuario.getFechaNac() + " / " + usuario.getPeso() + " / " + usuario.getAltura() + " / " + usuario.getFcm() + " / " + usuario.getFcr() );
		
		usuario = registerService.register(usuario.getEmail(), usuario.getContrasena(), usuario.getNombre(), usuario.getFechaNac(), usuario.getPeso(), usuario.getAltura(), usuario.getFcm(), usuario.getFcr());

		if(usuario != null) {
			if(!this.registroEstado.values().contains(usuario)) {
				Long token = Calendar.getInstance().getTimeInMillis();
				this.registroEstado.put(token, usuario);
				return (token);
			}else {
				throw new RemoteException("El usuario se ha registrado con éxito");
			}
			
		}else {
			throw new RemoteException("Ha fallado el registo");
		}
	}
	
	@Override
	public synchronized long login (String email, String contrasena) throws RemoteException{
		System.out.println(" * FachadaRemota login(): " + email + " / " + contrasena);
		
		Usuario usuario = logInService.login(email, contrasena);
		
		if(usuario != null) {
			if(!this.servidorEstado.values().contains(usuario)) {
				Long token = Calendar.getInstance().getTimeInMillis();
				this.servidorEstado.put(token, usuario);
				return (token);
			}else {
				throw new RemoteException("El usuario ya ha iniciado sesion");
			}
			
		}else {
			throw new RemoteException("Ha fallado el inicio de sesion");
		}
	}
	
	@Override
	public synchronized void logout(long token) throws RemoteException{
		System.out.println(" * FachadaRemota logout(): " + token);
		
		if (this.servidorEstado.containsKey(token)) {
			this.servidorEstado.remove(token);
		}else {
			throw new RemoteException("El usuario no ha iniciado sesión");
		}
	}
	
	@Override
	public List<SesionEntrenamientoDTO> getSesiones() throws RemoteException {
		System.out.println(" * FachadaRemota getSesiones()");
		
		List<SesionEntrenamiento> sesiones = stravaService.getSesiones();
		
		if (sesiones != null) {
			//Convert domain object to DTO
			return SesionEntrenamientoAssembler.getInstance().sesionEntrenamientoToDTO(sesiones);
		} else {
			throw new RemoteException("getSesiones() fails!");
		}
	}
	
	@Override
	public List<RetoDTO> getRetos() throws RemoteException {
		System.out.println(" * FachadaRemota getRetoss()");
		
		List<Reto> retos = stravaService.getRetos();
		
		if (retos != null) {
			//Convert domain object to DTO
			return RetoAssembler.getInstance().retoToDTO(retos);
		} else {
			throw new RemoteException("getRetos() fails!");
		}
	}

	@Override//esta ns si está bien
	public List<RetoDTO> obtenerRetosActivos() throws RemoteException {
		System.out.println(" * FachadaRemota Obtener Retos Activos");
		
		List<Reto>retosActivos = stravaService.getRetos();
		
		if(retosActivos != null) {
			return RetoAssembler.getInstance().retoToDTO(retosActivos);
		}else {
			throw new RemoteException("obtenerRetosActivos ha fallado");
		}
	}

	@Override //ns como hacerla
	public boolean aceptarReto(long token, String nombre) throws RemoteException {
		System.out.println(" * FachadaRemota aceptarReto " + nombre);
		if (this.servidorEstado.containsKey(token)) {
			if(stravaService.aceptarReto(this.servidorEstado.get(token), nombre)) {
				return true;
			}else {
				throw new RemoteException("El reto no ha podido ser aceptado");
			}
		}else {
			throw new RemoteException("Para aceptar un reto tiene que haber iniciado sesion");
		}
	}

	@Override
	public RetoDTO crearReto(long token, RetoDTO nuevoReto) throws RemoteException {
		System.out.println(" * FachadaRemota Crear Reto");
		
		List<Reto> retos = stravaService.getRetos();
		
		if (retos != null) {
			//Convertimos Reto a RetoDTO
			return (RetoDTO) RetoAssembler.getInstance().retoToDTO(retos);
		} else {
			throw new RemoteException("getRetos() fails!");
		}
		//Llamamos al Assembler para pasar de RetoDTO a Reto
		
		
	}
	
	/*List<Category> categories = bidService.getCategories();
		
		if (categories != null) {
			//Convert domain object to DTO
			return CategoryAssembler.getInstance().categoryToDTO(categories);
		} else {
			throw new RemoteException("getCategories() fails!");
		}*/

	@Override
	public SesionEntrenamientoDTO crearSesionEntrenamiento(long token, SesionEntrenamientoDTO nuevaSesion)
			throws RemoteException {
		// TODO Auto-generated method stub
		return nuevaSesion;
	}

	
}
