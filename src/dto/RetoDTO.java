package dto;

import java.io.Serializable;
import java.util.Date;

import clases.Deporte;

public class RetoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private Date fechaIni;
	private Date fechaFin;
	private double distancia;
	private double tiempoObjetivo;
	private Deporte deporte;
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
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public double getTiempoObjetivo() {
		return tiempoObjetivo;
	}
	public void setTiempoObjetivo(double tiempoObjetivo) {
		this.tiempoObjetivo = tiempoObjetivo;
	}
	public Deporte getDeporte() {
		return deporte;
	}
	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}
	@Override
	public String toString() {
		return "RetoDTO [nombre=" + nombre + ", fechaIni=" + fechaIni + ", fechaFin=" + fechaFin + ", distancia="
				+ distancia + ", tiempoObjetivo=" + tiempoObjetivo + ", deporte=" + deporte + "]";
	}
}
