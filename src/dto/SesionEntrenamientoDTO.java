package dto;

import java.io.Serializable;
import java.util.Date;
import clases.Deporte;

public class SesionEntrenamientoDTO implements Serializable {
	
	private String titulo;
	private Deporte deporte;
	private double distancia;
	private Date sFyH;
	private double duracion;
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
		return "SesionEntrenamientoDTO [titulo=" + titulo + ", deporte=" + deporte + ", distancia=" + distancia
				+ ", sFyH=" + sFyH + ", duracion=" + duracion + "]";
	}
}
