package services;

import clases.Usuario;
import clases.UsuarioLocal;
import dto.UsuarioLocalDTO;

public class LogInAppService {
	
	public  UsuarioLocalDTO login(String email, String contrasena) {
		
		UsuarioLocalDTO usuario = new UsuarioLocalDTO();
		
		usuario.setNombre("Juan");
		usuario.setEmail("juan@gmail.com");
		usuario.setContrasena("1234");
		usuario.setFechaNac("15-04-2002");
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
