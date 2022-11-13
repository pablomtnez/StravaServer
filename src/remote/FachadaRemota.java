package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
//import java.util.Date;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;
import java.util.Map;

import clases.Reto;
//import clases.SesionEntrenamiento;
import clases.Usuario;
import dto.RetoAssembler;
import dto.RetoDTO;
import services.LogInAppService;
//import services.LogOutAppService;
import services.RegisterAppService;
import services.StravaAppService;


public class FachadaRemota extends UnicastRemoteObject implements IFachadaRemota{
	
	protected FachadaRemota() throws RemoteException {
		super();

	}

	private static final long serialVersionUID = 1L;

	//de este hashmap no estoy segura
	private Map<Long, Usuario> registroEstado = new HashMap<>();
	private Map<Long, Usuario> servidorEstado = new HashMap<>();
	
	private LogInAppService logInService = new LogInAppService();
	//private LogOutAppService logOutService = new LogOutAppService();
	private RegisterAppService registerService = new RegisterAppService();
	private StravaAppService stravaService = new StravaAppService();
	
	
	@Override
	public long registro(String email, String contrasena, String nombre, String fechaNac, float peso, float altura, float fcm, float fcr) throws RemoteException {
		System.out.println(" * FachadaRemota registro(): " + nombre+ " / " + email+ " / " + contrasena + " / " + fechaNac + " / " + peso + " / " + altura + " / " + fcm + " / " + fcr );
		
		Usuario usuario = registerService.register(email, contrasena, nombre, fechaNac, peso, altura, fcm, fcr);
		
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
}
