package services;

//import java.lang.invoke.ClassSpecializer.Factory;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import clases.Usuario;
import clases.UsuarioLocal;
import clases.UsuarioTipo;

public class LoginAppService {

//	private List<Usuario> listaUsuarios = new ArrayList<>();
//	private List<UsuarioLocal> listaUsuariosLocales = new ArrayList<>();

	private static Map<String, Usuario> mapaUsuario = new HashMap<>();
	public static LoginAppService instance;
	
	public LoginAppService() {
//		this.initilizeData();
	}
	
//	private void initilizeData() {
//		
//	}
	
	public static LoginAppService getInstance() {
		if(instance == null) {
			instance = new LoginAppService();	
		}
		
		return instance;
	}
	
//	//LOCAL
//	
//		//Login
//		
//	public UsuarioLocal loginLocal(String email, String contrasena) {
//		try {
//			for(UsuarioLocal uL : listaUsuariosLocales) {
//				if(email == uL.getEmail() && contrasena == uL.getContrasena()) {
//					return uL;
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("# LogIn error: " + e);
//			return null;
//		}
//		return null;
//	}
//	
//		//Registro
//	
//	public boolean registrarLocal(UsuarioLocal usuarioLocal) {
//		if (usuarioLocal != null && !listaUsuariosLocales.contains(usuarioLocal)) {
//			listaUsuariosLocales.add(usuarioLocal);
//			return true;
//		}else {
//			return false;
//		}
//	}
//	
//	
//	//GOOGLE
//	
//		//Login
//	
//	public Usuario loginGoogle(String email) {
//		try {
//			for(Usuario u : listaUsuarios) {
//				if(email == u.getEmail()) {
//					return u;
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("# LogIn error: " + e);
//			return null;
//		}
//		return null;
//	}
//	
//		//Registrar
//	
//	public boolean registrarGoogle(Usuario usuario) {
//		if (usuario != null && !listaUsuarios.contains(usuario) && usuario.getUsuarioTipo() == UsuarioTipo.GOOGLE) {
//			listaUsuarios.add(usuario);
//			return true;
//		}else {
//			return false;
//		}
//		
//	}
//	
//	
//	//FACEBOOK
//	
//		//Login
//	
//	public Usuario loginFacebook(String email) {
//		try {
//			for(Usuario u : listaUsuarios) {
//				if(email == u.getEmail()) {
//					return u;
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("# LogIn error: " + e);
//			return null;
//		}
//		return null;
//	}
//	
//		//Registro
//	
//	public boolean registrarFacebook(Usuario usuario) {
//		if (usuario != null && !listaUsuarios.contains(usuario) && usuario.getUsuarioTipo() == UsuarioTipo.FACEBOOK) {
//			listaUsuarios.add(usuario);
//			return true;
//		}else {
//			return false;
//		}
//	}
//}
	
	//Cambiamos todos los logIn y registros de local, Google y Facebook por uno conjunto:
	public Usuario logIn(String email, String contrasena) {
		try {
			if(mapaUsuario.containsKey(email)) {
				Usuario u = mapaUsuario.get(email);
				
			}
		} catch (Exception e){
			System.out.println("# LogIn error: " + e);
			return null;
		}
		return null;
		
	}
	
	public static Map<String, Usuario> getMapaUsuario(){
		return mapaUsuario;
	}
	
	public boolean logIn2(String email, String contrasena) throws RemoteException {
		if(mapaUsuario.containsKey(email)) {
			UsuarioLocal uL = (UsuarioLocal) mapaUsuario.get(email);
			if(uL.comprobarContrasena(contrasena)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean registro(Usuario usuario) {
		if(mapaUsuario.containsKey(usuario.getEmail())) {
			return false;
		}
		mapaUsuario.put(usuario.getEmail(), usuario);
		return true;
	}
}
