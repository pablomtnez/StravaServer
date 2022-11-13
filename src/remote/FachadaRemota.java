package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import clases.Reto;
import clases.SesionEntrenamiento;
import clases.Usuario;
import dto.RetoAssembler;
import services.LogInAppService;
import services.LogOutAppService;
import services.RegisterAppService;
import services.StravaAppService;


public class FachadaRemota extends UnicastRemoteObject implements IFachadaRemota{
	protected FachadaRemota() throws RemoteException {
		super();

	}

	private static final long serialVersionUID = 1L;

	//de este hashmap no estoy segura
	private Map<Long, Usuario> servidor = new HashMap<>();
	
	private LogInAppService logInService = new LogInAppService();
	private LogOutAppService logOutService = new LogOutAppService();
	private RegisterAppService registerService = new RegisterAppService();
	private StravaAppService stravaService = new StravaAppService();
	
	
	@Override
	public long registro(String email, String nombre, Date fechaNac, float peso, float altura, float fcm, float fcr)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long login(String email, String contrasena) throws RemoteException {
		System.out.println(" * FachadaRemota login(): " + email + " / " + contrasena);
		
		Usuario usuario = logInService.login(email, contrasena);
		
		if(usuario != null) {
			if(!this.servidor.values().contains(usuario)) {
				Long token = Calendar.getInstance().getTimeInMillis();
				this.servidor.put(token, usuario);
				return(token);
			}else {
				throw new RemoteException("El usuario ya ha iniciado sesión");
			}
		} else {
			throw new RemoteException("El login ha fallado");
		}
		
	}

	@Override
	public void logout(Long token) throws RemoteException {
		System.out.println(" * FachadaRemota logout(): " + token);
		
		if (this.servidor.containsKey(token)) {
			this.servidor.remove(token);
		}else {
			throw new RemoteException("El usuario no ha hecho el login");
		}
	}

	@Override//esta ns si está bien
	public List<Reto> obtenerRetosActivos(String nombre, Date fechaIni, boolean estado) throws RemoteException {
		System.out.println(" * FachadaRemota getnombre('" + nombre + "')");
		
		List<Reto> retos = stravaService.getRetos();
		
		for (int i = 0; i < retos.size(); i++) {
			if(retos.get(i).getEstado() == true) {
				return (List<Reto>) RetoAssembler.getInstance().retoToDTO((Reto) retos);
			}else {
				throw new RemoteException("getnombre() ha fallado");
			}
		}
		return retos;
		
	}

	@Override //ns como hacerla
	public boolean aceptarReto(String nombre) throws RemoteException {
		System.out.println(" * FachadaRemota aceptarReto " + nombre);
//		if (this.servidor.) {
//			
//		} else {
//
//		}
		return false;
	}

}
