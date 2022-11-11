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
	private boolean estado;
	
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
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append("Usuario: ");
		result.append(this.usuario);
		result.append("Sesion entrenamiento: ");
		result.append(this.sesionEntrenamiento);
		result.append(", Nombre: ");
		result.append(this.nombre);
		result.append(", Fecha inicio: ");
		result.append(this.fechaIni);
		result.append(", Fecha final: ");
		result.append(this.fechaFin);
		result.append(", Distancia: ");
		result.append(this.distancia);
		result.append(", Tiempo Objetivo: ");
		result.append(this.tiempoObjetivo);
		result.append(", Deporte: ");
		result.append(this.deporte);
		result.append("Estado: ");
		result.append(this.estado);
		
		return result.toString();
	}
	
	public void crearReto() {
		
	}
	
	public void obtenerRetosActivos() {
		
	}
	
	public void consultarRetos() {
		
	}
	
	public void aceptarReto() {
		
	}
	

}
