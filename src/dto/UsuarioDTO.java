package dto;

import java.io.Serializable;
import java.util.Date;

public class UsuarioDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private Date fechaNac;
	private float peso;
	private float altura;
	private float fcm;
	private float fcr;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getFcm() {
		return fcm;
	}
	public void setFcm(float fcm) {
		this.fcm = fcm;
	}
	public float getFcr() {
		return fcr;
	}
	public void setFcr(float fcr) {
		this.fcr = fcr;
	}

}
