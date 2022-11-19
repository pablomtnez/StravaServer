package services;

import clases.Usuario;
import clases.UsuarioLocal;

public class LogInAppService {
	
	public  Usuario login(String email, String contrasena) {
		
		UsuarioLocal usuario = new UsuarioLocal();
		
		usuario.setNombre("Juan");
		usuario.setEmail("juan@gmail.com");
		usuario.setContrasena("1234");
		usuario.setsFechaNac("15-04-2002");
		usuario.setPeso(78);
		usuario.setAltura(167);
		usuario.setFcm(190);
		usuario.setFcr(100);
		
		
		if (usuario.getEmail().equals(email) && usuario.comprobarContrasena(contrasena)) {		
			return usuario;
		} else {
			return null;
		}
	}
	

}
