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
	
	public void crearManualSesionEntre() {
		
	}
	

}
