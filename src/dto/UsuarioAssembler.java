package dto;

import clases.Usuario;
import clases.UsuarioTipo;

public class UsuarioAssembler {
	
private static UsuarioAssembler instance;
	
	public UsuarioAssembler() { }
	
	public static UsuarioAssembler getInstance() {
		if (instance ==  null) {
			instance = new UsuarioAssembler();
		}
		return instance;
	}
	
	public UsuarioDTO usuarioToDTO (Usuario usuario) {
		
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setNombre(usuario.getNombre());
		dto.setEmail(usuario.getEmail());
		dto.setFechaNac(usuario.getFechaNac());
		dto.setPeso(usuario.getPeso());
		dto.setAltura(usuario.getAltura());
		dto.setFcm(usuario.getFcm());
		dto.setFcr(usuario.getFcr());
		
		if(usuario.getUsuarioTipo().equals(UsuarioTipo.LOCAL)) {
			dto.setUsuarioTipo(UsuarioTipoDTO.LOCAL);
		}else if(usuario.getUsuarioTipo().equals(UsuarioTipo.GOOGLE)) {
			dto.setUsuarioTipo(UsuarioTipoDTO.GOOGLE);
		}else if(usuario.getUsuarioTipo().equals(UsuarioTipo.FACEBOOK)) {
			dto.setUsuarioTipo(UsuarioTipoDTO.FACEBOOK);
		}
		
		return dto;
	}
	
	public Usuario dtoToUsuario(UsuarioDTO dto) {
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre(dto.getNombre());
		usuario.setEmail(dto.getEmail());
		usuario.setFechaNac(dto.getFechaNac());
		usuario.setPeso(dto.getPeso());
		usuario.setAltura(dto.getAltura());
		usuario.setFcm(dto.getFcm());
		usuario.setFcr(dto.getFcr());
		
		if(dto.getUsuarioTipo().equals(UsuarioTipoDTO.LOCAL)) {
			usuario.setUsuarioTipo(UsuarioTipo.LOCAL);
		}else if(dto.getUsuarioTipo().equals(UsuarioTipoDTO.GOOGLE)) {
			usuario.setUsuarioTipo(UsuarioTipo.GOOGLE);
		}else if(dto.getUsuarioTipo().equals(UsuarioTipoDTO.FACEBOOK)) {
			usuario.setUsuarioTipo(UsuarioTipo.FACEBOOK);
		}
		
		return usuario;
		
	}
	

}
