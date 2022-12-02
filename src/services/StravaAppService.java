package services;

import java.util.ArrayList;
import java.util.List;
import clases.Deporte;
import clases.Reto;
import clases.SesionEntrenamiento;
import clases.Usuario;
import clases.UsuarioLocal;
import clases.UsuarioTipo;

public class StravaAppService {
	

	private List<UsuarioLocal> usuariosLocales = new ArrayList<>();
	private List<SesionEntrenamiento> sesiones = new ArrayList<>();
	private List<Reto> retos = new ArrayList<>();
	private List<Reto> retosActivos = new ArrayList<>();
	
	public StravaAppService() {
		
		this.initilizeData();
	}
	
	private void initilizeData() {
		
		//Creación usuarios locales
		
		UsuarioLocal usuario0 = new UsuarioLocal();
		usuario0.setNombre("Jose");
		usuario0.setUsuarioTipo(UsuarioTipo.LOCAL);
		usuario0.setEmail("Jose@gmail.com");
		usuario0.setContrasena("1234");
		usuario0.setFechaNac("15-08-2000");
		usuario0.setPeso(60);
		usuario0.setAltura(155);
		usuario0.setFcm(169);
		usuario0.setFcr(96);
		
		UsuarioLocal usuario1 = new UsuarioLocal();
		usuario1.setNombre("Laura");
		usuario1.setUsuarioTipo(UsuarioTipo.LOCAL);
		usuario1.setEmail("laura@gmail.com");
		usuario1.setContrasena("5678");
		usuario1.setFechaNac("03-12-1998");
		usuario1.setPeso(60);
		usuario1.setAltura(155);
		usuario1.setFcm(169);
		usuario1.setFcr(96);
		
		usuariosLocales.add(usuario0);
		usuariosLocales.add(usuario1);
		
		//Creacion Sesiones Entrenamiento
		
		SesionEntrenamiento sesion0 = new SesionEntrenamiento();
		sesion0.setUsuario(usuario0.getNombre());
		sesion0.setTitulo("Ruta por el campo");
		sesion0.setDeporte(Deporte.CICLISMO);
		sesion0.setDistancia(50);
		sesion0.setsFechaYHoraIni("11/02/2022 17:43");
		sesion0.setDuracion(180);
		sesion0.setCodigo(01);
		
		SesionEntrenamiento sesion1 = new SesionEntrenamiento();
		sesion1.setUsuario(usuario1.getNombre());
		sesion1.setTitulo("Ruta por la Ria de Bilbao");
		sesion1.setDeporte(Deporte.RUNNING);
		sesion1.setDistancia(5);
		sesion1.setsFechaYHoraIni("25/11/2022 10:34");
		sesion1.setDuracion(200);
		sesion1.setCodigo(02);
		
		this.sesiones.add(sesion0);
		this.sesiones.add(sesion1);
		
		//Creacion Retos
		
		Reto reto0 = new Reto();
		
		reto0.setUsuario(usuario0.getNombre());
		reto0.setCodigo(0001);
		reto0.setNombre("Gran Fondo");
		reto0.setSfechaIni("13-02-2022");
		reto0.setSfechaFin("21-03-2022");
		reto0.setDistancia(300);
		reto0.setTiempoObjetivo(90);
		reto0.setDeporte(Deporte.CICLISMO);
		reto0.setEstado(false);
		
		Reto reto1 = new Reto();
		reto1.setUsuario(usuario1.getNombre());
		reto1.setCodigo(0002);
		reto1.setNombre("Carrera (resistencia)");
		reto1.setSfechaIni("31-05-2022");
		reto1.setSfechaFin("15-06-2022");
		reto1.setDistancia(2);
		reto1.setTiempoObjetivo(60);
		reto1.setDeporte(Deporte.RUNNING);
		reto1.setEstado(false);
		
		retos.add(reto0);
		retos.add(reto1);
		
		
	}
	
	//GET SESIONES

	public List<SesionEntrenamiento> getSesiones() {
		return sesiones;
	}

	//GET RETOS
	
	public List<Reto> getRetos() {
		return retos;
	}
	
	//CREAR SESIONES ENTRENAMIENTO
			
	public boolean crearManualSesionEntre(SesionEntrenamiento sesion) {
		if(!sesiones.contains(sesion)) {
			this.sesiones.add(sesion);
			return true;
		}else {
			return false;
		}
	}
	
	//CREAR RETOS
	
	public boolean crearReto(Reto reto) {
			if(!retos.contains(reto)) {
				this.retos.add(reto);
				return true;
			}else {
				return false;
			}
	}
	
	//Obtener Retos Activos
	
	public List<Reto> obtenerRetosActivos() {
		
		for(Reto reto : retos ) {
			
			if(reto.getEstado() == true) {
				
				retosActivos.add(reto);
			}
		}
		
		return retosActivos;	
	}
	
	//Aceptar Reto
	
	public boolean aceptarReto(Usuario usuario, Reto reto) {
		List<Reto> retos = getRetos();
		boolean resultado = false;
		for (Reto r : retos) {
			if (reto.getNombre() == r.getNombre()) {
				reto.setEstado(true);
				resultado = true;
			}else {
				resultado = false;
			}
		}
		return resultado;
	}
}
