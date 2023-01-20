package clases;

import java.util.Date;
import java.util.List;

public class UsuarioLocal extends Usuario {
	
	private String contrasena;

	public UsuarioLocal(String nombre, String email, Date fechaNac, double peso, double altura, double fcm, double fcr,
			clases.UsuarioTipo usuarioTipo, List<Reto> retos, List<SesionEntrenamiento> sesiones,
			List<Reto> retosActivos, String contrasena) {
		super(nombre, email, fechaNac, peso, altura, fcm, fcr, usuarioTipo, retos, sesiones, retosActivos);
		this.contrasena = contrasena;
	}

	public UsuarioLocal() {
		super();
	}


	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public boolean comprobarContrasena(String contrasena) {
		return this.contrasena.equals(contrasena);
	}
}
