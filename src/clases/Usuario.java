package clases;

import java.util.Date;

public class Usuario {
	
	private String nombre;
	private Date fechaNac;
	private float peso;
	private float altura;
	private float fcm;	//Frecuencia cardiaca máxima
	private float fcr;	//Frecuencia cardiaca reposo
	
	
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
	
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append("Nombre: ");
		result.append(this.nombre);
		result.append(", Fecha Nacimiento");
		result.append(this.fechaNac);
		result.append(", Peso");
		result.append(this.peso);
		result.append(", Altura");
		result.append(this.altura);
		result.append(", FCM");
		result.append(this.fcm);
		result.append(", FCR");
		result.append(this.fcr);
		
		return result.toString();
	}
	
}
