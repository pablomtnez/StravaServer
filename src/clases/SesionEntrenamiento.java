package clases;

import java.io.Serializable;
import java.util.Date;

public class SesionEntrenamiento implements Serializable{
	
	private String titulo;
	private Deporte deporte;
	private double distancia;
	private Date sFyH;
	private double duracion;
	
	public SesionEntrenamiento(String titulo, Deporte deporte, double distancia, Date sFyH, double duracion) {
		super();
		this.titulo = titulo;
		this.deporte = deporte;
		this.distancia = distancia;
		this.sFyH = sFyH;
		this.duracion = duracion;
	}
	
	public SesionEntrenamiento() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public Date getsFyH() {
		return sFyH;
	}

	public void setsFyH(Date sFyH) {
		this.sFyH = sFyH;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "SesionEntrenamiento [titulo=" + titulo + ", deporte=" + deporte + ", distancia=" + distancia + ", sFyH="
				+ sFyH + ", duracion=" + duracion + "]";
	}
	
}
