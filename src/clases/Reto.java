package clases;

import java.util.Date;

public class Reto {
	
	private Usuario usuario;
	
	private SesionEntrenamiento sesionEntrenamiento;
	
	private String nombre;
	private Date fechaIni;
	private Date fechaFin;
	private float distancia;
	private float tiempoObjetivo;
	private String deporte;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public SesionEntrenamiento getSesionEntrenamiento() {
		return sesionEntrenamiento;
	}
	public void setSesionEntrenamiento(SesionEntrenamiento sesionEntrenamiento) {
		this.sesionEntrenamiento = sesionEntrenamiento;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public float getDistancia() {
		return distancia;
	}
	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	public float getTiempoObjetivo() {
		return tiempoObjetivo;
	}
	public void setTiempoObjetivo(float tiempoObjetivo) {
		this.tiempoObjetivo = tiempoObjetivo;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	
	

}
