package clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario implements Serializable{
	
	private String nombre;
	private String email;
	private Date fechaNac; 
	private double peso;
	private double altura;
	private double fcm;	//Frecuencia cardiaca máxima
	private double fcr;	//Frecuencia cardiaca reposo
	private UsuarioTipo UsuarioTipo;
	private List<Reto> retos = new ArrayList<>();
	private List<SesionEntrenamiento> sesiones = new ArrayList<>();
	private List<Reto> retosActivos = new ArrayList<>();
	
	public Usuario(String nombre, String email, Date fechaNac, double peso, double altura, double fcm, double fcr,
			clases.UsuarioTipo usuarioTipo, List<Reto> retos, List<SesionEntrenamiento> sesiones,
			List<Reto> retosActivos) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.fechaNac = fechaNac;
		this.peso = peso;
		this.altura = altura;
		this.fcm = fcm;
		this.fcr = fcr;
		UsuarioTipo = usuarioTipo;
		this.retos = retos;
		this.sesiones = sesiones;
		this.retosActivos = retosActivos;
	}
	
	public Usuario() {
	}

	public Usuario(String nombre2, String email2, Date fechaNac2, double peso2, double altura2, double fcm2,
			double fcr2, clases.UsuarioTipo usuarioTipo2, int proveedor) {
		// TODO Auto-generated constructor stub
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

	public List<Reto> getRetos() {
		return retos;
	}

	public void setRetos(List<Reto> retos) {
		this.retos = retos;
	}
	
	public void anadirReto(Reto reto) {
		if(reto != null && !this.retos.contains(reto)) {
			retos.add(reto);
		}
	}

	public List<SesionEntrenamiento> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<SesionEntrenamiento> sesiones) {
		this.sesiones = sesiones;
	}
	
	public void anadirSesion(SesionEntrenamiento sesion) {
		if(sesion != null && !this.sesiones.contains(sesion)) {
			sesiones.add(sesion);
		}
	}

	public List<Reto> getRetosActivos() {
		return retosActivos;
	}

	public void setRetosActivos(List<Reto> retosActivos) {
		this.retosActivos = retosActivos;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", email=" + email + ", fechaNac=" + fechaNac + ", peso=" + peso
				+ ", altura=" + altura + ", fcm=" + fcm + ", fcr=" + fcr + ", UsuarioTipo=" + UsuarioTipo + ", retos="
				+ retos + ", sesiones=" + sesiones + ", retosActivos=" + retosActivos + "]";
	}
}