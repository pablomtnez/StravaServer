package clases;

import java.util.Date;

public class SesionEntrenamiento {
	
	private Usuario usuario;
	
	private String titulo;
	private String deporte;
	private float distancia;
	private Date fechaIni;
	private float horaIni;
	private float duracion;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public float getDistancia() {
		return distancia;
	}
	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public float getHoraIni() {
		return horaIni;
	}
	public void setHoraIni(float horaIni) {
		this.horaIni = horaIni;
	}
	public float getDuracion() {
		return duracion;
	}
	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append("Usuario: ");
		result.append(this.usuario);
		result.append("Titulo: ");
		result.append(this.titulo);
		result.append(", Deporte: ");
		result.append(this.deporte);
		result.append(", Distancia: ");
		result.append(this.distancia);
		result.append(", Fecha inicio: ");
		result.append(this.fechaIni);
		result.append(", Hora inicio: ");
		result.append(this.horaIni);
		result.append(", Duracion: ");
		result.append(this.duracion);
		
		return result.toString();
	}
}
