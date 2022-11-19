package dto;

import java.io.Serializable;

import clases.Deporte;

public class RetoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String fechaIni;
	private String fechaFin;
	private float distancia;
	private float tiempoObjetivo;
	private Deporte deporte;
	private boolean estado;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
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
	public Deporte getDeporte() {
		return deporte;
	}
	public void setDeporte(Deporte deporte2) {
		this.deporte = deporte2;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
