package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import clases.Login;
import clases.Reto;
import clases.SesionEntrenamiento;
import clases.Usuario;

public class StravaAppService {
	
	private List<Reto> retos = new ArrayList<>();
	private List<Usuario> usuarios= new ArrayList<>();
	private List<SesionEntrenamiento> sesiones = new ArrayList<>();
	
	public StravaAppService() {
		
		this.initilizeData();
	}
	
	private void initilizeData() {
		
		//Creacion Usuarios
		
		Usuario usuario0 = new Usuario();
		usuario0.setNombre("Juan");
		//usuario0.setFechaNac();
		usuario0.setPeso(78);
		usuario0.setAltura(167);
		usuario0.setFcm(190);
		usuario0.setFcr(100);
		
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Laura");
		//usuario1.setFechaNac();
		usuario0.setPeso(60);
		usuario0.setAltura(155);
		usuario0.setFcm(169);
		usuario0.setFcr(96);
		
		//Creacion Login
		
		Login login0 = new Login();
		login0.setUsuario(usuario0);
		login0.setEmail("juan@gmail.com");
		login0.setContrasena("1234");
		
		Login login1 = new Login();
		login1.setUsuario(usuario1);
		login1.setEmail("laura@gmail.com");
		login1.setContrasena("5678");
		
		
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
		
		
	}

	public List<Reto> getRetos() {
		return retos;
	}
	
	public void registrarUsuario(String nombre, Date fechaNac, float peso, float altura, float fcm, float fcr) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setFechaNac(fechaNac);
		usuario.setPeso(peso);
		usuario.setAltura(altura);
		usuario.setFcm(fcm);
		usuario.setFcr(fcr);
		
		usuarios.add(usuario);
	}
	
	public void crearManualSesionEntre(Usuario usuario,String nombreUsuario, String titulo, String deporte,float distancia, Date fechaIni, float horaIni, float duracion) {
		
		for (Usuario user : this.usuarios) {
			if (user.getNombre() == nombreUsuario) {
				usuario = user;
			}
		}
		
		SesionEntrenamiento sesion = new SesionEntrenamiento();
		sesion.setUsuario(usuario);
		sesion.setTitulo(titulo);
		sesion.setDeporte(deporte);
		sesion.setDistancia(distancia);
		sesion.setFechaIni(fechaIni);
		sesion.setHoraIni(horaIni);
		sesion.setDuracion(duracion);
		
		sesiones.add(sesion);
		
	}
	
	public void crearReto(String nombreUsuario, String tituloSesion, Usuario usuario, SesionEntrenamiento sesion, String nombre, Date fechaIni, Date fechaFin, float distancia, float tiempoObjetivo, String deporte, boolean estado) {
		
		for (Usuario user : this.usuarios) {
			if (user.getNombre() == nombreUsuario) {
				usuario = user;
			}
		}
		
		for (SesionEntrenamiento entrenamiento : this.sesiones) {
			if (entrenamiento.getTitulo() == tituloSesion) {
				sesion = entrenamiento;
			}
		}
		
		Reto reto = new Reto();
		reto.setUsuario(usuario);
		reto.setSesionEntrenamiento(sesion);
		reto.setNombre(nombre);
		reto.setFechaIni(fechaIni);
		reto.setFechaFin(fechaFin);
		reto.setDistancia(distancia);
		reto.setTiempoObjetivo(tiempoObjetivo);
		reto.setDeporte(deporte);
		reto.setEstado(estado);
		
		retos.add(reto);
	}
}
