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
	
	public FachadaRemota() throws RemoteException {
		super();

	}

	private static final long serialVersionUID = 1L;

	//de este hashmap no estoy segura
	private Map<Long, UsuarioLocalDTO> registroEstado = new HashMap<>();
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
	public synchronized long login (UsuarioLocalDTO usuario) throws RemoteException{
		System.out.println(" * FachadaRemota login(): " + usuario.getEmail() + " / " + usuario.getContrasena());
		
		usuario = logInService.login(usuario.getEmail(), usuario.getContrasena());
		
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
	public List<SesionEntrenamientoDTO> getSesiones(long token) throws RemoteException {
		System.out.println(" * FachadaRemota getSesiones()");
		
		List<SesionEntrenamientoDTO> sesiones = stravaService.getSesiones();
		
		if (this.servidorEstado.containsKey(token)) {
			if (sesiones != null) {
				//Convert domain object to DTO
				return (List<SesionEntrenamientoDTO>)SesionEntrenamientoAssembler.getInstance().dtoToSesionEntrenamiento((SesionEntrenamientoDTO)sesiones);
			} else {
				throw new RemoteException("getSesiones() fails!");
			}
		}else {
			throw new RemoteException("Necesita iniciar sesion antes");
		}
			
	}
	
	@Override
	public List<RetoDTO> getRetos(long token) throws RemoteException {
		System.out.println(" * FachadaRemota getRetoss()");
		
		List<RetoDTO> retos = stravaService.getRetos();
		
		if (this.servidorEstado.containsKey(token)) {
			if (retos != null) {
				//Convert domain object to DTO
				return (List<RetoDTO>) RetoAssembler.getInstance().dtoToReto((RetoDTO) retos);
			} else {
				throw new RemoteException("getRetos() fails!");
			}
		}else {
			throw new RemoteException("Necesita iniciar sesion antes");
		}
	}

	@Override//esta ns si está bien
	public List<RetoDTO> obtenerRetosActivos(long token) throws RemoteException {
		System.out.println(" * FachadaRemota Obtener Retos Activos");
		
		List<RetoDTO>retosActivos = stravaService.getRetos();
		if (this.servidorEstado.containsKey(token)) {
			if(retosActivos != null) {
				return (List<RetoDTO>) RetoAssembler.getInstance().dtoToReto((RetoDTO) retosActivos);
			}else {
				throw new RemoteException("obtenerRetosActivos ha fallado");
			}
		}else {
			throw new RemoteException("Necesita iniciar sesion antes");
		}
	}

	@Override //ns como hacerla
	public boolean aceptarReto(long token, RetoDTO retoDto) throws RemoteException {
		System.out.println(" * FachadaRemota aceptarReto " + retoDto);
		if (this.servidorEstado.containsKey(token)) {
			RetoAssembler ra = new RetoAssembler();
			//Reto reto = ra.dtoToReto(retoDto);
			
			if(stravaService.aceptarReto(this.servidorEstado.get(token), retoDto)) {
				return true;
			}else {
				throw new RemoteException("El reto no ha podido ser aceptado");
			}
		}else {
			throw new RemoteException("Para aceptar un reto tiene que haber iniciado sesion");
		}
	}

	@Override
	public boolean crearReto(long token, RetoDTO nuevoReto) throws RemoteException {
		System.out.println(" * FachadaRemota Crear Reto");
	
		List<RetoDTO> retos = stravaService.getRetos();
		
		
		
		if (this.servidorEstado.containsKey(token)) {
			RetoAssembler assembler = new RetoAssembler();
			Reto reto = assembler.dtoToReto(nuevoReto);
			
			if (retos.contains(nuevoReto)) {
				//Convertimos Reto a RetoDTO
		//			return RetoAssembler.getInstance().retoToDTO((Reto) retos);
			} else {
					throw new RemoteException("crearReto fails!");
			}
		}else {
			throw new RemoteException("Necesita iniciar sesion antes");
		}
		//Llamamos al Assembler para pasar de RetoDTO a Reto		
		return false;
	}

	@Override
	public boolean crearSesionEntrenamiento(long token, SesionEntrenamientoDTO nuevaSesion) throws RemoteException {
		
		List<SesionEntrenamientoDTO> sesiones = stravaService.getSesiones();
		
		if (this.servidorEstado.containsKey(token)) {	
			SesionEntrenamientoAssembler sea = new SesionEntrenamientoAssembler();
			SesionEntrenamiento sesEntre = sea.dtoToSesionEntrenamiento(nuevaSesion);
			
		
		}
//			if(sesiones.contains(nuevaSesion)) {
//				return SesionEntrenamientoAssembler.getInstance().sesionEntrenamientoToDTO((SesionEntrenamiento) sesiones);
//			}else {
//				throw new RemoteException("crearSesionEntrenamiento fails!");
//			}
//		} else {
//			throw new RemoteException("Necesita iniciar sesion antes");
//		}
		return false;
			
	}
	
	/*List<Category> categories = bidService.getCategories();
		
		if (categories != null) {
			//Convert domain object to DTO
			return CategoryAssembler.getInstance().categoryToDTO(categories);
		} else {
			throw new RemoteException("getCategories() fails!");
		}*/

	
}
