package dto;

import java.io.Serializable;

import clases.Deporte;
import clases.Usuario;

public class SesionEntrenamientoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	private String titulo;
	private Deporte deporte;
	private float distancia;
	private String sFechaYHoraIni;
	private float duracion;
	private int codigo;
	
	
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
	public Deporte getDeporte() {
		return deporte;
	}
	public void setDeporte(Deporte deporte) {
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
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	@Override
	public String toString() {
		return "SesionEntrenamientoDTO [usuario=" + usuario + ", titulo=" + titulo + ", deporte=" + deporte
				+ ", distancia=" + distancia + ", sFechaYHoraIni=" + sFechaYHoraIni + ", duracion=" + duracion
				+ ", codigo=" + codigo + "]";
	}
	
	
}
