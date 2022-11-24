package dto;

import clases.Usuario;
import clases.UsuarioLocal;

public class UsuarioLocalAssembler {

	private static UsuarioLocalAssembler instance;
	
	private UsuarioLocalAssembler() {
		
	}
	
	public static UsuarioLocalAssembler getInstance() {
		if (instance ==  null) {
			instance = new UsuarioLocalAssembler();
		}
		return instance;
	}
	
	public UsuarioLocalDTO usuarioToDTO (UsuarioLocal usuario) {
		
		UsuarioLocalDTO dto = new UsuarioLocalDTO();
		
		dto.setNombre(null);
		dto.setEmail(null);
//		dto.setContrasena(null);
		dto.setFechaNac(null);
		dto.setPeso(0);
		dto.setAltura(0);
		dto.setFcm(0);
		dto.setFcr(0);
		dto.setUsuarioTipo(null);
		
		return dto;
	}
}
