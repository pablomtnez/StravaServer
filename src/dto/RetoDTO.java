package dto;

import java.io.Serializable;

public class RetoDTO implements Serializable{

private static final long serialVersionUID = 1L;
	
	private String usuario;
	
	private String nombre;
	private String sfechaIni;
	private String sfechaFin;
	private float distancia;
	private float tiempoObjetivo;
	private DeporteDTO deporte;
	private boolean estado;
	private int codigo;
	
	public RetoDTO(String usuario, String nombre, String sfechaIni, String sfechaFin, float distancia,
			float tiempoObjetivo, DeporteDTO deporte, boolean estado, int codigo) {
		super();
		this.usuario = usuario;
		this.nombre = nombre;
		this.sfechaIni = sfechaIni;
		this.sfechaFin = sfechaFin;
		this.distancia = distancia;
		this.tiempoObjetivo = tiempoObjetivo;
		this.deporte = deporte;
		this.estado = estado;
		this.codigo = codigo;
	}
	
	public RetoDTO() {
		super();
		this.usuario = "";
		this.nombre = "";
		this.sfechaIni = "";
		this.sfechaFin = "";
		this.distancia = 0;
		this.tiempoObjetivo = 0;
		this.deporte = null;
		this.estado = false;
		this.codigo = 0;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
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

	public DeporteDTO getDeporte() {
		return deporte;
	}

	public void setDeporte(DeporteDTO deporte) {
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
