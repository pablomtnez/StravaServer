package dto;

import java.io.Serializable;
import java.util.Date;

import clases.UsuarioTipo;

public class UsuarioDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String email;
	private String contrasena;
	private Date fechaNac; 
	private double peso;
	private double altura;
	private double fcm;	//Frecuencia cardiaca máxima
	private double fcr;	//Frecuencia cardiaca reposo
	private UsuarioTipo UsuarioTipo;
	private int proveedor;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getProveedor() {
		return proveedor;
	}
	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
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
	public UsuarioTipo getUsuarioTipo() {
		return UsuarioTipo;
	}
	public void setUsuarioTipo(UsuarioTipo usuarioTipo) {
		UsuarioTipo = usuarioTipo;
	}
	@Override
	public String toString() {
		return "UsuarioDTO [nombre=" + nombre + ", email=" + email + ", contrasena=" + contrasena + ", fechaNac="
				+ fechaNac + ", peso=" + peso + ", altura=" + altura + ", fcm=" + fcm + ", fcr=" + fcr
				+ ", UsuarioTipo=" + UsuarioTipo + "]";
	}
}
