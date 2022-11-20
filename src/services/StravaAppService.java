package services;

//import java.rmi.RemoteException;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.List;

import clases.Deporte;
//import clases.Reto;
//import clases.SesionEntrenamiento;
import clases.Usuario;
import clases.UsuarioLocal;
import dto.RetoDTO;
import dto.SesionEntrenamientoDTO;

//MIRAR DATES DE LAS CLASES

public class StravaAppService {
	
	private List<SesionEntrenamientoDTO> sesiones = new ArrayList<>();
	private List<RetoDTO> retos = new ArrayList<>();
	//private List<RetoDTO> retosDTO = new ArrayList<>();
	List<RetoDTO> retosActivos = new ArrayList<>();
	
	public StravaAppService() {
		
		this.initilizeData();
	}
	
	private void initilizeData() {
		
		//Creacion Usuarios
		
/*		Usuario usuario0 = new Usuario();
		usuario0.setNombre("Juan");
		usuario0.setEmail("juan@gmail.com");
		usuario0.setContrasena("1234");
		usuario0.setsFechaNac("15-04-2002");
		usuario0.setPeso(78);
		usuario0.setAltura(167);
		usuario0.setFcm(190);
		usuario0.setFcr(100);
		
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Laura");
		usuario1.setEmail("laura@gmail.com");
		usuario1.setContrasena("5678");
		usuario1.setsFechaNac("03-12-1998");
		usuario1.setPeso(60);
		usuario1.setAltura(155);
		usuario1.setFcm(169);
		usuario1.setFcr(96);
*/		
		UsuarioLocal usuario0 = new UsuarioLocal();
		usuario0.setNombre("Laura");
		usuario0.setEmail("laura@gmail.com");
		usuario0.setContrasena("5678");
		usuario0.setFechaNac("03-12-1998");
		usuario0.setPeso(60);
		usuario0.setAltura(155);
		usuario0.setFcm(169);
		usuario0.setFcr(96);
		
		UsuarioLocal usuario1 = new UsuarioLocal();
		usuario1.setNombre("Laura");
		usuario1.setEmail("laura@gmail.com");
		usuario1.setContrasena("5678");
		usuario1.setFechaNac("03-12-1998");
		usuario1.setPeso(60);
		usuario1.setAltura(155);
		usuario1.setFcm(169);
		usuario1.setFcr(96);
		
		//Creacion Sesiones Entrenamiento
		
		SesionEntrenamientoDTO sesion0 = new SesionEntrenamientoDTO();
		sesion0.setUsuario(usuario0);
		sesion0.setTitulo("Ruta por el campo");
		sesion0.setDeporte(Deporte.CICLISMO);
		sesion0.setDistancia(50);
		//sesion0.setFechaIni(null);
		//sesion0.setHoraIni(0);
		sesion0.setDuracion(180);
		
		SesionEntrenamientoDTO sesion1 = new SesionEntrenamientoDTO();
		sesion1.setUsuario(usuario1);
		sesion1.setTitulo("Ruta por la Ria de Bilbao");
		sesion1.setDeporte(Deporte.RUNNING);
		sesion1.setDistancia(5);
		//sesion0.setFechaIni(null);
		//sesion0.setHoraIni(0);
		sesion1.setDuracion(200);
		
		this.sesiones.add(sesion0);
		this.sesiones.add(sesion1);
		
		//Creacion Retos
		
		RetoDTO reto0 = new RetoDTO();
		//reto0.setUsuario(usuario0);
		//reto0.setSesionEntrenamiento(sesion0);
		reto0.setNombre("Gran Fondo");
		reto0.setFechaIni("13-02-2022");
		reto0.setFechaFin("21-03-2022");
		reto0.setDistancia(300);
		reto0.setTiempoObjetivo(90);
		reto0.setDeporte(Deporte.CICLISMO);
		reto0.setEstado(false);
		
		RetoDTO reto1 = new RetoDTO();
		//reto1.setUsuario(usuario1);
		//reto1.setSesionEntrenamiento(sesion1);
		reto1.setNombre("Carrera (resistencia)");
		reto1.setFechaIni("31-05-2022");
		reto1.setFechaFin("15-06-2022");
		reto1.setDistancia(2);
		reto1.setTiempoObjetivo(60);
		reto1.setDeporte(Deporte.RUNNING);
		reto1.setEstado(false);
		
		this.retos.add(reto0);
		this.retos.add(reto1);
		
		
	}

	public List<SesionEntrenamientoDTO> getSesiones() {
		return sesiones;
	}

	public List<RetoDTO> getRetos() {
		return retos;
	}
		
	public void crearManualSesionEntre(Usuario usuario, String titulo, Deporte deporte,float distancia, String fechaYHora, float duracion) {
		
		SesionEntrenamientoDTO sesion = new SesionEntrenamientoDTO();
		sesion.setUsuario(usuario);
		sesion.setTitulo(titulo);
		sesion.setDeporte(deporte);
		sesion.setDistancia(distancia);
		sesion.setsFechaYHoraIni(fechaYHora);
		sesion.setDuracion(duracion);
		
		sesiones.add(sesion);
		
	}
	//Guardar reto
	public boolean crearReto( RetoDTO reto) {
			if(!retos.contains(reto)) {
				this.retos.add(reto);
				return true;
			}else {
				return false;
			}
			//comprobar si el reto existe o no, si no existe lo almaceno y devuelvo true y sino false
		
	}
	
	public List<RetoDTO> obtenerRetosActivos() {
		
		for (int i = 0; i< retos.size(); i++) {
			
			RetoDTO r = retos.get(i);
			
			if(r.getEstado()==true) {
				retosActivos.add(r);	
			}
		}
		return retosActivos;
		
	}
	
	/*
	public void consultarRetos() {
		
	}
	*/
	
	public boolean aceptarReto(Usuario usuario, String nombre) {
		RetoDTO r =null;
		for (int i = 0; i<retos.size(); i++) {
			r = retos.get(i);
		}
		if (r.getNombre() == nombre) {
			r.setEstado(true);
			return true;
		}else {
			return false;
		}
	}
}
