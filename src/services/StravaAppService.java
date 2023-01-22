package services;

import java.util.ArrayList;
import java.util.List;

import clases.Reto;
import clases.SesionEntrenamiento;
import clases.Usuario;

public class StravaAppService {
	
	private static StravaAppService instance;
	
//	private List<SesionEntrenamiento> sesiones = new ArrayList<>();
//	private List<Reto> retos = new ArrayList<>();
//	private List<Reto> retosActivos = new ArrayList<>();
	
	public static StravaAppService getInstance() {
		if(instance == null) {
			instance = new StravaAppService();
		}
		return instance;
	}
	
	private StravaAppService() {}
	
	//GET SESIONES

//	public List<SesionEntrenamiento> getSesiones(Usuario usuario) {
//		sesiones = usuario.getSesiones();
//		return sesiones;
//	}
	


	//GET RETOS
	
//	public List<Reto> getRetos(Usuario usuario) {
//		retos = usuario.getRetos();
//		return retos;
//	}
	
	//CREAR SESIONES ENTRENAMIENTO
			
//	public void crearSesion(Usuario usuario, SesionEntrenamiento sesion) {
//		sesiones = usuario.getSesiones();
//		if(sesion != null && !sesiones.contains(sesion)) {
//			sesiones.add(sesion);
//		}
//	}
	
	public void crearSesion(Usuario usuario, SesionEntrenamiento sesion) {
		Usuario us = LoginAppService.getMapaUsuario().get(usuario.getEmail());
		us.getSesiones().add(sesion);
		LoginAppService.getMapaUsuario().put(usuario.getEmail(), us);
}

	
	//CREAR RETOS
	
	public void crearReto(Usuario usuario, Reto reto) {
		Usuario us = LoginAppService.getMapaUsuario().get(usuario.getEmail());
		us.getRetos().add(reto);
		LoginAppService.getMapaUsuario().put(usuario.getEmail(), us);
	}
	
	//Obtener Retos Activos
	
//	public List<Reto> obtenerRetosActivos(Usuario usuario) {
//		retosActivos = usuario.getRetosActivos();
//		return retosActivos;
//	}
	
	//Aceptar Reto
	public void aceptarReto(Usuario usuario, Reto reto) {
		Usuario us = LoginAppService.getMapaUsuario().get(usuario.getEmail());
		us.getRetosActivos().add(reto);
		LoginAppService.getMapaUsuario().put(usuario.getEmail(), us);
	}
	
}
