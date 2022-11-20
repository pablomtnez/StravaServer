package clases;

public class UsuarioLocal extends Usuario {
	private String contrasena;

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean comprobarContrasena(String contrasena) {
		return this.contrasena.equals(contrasena);
	}

	@Override
	public String toString() {
		return "UsuarioLocal [contrasena=" + contrasena + ", getContrasena()=" + getContrasena() + ", getNombre()="
				+ getNombre() + ", getEmail()=" + getEmail() + ", getsFechaNac()=" + getFechaNac() + ", getPeso()="
				+ getPeso() + ", getAltura()=" + getAltura() + ", getFcm()=" + getFcm() + ", getFcr()=" + getFcr()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

	
	
	
	
}
