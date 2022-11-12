package dto;

import java.io.Serializable;

import clases.Usuario;

public class SesionEntrenamientoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	private String titulo;
	private String deporte;
	private float distancia;
	private String sFechaYHoraIni;
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
	public String getsFechaYHoraIni() {
		return sFechaYHoraIni;
	}
	public void setsFechaYHoraIni(String sFechaYHoraIni) {
		this.sFechaYHoraIni = sFechaYHoraIni;
	}
	public float getDuracion() {
		return duracion;
	}
	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

}
