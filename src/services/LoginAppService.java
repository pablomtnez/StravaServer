package services;

import java.util.ArrayList;
import java.util.List;

import clases.Usuario;
import clases.UsuarioLocal;
import clases.UsuarioTipo;

public class LoginAppService {

	private List<Usuario> listaUsuarios = new ArrayList<>();
	private List<UsuarioLocal> listaUsuariosLocales = new ArrayList<>();
	public static LoginAppService instance;
	
	public LoginAppService() {
		this.initilizeData();
	}
	
	private void initilizeData() {
		
	}
	
	public static LoginAppService getInstance() {
		if(instance == null) {
			instance = new LoginAppService();	
		}
		
		return instance;
	}
	
	//LOCAL
	
		//Login
		
	public UsuarioLocal loginLocal(String email, String contrasena) {
		try {
			for(UsuarioLocal uL : listaUsuariosLocales) {
				if(email == uL.getEmail() && contrasena == uL.getContrasena()) {
					return uL;
				}
			}
		} catch (Exception e) {
			System.out.println("# LogIn error: " + e);
			return null;
		}
		return null;
	}
	
		//Registro
	
	public boolean registrarLocal(UsuarioLocal usuarioLocal) {
		if (usuarioLocal != null && !listaUsuariosLocales.contains(usuarioLocal)) {
			listaUsuariosLocales.add(usuarioLocal);
			return true;
		}else {
			return false;
		}
	}
	
	
	//GOOGLE
	
		//Login
	
	public Usuario loginGoogle(String email) {
		try {
			for(Usuario u : listaUsuarios) {
				if(email == u.getEmail()) {
					return u;
				}
			}
		} catch (Exception e) {
			System.out.println("# LogIn error: " + e);
			return null;
		}
		return null;
	}
	
		//Registrar
	
	public boolean registrarGoogle(Usuario usuario) {
		if (usuario != null && !listaUsuarios.contains(usuario) && usuario.getUsuarioTipo() == UsuarioTipo.GOOGLE) {
			listaUsuarios.add(usuario);
			return true;
		}else {
			return false;
		}
		
	}
	
	
	//FACEBOOK
	
		//Login
	
	public Usuario loginFacebook(String email) {
		try {
			for(Usuario u : listaUsuarios) {
				if(email == u.getEmail()) {
					return u;
				}
			}
		} catch (Exception e) {
			System.out.println("# LogIn error: " + e);
			return null;
		}
		return null;
	}
	
		//Registro
	
	public boolean registrarFacebook(Usuario usuario) {
		if (usuario != null && !listaUsuarios.contains(usuario) && usuario.getUsuarioTipo() == UsuarioTipo.FACEBOOK) {
			listaUsuarios.add(usuario);
			return true;
		}else {
			return false;
		}
	}
}
