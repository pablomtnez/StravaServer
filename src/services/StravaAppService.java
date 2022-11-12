package services;

import java.util.ArrayList;
import java.util.List;

import clases.Reto;
import clases.SesionEntrenamiento;
import clases.Usuario;

//MIRAR DATES DE LAS CLASES

public class StravaAppService {
	
	private List<SesionEntrenamiento> sesiones = new ArrayList<>();
	private List<Reto> retos = new ArrayList<>();
	List<Reto> retosActivos = new ArrayList<>();
	
	public StravaAppService() {
		
		this.initilizeData();
	}
	
	private void initilizeData() {
		
		//Creacion Usuarios
		
		Usuario usuario0 = new Usuario();
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
		
		//Creacion Sesiones Entrenamiento
		
		SesionEntrenamiento sesion0 = new SesionEntrenamiento();
		sesion0.setUsuario(usuario0);
		sesion0.setTitulo("Ruta por el campo");
		sesion0.setDeporte("Mountain Bike");
		sesion0.setDistancia(50);
		//sesion0.setFechaIni(null);
		//sesion0.setHoraIni(0);
		sesion0.setDuracion(180);
		
		SesionEntrenamiento sesion1 = new SesionEntrenamiento();
		sesion1.setUsuario(usuario1);
		sesion1.setTitulo("Ruta por la Ria de Bilbao");
		sesion1.setDeporte("Running");
		sesion1.setDistancia(5);
		//sesion0.setFechaIni(null);
		//sesion0.setHoraIni(0);
		sesion1.setDuracion(200);
		
		this.sesiones.add(sesion0);
		this.sesiones.add(sesion1);
		
		//Creacion Retos
		
		Reto reto0 = new Reto();
		reto0.setUsuario(usuario0);
		reto0.setSesionEntrenamiento(sesion0);
		reto0.setNombre("Gran Fondo");
		//reto0.setFechaIni(null);
		//reto0.setFechaFin(null);
		reto0.setDistancia(300);
		reto0.setTiempoObjetivo(90);
		reto0.setDeporte("Mountain Bike");
		reto0.setEstado(false);
		
		Reto reto1 = new Reto();
		reto1.setUsuario(usuario1);
		reto1.setSesionEntrenamiento(sesion1);
		reto1.setNombre("Carrera (resistencia)");
		//reto1.setFechaIni(null);
		//reto1.setFechaFin(null);
		reto1.setDistancia(2);
		reto1.setTiempoObjetivo(60);
		reto1.setDeporte("Running");
		reto1.setEstado(false);
		
		this.retos.add(reto0);
		this.retos.add(reto1);
		
		
	}

	public List<SesionEntrenamiento> getSesiones() {
		return sesiones;
	}

	public List<Reto> getRetos() {
		return retos;
	}
		
	public void crearManualSesionEntre(Usuario usuario, String titulo, String deporte,float distancia, String fechaYHora, float duracion) {
		
		SesionEntrenamiento sesion = new SesionEntrenamiento();
		sesion.setUsuario(usuario);
		sesion.setTitulo(titulo);
		sesion.setDeporte(deporte);
		sesion.setDistancia(distancia);
		sesion.setsFechaYHoraIni(fechaYHora);
		sesion.setDuracion(duracion);
		
		sesiones.add(sesion);
		
	}
	
	public void crearReto( String tituloSesion, Usuario usuario, SesionEntrenamiento sesion, String nombre, String fechaIni, String fechaFin, float distancia, float tiempoObjetivo, String deporte, boolean estado) {
		
		for (SesionEntrenamiento entrenamiento : this.sesiones) {
			if (entrenamiento.getTitulo() == tituloSesion) {
				sesion = entrenamiento;
			}
		}
		
		Reto reto = new Reto();
		reto.setUsuario(usuario);
		reto.setSesionEntrenamiento(sesion);
		reto.setNombre(nombre);
		reto.setsFechaIni(fechaIni);
		reto.setsFechaFin(fechaFin);
		reto.setDistancia(distancia);
		reto.setTiempoObjetivo(tiempoObjetivo);
		reto.setDeporte(deporte);
		reto.setEstado(estado);
		
		retos.add(reto);
	}
	
	public void obtenerRetosActivos() {
		for (int i = 0; i< retos.size(); i++) {
			
			Reto r = retos.get(i);
			
			if(r.getEstado()==true) {
				retosActivos.add(r);	
		}
		
		System.out.println(retosActivos);
		
		}
		
	}
	
	/*
	public void consultarRetos() {
		
	}
	*/
	
	public void aceptarReto(int i) {
		retos.get(i).setEstado(true);
		System.out.println("El reto de"+this.getRetos().get(i).getNombre()+"ha sido aceptado");
	}
}
