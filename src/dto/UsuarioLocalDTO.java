package dto;

import java.io.Serializable;

import clases.UsuarioLocal;

public class UsuarioLocalDTO extends UsuarioLocal implements Serializable {

	private static final long serialVersionUID = 1L;
		private String contrasena;
		
		public String getContrasena() {
			return contrasena;
		}
		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}
		
		@Override
		public String toString() {
			return "UsuarioLocalDTO [contrasena=" + contrasena + ", getContrasena()=" + getContrasena()
					+ ", toString()=" + super.toString() + ", getNombre()=" + getNombre() + ", getEmail()=" + getEmail()
					+ ", getsFechaNac()=" + getFechaNac() + ", getPeso()=" + getPeso() + ", getAltura()=" + getAltura()
					+ ", getFcm()=" + getFcm() + ", getFcr()=" + getFcr() + ", getSfechaNac()=" + getSfechaNac()
					+ ", getUsuarioTipo()=" + getUsuarioTipo() + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + "]";
		}
		
		
}
