package dto;

import clases.Usuario;

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
		dto.setUsuarioTipo(usuario.getUsuarioTipo());
		
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
		usuario.setUsuarioTipo(dto.getUsuarioTipo());
		
		return usuario;
		
	}
	

}
