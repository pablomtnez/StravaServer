package clases;

import java.io.Serializable;
import java.util.Date;

public class Reto implements Serializable{
	
	private String nombre;
	private Date fechaIni;
	private Date fechaFin;
	private double distancia;
	private double tiempoObjetivo;
	private Deporte deporte;
	
	public Reto(String nombre, Date fechaIni, Date fechaFin, double distancia, double tiempoObjetivo, Deporte deporte) {
		super();
		this.nombre = nombre;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.distancia = distancia;
		this.tiempoObjetivo = tiempoObjetivo;
		this.deporte = deporte;
	}
	
	public Reto() {
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
		return "Reto [nombre=" + nombre + ", fechaIni=" + fechaIni + ", fechaFin=" + fechaFin + ", distancia="
				+ distancia + ", tiempoObjetivo=" + tiempoObjetivo + ", deporte=" + deporte + "]";
	}
}