package test;

import java.util.List;

import dto.DeporteDTO;
import dto.RetoDTO;
import dto.SesionEntrenamientoDTO;
import dto.UsuarioTipoDTO;
import remote.FachadaRemota;

public class LocalTest {
public static void main(String[] args) {
		
		FachadaRemota fachada = null;
		List<SesionEntrenamientoDTO> sesiones = null;
		List<RetoDTO> retos = null;
		RetoDTO retoDTO = null;
		SesionEntrenamientoDTO sesionEntrenamientoDTO = null;
		List<RetoDTO> retosActivos = null;
		
		long token = 0l;
		
		try {
			
			fachada = new FachadaRemota();
			
			//Get Sesiones
			sesiones = fachada.getSesiones();
			sesionEntrenamientoDTO = sesiones.get(0);
			
			for(SesionEntrenamientoDTO s : sesiones) {
				System.out.println("\t- " + s);
			}
			
			//Get Retos
			retos = fachada.getRetos();
			retoDTO = retos.get(0);
			
			for(RetoDTO r : retos) {
				System.out.println("\t- " + r);
			}
			
			retosActivos = fachada.obtenerRetosActivos(0);
			
			fachada.aceptarReto(0, retoDTO);
			
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());
		}
	
		try {
			
			//Registro Local
			String nombre = "Paula";
			String email = "paula@hotmail.es";
			String contrasena = "9876";
			String fechaNac = "12/03/2000";
			double peso = 54.4;
			double altura = 1.67;
			double fcm = 98;
			double frm = 80;
			UsuarioTipoDTO tipo = UsuarioTipoDTO.LOCAL;
			
			fachada.registrarLocal(nombre, email, contrasena, fechaNac, peso, altura, fcm, frm, tipo);
			
			//Registro Google
			String nombre1 = "Alejandro";
			String email5 = "alejando@gmail.es";
			String fechaNac1 = "30/03/2001";
			double peso1 = 70;
			double altura1 = 1.80;
			double fcm1 = 95;
			double frm1 = 85;
			UsuarioTipoDTO tipo1 = UsuarioTipoDTO.GOOGLE;
			
			fachada.registrarGoogle(nombre1, email5, fechaNac1, peso1, altura1, fcm1, frm1, tipo1);
			
			//Registrar Facebook
			String nombre2 = "Maria";
			String email2 = "maria@gmail.es";
			String fechaNac2 = "14/08/1990";
			double peso2 = 60;
			double altura2 = 1.73;
			double fcm2 = 98;
			double frm2 = 90;
			UsuarioTipoDTO tipo2 = UsuarioTipoDTO.FACEBOOK;
			
			fachada.registrarFacebook(nombre2, email2, fechaNac2, peso2, altura2, fcm2, frm2, tipo2);
			
			//Login Local
//			String email3 = "alvaro@hotmail.es";
//			String contrasena2 = "aaaa";
//			
//			token = fachada.loginLocal(email, contrasena);
//			System.out.println(token);
			
			//Login Google
			
			token = fachada.loginGoogle(email5);
			System.out.println(token);
			
			//Crear SesionEntrenamiento
			
			SesionEntrenamientoDTO sesionNuevo = new SesionEntrenamientoDTO();
			
			sesionNuevo.setTitulo("Ruta por el monte");
			sesionNuevo.setUsuario(nombre1);
			sesionNuevo.setCodigo(1);
			sesionNuevo.setDeporte(DeporteDTO.CICLISMO);
			sesionNuevo.setDistancia(50);
			sesionNuevo.setDuracion(40);
			sesionNuevo.setsFechaYHoraIni("31-01-2002 18:56");
			
			
			fachada.crearSesionEntrenamiento(token, sesionNuevo);
			
			//Crear Reto
			RetoDTO retoNuevo = new RetoDTO();
			
			retoNuevo.setCodigo(2);
			retoNuevo.setDeporte(DeporteDTO.CICLISMO);
			retoNuevo.setDistancia(100);
			retoNuevo.setEstado(true);
			retoNuevo.setNombre("Vuelta ciclista");
			retoNuevo.setSfechaFin("05-05-2005");
			retoNuevo.setSfechaIni("01-01-2002");
			retoNuevo.setTiempoObjetivo(30);
			retoNuevo.setUsuario(nombre1);
			
			fachada.crearReto(token, retoNuevo);
			
			//Obtener Retos Activos
			retosActivos = fachada.obtenerRetosActivos(token);
			
			//Aceptar Reto
			//fachada.aceptarReto(token, retoDTO);
			
			//Logout
			fachada.logout(token);
			
			//Comprobacion sesiones
			sesiones = fachada.getSesiones();
			System.out.println(sesiones);
			
			//Comprobacion sesiones
			retos = fachada.getRetos();
			System.out.println(retos);	
			
		}catch (Exception e){
			
			System.out.println("\t# Error: " + e.getMessage());	
			
		}
		
		System.exit(0);
	}
}
