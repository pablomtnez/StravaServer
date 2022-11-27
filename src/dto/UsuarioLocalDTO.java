package dto;

import java.io.Serializable;


public class UsuarioLocalDTO extends UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
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
			return "UsuarioLocalDTO [contrasena=" + contrasena + ", getNombre()=" + getNombre() + ", getEmail()="
					+ getEmail() + ", getFechaNac()=" + getFechaNac() + ", getPeso()=" + getPeso() + ", getAltura()="
					+ getAltura() + ", getFcm()=" + getFcm() + ", getFcr()=" + getFcr() + ", getUsuarioTipo()="
					+ getUsuarioTipo() + "]";
		}
		
		
		
}
