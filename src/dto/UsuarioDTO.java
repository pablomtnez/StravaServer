package dto;

import java.io.Serializable;

public class UsuarioDTO  implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String email;
	private String fechaNac;
	private double peso;
	private double altura;
	private double fcm;
	private double fcr;
	private UsuarioTipoDTO UsuarioTipo;
	
	public UsuarioDTO(String nombre, String email, String fechaNac, double peso, double altura, double fcm, double fcr,
			UsuarioTipoDTO usuarioTipo) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.fechaNac = fechaNac;
		this.peso = peso;
		this.altura = altura;
		this.fcm = fcm;
		this.fcr = fcr;
		UsuarioTipo = usuarioTipo;
	}
	
	public UsuarioDTO() {
		super();
		this.nombre = "";
		this.email = "";
		this.fechaNac = "";
		this.peso = 0;
		this.altura = 0;
		this.fcm = 0;
		this.fcr = 0;
		UsuarioTipo = null;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getFcm() {
		return fcm;
	}
	public void setFcm(double fcm) {
		this.fcm = fcm;
	}
	public double getFcr() {
		return fcr;
	}
	public void setFcr(double fcr) {
		this.fcr = fcr;
	}
	public UsuarioTipoDTO getUsuarioTipo() {
		return UsuarioTipo;
	}
	public void setUsuarioTipo(UsuarioTipoDTO usuarioTipo) {
		UsuarioTipo = usuarioTipo;
	}
	@Override
	public String toString() {
		return "UsuarioDTO [nombre=" + nombre + ", email=" + email + ", fechaNac=" + fechaNac + ", peso=" + peso
				+ ", altura=" + altura + ", fcm=" + fcm + ", fcr=" + fcr + ", UsuarioTipo=" + UsuarioTipo + "]";
	}
}
