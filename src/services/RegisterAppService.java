package services;

import clases.Usuario;

public class RegisterAppService {
	
	public  Usuario register(String email, String contrasena) {
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre("Juan");
		usuario.setEmail("juan@gmail.com");
		usuario.setContrasena("1234");
		usuario.setsFechaNac("15-04-2002");
		usuario.setPeso(78);
		usuario.setAltura(167);
		usuario.setFcm(190);
		usuario.setFcr(100);
		
		if (usuario.getEmail().equals(email)) {	
			return null;
		} else {
			return usuario;
		}


	}
}
