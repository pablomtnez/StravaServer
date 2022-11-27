package dto;

import java.io.Serializable;

import clases.Deporte;
import clases.Usuario;

public class RetoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	private String nombre;
	private String sfechaIni;
	private String sfechaFin;
	private float distancia;
	private float tiempoObjetivo;
	private Deporte deporte;
	private boolean estado;
	private int codigo;
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSfechaIni() {
		return sfechaIni;
	}
	public void setSfechaIni(String sfechaIni) {
		this.sfechaIni = sfechaIni;
	}
	public String getSfechaFin() {
		return sfechaFin;
	}
	public void setSfechaFin(String sfechaFin) {
		this.sfechaFin = sfechaFin;
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
	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
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
	@Override
	public String toString() {
		return "RetoDTO [usuario=" + usuario + ", nombre=" + nombre + ", sfechaIni=" + sfechaIni + ", sfechaFin="
				+ sfechaFin + ", distancia=" + distancia + ", tiempoObjetivo=" + tiempoObjetivo + ", deporte=" + deporte
				+ ", estado=" + estado + ", codigo=" + codigo + "]";
	}	
	
	
}
