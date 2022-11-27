package dto;

import java.io.Serializable;

import clases.Deporte;

public class RetoDTO implements Serializable{

	@Override
	public String toString() {
		return "RetoDTO [nombre=" + nombre + ", fechaIni=" + fechaIni + ", fechaFin=" + fechaFin + ", distancia="
				+ distancia + ", tiempoObjetivo=" + tiempoObjetivo + ", deporte=" + deporte + ", estado=" + estado
				+ ", codigo=" + codigo + "]";
	}
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String fechaIni;
	private String fechaFin;
	private float distancia;
	private float tiempoObjetivo;
	private DeporteDTO deporte;
	private boolean estado;
	private int codigo;
	
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
	public DeporteDTO getDeporte() {
		return deporte;
	}
	public void setDeporte(DeporteDTO deporteDTO) {
		this.deporte = deporteDTO;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
