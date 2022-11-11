package services;

import clases.SesionEntrenamiento;
import clases.Usuario;

public class StravaAppService {
	
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
		
	}

}
