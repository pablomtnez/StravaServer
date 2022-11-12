package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import clases.Reto;
import clases.SesionEntrenamiento;
import clases.Usuario;
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
	private Map<String, Usuario> servidor = new HashMap<>();
	
	private LogInAppService logInService = new LogInAppService();
	private LogOutAppService logOutService = new LogOutAppService();
	private RegisterAppService registerService = new RegisterAppService();
	private StravaAppService stravaService = new StravaAppService();
	
	
	//hay que hacer estos
	@Override
	public long registro(String email, String nombre, Date fechaNac, float peso, float altura, float fcm, float fcr)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long login(String email, String contrasena) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long logout(String token) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SesionEntrenamiento crearSesion(String titulo, String deporte, float distancia, Date fechaIni, float horaIni,
			float duracion) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reto crearReto(String nombre, Date fechaIni, Date fechaFin, float distancia, float tiempoObjetivo,
			String deporte) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reto> obtenerRetosActivos(String nombre, Date fechaIni) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean aceptarReto(String nombre) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
