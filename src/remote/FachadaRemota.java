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
import clases.UsuarioTipo;
import dto.RetoAssembler;
import dto.RetoDTO;
import dto.SesionEntrenamientoAssembler;
import dto.SesionEntrenamientoDTO;
import dto.UsuarioDTO;
import services.LoginAppService;
import services.StravaAppService;

public class FachadaRemota extends UnicastRemoteObject implements IFachadaRemota{

	private static final long serialVersionUID = 1L;
	
	private Map<Long, Usuario> servidorEstado = new HashMap<>();
	
	private LoginAppService loginService = LoginAppService.getInstance();
	private StravaAppService appService = StravaAppService.getInstance();
	
	public FachadaRemota() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public synchronized void registarLocal(UsuarioDTO dto) throws RemoteException{
		System.out.println(" * FachadaRemota registrarLocal(): " + dto.getEmail() + " / " + dto.getContrasena());
		
		UsuarioLocal uL = new UsuarioLocal();
		
		uL.setAltura(dto.getAltura());
		uL.setContrasena(dto.getContrasena());
		uL.setEmail(dto.getEmail());
		uL.setFcm(dto.getFcm());
		uL.setFcr(dto.getFcr());
		uL.setFechaNac(dto.getFechaNac());
		uL.setNombre(dto.getNombre());
		uL.setPeso(dto.getPeso());
		uL.setUsuarioTipo(UsuarioTipo.LOCAL);
		
		if(!loginService.registrarLocal(uL)) {
			throw new RemoteException("User is already logged in!");
		}
	}
	
	@Override
	public synchronized long loginLocal(String email, String contrasena) throws RemoteException {
		System.out.println(" * RemoteFacade loginLocal(): " + email + " / " + contrasena);
		
		UsuarioLocal uL = loginService.loginLocal(email, contrasena);
		
		if(uL != null) {
			if(!this.servidorEstado.values().contains(uL)) {
				long token = Calendar.getInstance().getTimeInMillis();
				this.servidorEstado.put(token, uL);
				return token;
			}else {
				throw new RemoteException("User is already logged in!");
			}
		}else {
			throw new RemoteException("Login fails!");
		}
		
	}

	@Override
	public synchronized void registarFacebook(UsuarioDTO dto) throws RemoteException {
		System.out.println(" * FachadaRemota registrarFacebook(): " + dto.getEmail() + "");
		
		Usuario u = new Usuario();
		u.setAltura(dto.getAltura());
		u.setEmail(dto.getEmail());
		u.setFcm(dto.getFcm());
		u.setFcr(dto.getFcr());
		u.setFechaNac(dto.getFechaNac());
		u.setNombre(dto.getNombre());
		u.setPeso(dto.getPeso());
		u.setUsuarioTipo(UsuarioTipo.FACEBOOK);
		
		if(!loginService.registrarFacebook(u)) {
			throw new RemoteException("User is already logged in!");
		}
	}

	@Override
	public synchronized long loginFacebook(String email) throws RemoteException {
		System.out.println(" * RemoteFacade loginFacebook(): " + email + "");
		
		Usuario u = loginService.loginFacebook(email);
		
		if(u != null) {
			if(!this.servidorEstado.values().contains(u)) {
				long token = Calendar.getInstance().getTimeInMillis();
				this.servidorEstado.put(token, u);
				return token;
			}else {
				throw new RemoteException("User is already logged in!");
			}
		}else {
			throw new RemoteException("Login fails!");
		}
	}

	@Override
	public synchronized void registrarGoogle(UsuarioDTO dto) throws RemoteException {
		System.out.println(" * FachadaRemota registrarGoogle(): " + dto.getEmail() + "");
		
		Usuario u = new Usuario();
		u.setAltura(dto.getAltura());
		u.setEmail(dto.getEmail());
		u.setFcm(dto.getFcm());
		u.setFcr(dto.getFcr());
		u.setFechaNac(dto.getFechaNac());
		u.setNombre(dto.getNombre());
		u.setPeso(dto.getPeso());
		u.setUsuarioTipo(UsuarioTipo.GOOGLE);
		
		if(!loginService.registrarGoogle(u)) {
			throw new RemoteException("User is already logged in!");
		}
		
	}


	@Override
	public synchronized long loginGoogle(String email) throws RemoteException {
		System.out.println(" * RemoteFacade loginFacebook(): " + email + "");
		
		Usuario u = loginService.loginFacebook(email);
		
		if(u != null) {
			if(!this.servidorEstado.values().contains(u)) {
				long token = Calendar.getInstance().getTimeInMillis();
				this.servidorEstado.put(token, u);
				return token;
			}else {
				throw new RemoteException("User is already logged in!");
			}
		}else {
			throw new RemoteException("Login fails!");
		}
	}

	@Override
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);
		if (this.servidorEstado.containsKey(token)) {
			//Logout means remove the User from Server State
			this.servidorEstado.remove(token);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}

	@Override
	public List<RetoDTO> getReto(long token) throws RemoteException {
		List<RetoDTO> retos = new ArrayList<>();
		for(Reto r : servidorEstado.get(token).getRetos()) {
			retos.add(RetoAssembler.retoToDTO(r));
		}
		return retos;
	}

	@Override
	public List<RetoDTO> obtenerRetosActivos(long token) throws RemoteException {
		List<RetoDTO> retosActivos = new ArrayList<>();
		for(Reto r : servidorEstado.get(token).getRetosActivos()) {
			retosActivos.add(RetoAssembler.retoToDTO(r));
		}
		return retosActivos;
	}

	@Override
	public List<SesionEntrenamientoDTO> getSesiones(long token) throws RemoteException {
		List<SesionEntrenamientoDTO> sesiones = new ArrayList<>();
		for(SesionEntrenamiento s : servidorEstado.get(token).getSesiones()) {
			sesiones.add(SesionEntrenamientoAssembler.sesionToDTO(s));
		}
		return sesiones;
	}

	@Override
	public void crearSesion(SesionEntrenamientoDTO dto, long token) throws RemoteException {
		System.out.println(" * Making Sesion: " + dto.getTitulo() + " " + dto.getDeporte().toString());
		SesionEntrenamiento sesion = new SesionEntrenamiento();
		sesion.setDeporte(dto.getDeporte());
		sesion.setDistancia(dto.getDistancia());
		sesion.setDuracion(dto.getDuracion());
		sesion.setsFyH(dto.getsFyH());
		sesion.setTitulo(dto.getTitulo());
		Usuario u = servidorEstado.get(token);
		appService.crearSesion(u, sesion);
	}

	@Override
	public void crearReto(RetoDTO dto, long token) throws RemoteException {
		System.out.println(" * Making Reto: " + dto.getNombre() + " " + dto.getDeporte().toString());
		Reto reto = new Reto();
		reto.setDeporte(dto.getDeporte());
		reto.setDistancia(dto.getDistancia());
		reto.setFechaFin(dto.getFechaFin());
		reto.setFechaIni(dto.getFechaIni());
		reto.setNombre(dto.getNombre());
		reto.setTiempoObjetivo(dto.getTiempoObjetivo());
		Usuario u = servidorEstado.get(token);
		appService.crearReto(u, reto);
	}

	@Override
	public void aceptarReto(String nombre, long token) throws RemoteException {
		System.out.println(" * Activating Reto: " + nombre);
		Usuario usuario = servidorEstado.get(token);
		Reto reto = null;
		for(Reto r : servidorEstado.get(token).getRetos()) {
			if(r.toString().equals(nombre)) {
				reto = r;
			}
		}
		if(reto != null) {
			appService.aceptarReto(usuario, reto);
		}
	}
}
