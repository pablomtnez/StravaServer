package dto;

import clases.Usuario;

public class UsuarioAssembler {
	
	private static UsuarioAssembler instance;
	
	private UsuarioAssembler() { }
	
	public static UsuarioAssembler getInstance() {
		if (instance ==  null) {
			instance = new UsuarioAssembler();
		}
		return instance;
	}
	
	public UsuarioDTO usuarioToDTO (Usuario usuario) {
		
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setNombre(null);
		dto.setEmail(null);
		dto.setContrasena(null);
		dto.setFechaNac(null);
		dto.setPeso(0);
		dto.setAltura(0);
		dto.setFcm(0);
		dto.setFcr(0);
		
		return dto;
	}
	

}
