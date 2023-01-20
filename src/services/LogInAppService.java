package services;

import java.util.ArrayList;
import java.util.List;

import clases.Usuario;
import clases.UsuarioLocal;
import clases.UsuarioTipo;
import dto.UsuarioAssembler;
import dto.UsuarioDTO;
import dto.UsuarioLocalAssembler;
import dto.UsuarioLocalDTO;
import dto.UsuarioTipoDTO;

public class LogInAppService {

	private List<Usuario> listaUsuarios = new ArrayList<>();
	private List<UsuarioLocal> listaUsuariosLocales = new ArrayList<>();
	public static LogInAppService instance;
	
	public LogInAppService() {
		this.initilizeData();
	}
	
	private void initilizeData() {
		
		UsuarioLocal usuario2 = new UsuarioLocal();
		
		usuario2.setNombre("Alvaro");
		usuario2.setEmail("alvaro@hotmail.es");
		usuario2.setContrasena("aaaa");
		
		UsuarioLocal usuario3 = new UsuarioLocal();
		
		usuario3.setNombre("Alicia");
		usuario3.setEmail("alicia@hotmail.es");
		usuario3.setContrasena("bbbb");
		
		listaUsuariosLocales.add(usuario2);
		listaUsuariosLocales.add(usuario3);
		
	}
	
	public static LogInAppService getInstance() {
		if(instance == null) {
			instance = new LogInAppService();	
		}
		
		return instance;
	}
	
	//LOCAL
	
		//Login
		
	public UsuarioLocal loginLocal(String email, String contrasena) {
		
		UsuarioLocal usuarioLocal = new UsuarioLocal();
		
		for (UsuarioLocal usuario : listaUsuariosLocales) {
			
			if(usuario.getEmail().equals(email) && usuario.getContrasena().equals(contrasena)) {
				
				usuarioLocal.setNombre(usuario.getNombre());
				usuarioLocal.setEmail(usuario.getEmail());
				usuarioLocal.setContrasena(usuario.getContrasena());
				usuarioLocal.setFechaNac(usuario.getFechaNac());
				usuarioLocal.setPeso(usuario.getPeso());
				usuarioLocal.setAltura(usuario.getAltura());
				usuarioLocal.setFcm(usuario.getFcm());
				usuarioLocal.setFcr(usuario.getFcr());
				usuarioLocal.setUsuarioTipo(UsuarioTipo.LOCAL);
				System.out.println(usuarioLocal.getNombre());
				return usuarioLocal;
				
				
			}else {
				return null;
			}
		}
		return usuarioLocal;
	}
	
		//Registro
	
	public boolean registrarLocal(String nombre, String email, String contrasena, String fechaNac, double peso,
			double altura, double fcm, double fcr, UsuarioTipoDTO usuarioTipo) {
		
		UsuarioLocalDTO usuarioDTO = new UsuarioLocalDTO();
		
		try {
			
			usuarioDTO.setNombre(nombre);
			usuarioDTO.setEmail(email);
			usuarioDTO.setContrasena(contrasena);
			usuarioDTO.setFechaNac(fechaNac);
			usuarioDTO.setPeso(peso);
			usuarioDTO.setFcm(fcm);
			usuarioDTO.setFcr(fcr);
			usuarioDTO.setUsuarioTipo(UsuarioTipoDTO.LOCAL);
			
			UsuarioLocalAssembler usuarioAssembler = new UsuarioLocalAssembler();
			UsuarioLocal usuario = usuarioAssembler.dtoToUsuarioLocal(usuarioDTO);
			listaUsuariosLocales.add(usuario);
			
			System.out.println("Se ha registrado correctamente el usuario LOCAL");
			System.out.println("Nombre: " + usuarioDTO.getNombre() + " Email: " + usuarioDTO.getEmail());
			
			return true;
		}catch (Exception e) {
			
			System.out.println("Error al crear el usuario");
			
			return false;
		}
		
	}
	
	
	//GOOGLE
	
		//Login
	
	public Usuario loginGoogle(String email) {
		
		Usuario usuarioGoogle = new Usuario();
		
		for (Usuario usuario : listaUsuarios) {
			
			if(usuario.getEmail().equals(email)) {
				
				usuarioGoogle.setNombre(usuario.getNombre());
				usuarioGoogle.setEmail(usuario.getEmail());
				usuarioGoogle.setFechaNac(usuario.getFechaNac());
				usuarioGoogle.setPeso(usuario.getPeso());
				usuarioGoogle.setAltura(usuario.getAltura());
				usuarioGoogle.setFcm(usuario.getFcm());
				usuarioGoogle.setFcr(usuario.getFcr());
				usuarioGoogle.setUsuarioTipo(UsuarioTipo.GOOGLE);
				
				return usuarioGoogle;
				
			}else {
				return null;
			}
		}
		return usuarioGoogle;
	}
	
		//Registrar
	
	public boolean registrarGoogle(String nombre, String email, String fechaNac, double peso, double altura,
			double fcm, double fcr, UsuarioTipoDTO usuarioTipo) {
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		
		try {
			
			usuarioDTO.setNombre(nombre);
			usuarioDTO.setEmail(email);
			usuarioDTO.setFechaNac(fechaNac);
			usuarioDTO.setPeso(peso);
			usuarioDTO.setFcm(fcm);
			usuarioDTO.setFcr(fcr);
			usuarioDTO.setUsuarioTipo(UsuarioTipoDTO.GOOGLE);
			
			UsuarioAssembler usuarioAssembler = new UsuarioAssembler();
			Usuario usuarioGoogle = usuarioAssembler.dtoToUsuario(usuarioDTO);
			listaUsuarios.add(usuarioGoogle);
			
			System.out.println("Se ha registrado correctamente el usuario de GOOGLE");
			System.out.println("Nombre: " + usuarioDTO.getNombre() + " Email: " + usuarioDTO.getEmail());
			
			return true;
		}catch (Exception e) {
			
			System.out.println("Error al crear el usuario");
			
			return false;
		}
		
	}
	
	
	//FACEBOOK
	
		//Login
	
	public Usuario loginFacebook(String email) {
		
		Usuario usuarioFacebook = new Usuario();
		
		for (Usuario usuario : listaUsuarios) {
			
			if(usuario.getEmail().equals(email)) {
				
				usuarioFacebook.setNombre(usuario.getNombre());
				usuarioFacebook.setEmail(usuario.getEmail());
				usuarioFacebook.setFechaNac(usuario.getFechaNac());
				usuarioFacebook.setPeso(usuario.getPeso());
				usuarioFacebook.setAltura(usuario.getAltura());
				usuarioFacebook.setFcm(usuario.getFcm());
				usuarioFacebook.setFcr(usuario.getFcr());
				usuarioFacebook.setUsuarioTipo(UsuarioTipo.FACEBOOK);
				
				return usuarioFacebook;
			}else {
				return null;
			}
		}
		
		return usuarioFacebook;	
	}
	
		//Registro
	
	public boolean registrarFacebook(String nombre, String email, String fechaNac, double peso, double altura,
			double fcm, double fcr, UsuarioTipoDTO usuarioTipo) {
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		
		try {
			
			usuarioDTO.setNombre(nombre);
			usuarioDTO.setEmail(email);
			usuarioDTO.setFechaNac(fechaNac);
			usuarioDTO.setPeso(peso);
			usuarioDTO.setFcm(fcm);
			usuarioDTO.setFcr(fcr);
			usuarioDTO.setUsuarioTipo(UsuarioTipoDTO.FACEBOOK);
			
			UsuarioAssembler usuarioAssembler = new UsuarioAssembler();
			Usuario usuarioFacebook = usuarioAssembler.dtoToUsuario(usuarioDTO);
			listaUsuarios.add(usuarioFacebook);
			
			System.out.println("Se ha registrado correctamente el usuario de FACEBOOK");
			System.out.println("Nombre: " + usuarioDTO.getNombre() + " Email: " + usuarioDTO.getEmail());
			
			return true;
		}catch (Exception e) {
			
			System.out.println("Error al crear el usuario");
			
			return false;
		}
		
	}
}
