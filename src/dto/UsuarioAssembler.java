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
	
	private UsuarioDTO usuarioToDTO (Usuario usuario) {
		
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setAltura(usuario.getAltura());
		dto.setEmail(usuario.getEmail());
		dto.setFcm(usuario.getFcm());
		dto.setFcr(usuario.getFcr());
		dto.setFechaNac(usuario.getFechaNac());
		dto.setNombre(usuario.getNombre());
		dto.setPeso(usuario.getPeso());
		
		return dto;
	}
	
	public Usuario dtoToUsuario (UsuarioDTO dto) {
		
		Usuario usuario = new Usuario();
		
		usuario.setAltura(dto.getAltura());
		usuario.setEmail(dto.getEmail());
		usuario.setFcm(dto.getFcm());
		usuario.setFcr(dto.getFcr());
		usuario.setFechaNac(dto.getFechaNac());
		usuario.setNombre(dto.getNombre());
		usuario.setPeso(dto.getPeso());
		
		return usuario;
	}
	
}
