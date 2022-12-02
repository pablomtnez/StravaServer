package dto;

import clases.UsuarioLocal;
import clases.UsuarioTipo;

public class UsuarioLocalAssembler {

	private static UsuarioLocalAssembler instance;
	
	public UsuarioLocalAssembler() {
		
	}
	
	public static UsuarioLocalAssembler getInstance() {
		if (instance ==  null) {
			instance = new UsuarioLocalAssembler();
		}
		return instance;
	}
	
	public UsuarioLocalDTO usuarioToDTO (UsuarioLocal usuario) {
		
		UsuarioLocalDTO dto = new UsuarioLocalDTO();
		
		dto.setNombre(usuario.getNombre());
		dto.setEmail(usuario.getEmail());
		dto.setContrasena(usuario.getContrasena());
		dto.setFechaNac(usuario.getFechaNac());
		dto.setPeso(usuario.getPeso());
		dto.setAltura(usuario.getAltura());
		dto.setFcm(usuario.getFcm());
		dto.setFcr(usuario.getFcr());
		dto.setUsuarioTipo(UsuarioTipoDTO.LOCAL);
		
		return dto;
	}
	
	public UsuarioLocal dtoToUsuarioLocal (UsuarioLocalDTO dto) {
		
		UsuarioLocal usuario = new UsuarioLocal();
		
		usuario.setNombre(dto.getNombre());
		usuario.setEmail(dto.getEmail());
		usuario.setContrasena(dto.getContrasena());
		usuario.setFechaNac(dto.getFechaNac());
		usuario.setPeso(dto.getPeso());
		usuario.setAltura(dto.getAltura());
		usuario.setFcm(dto.getFcm());
		usuario.setFcr(dto.getFcr());
		usuario.setUsuarioTipo(UsuarioTipo.LOCAL);
		
		return usuario;
	}
}
