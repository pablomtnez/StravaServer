package dto;

import java.io.Serializable;

public class SesionEntrenamientoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	
	private String titulo;
	private DeporteDTO deporte;
	private float distancia;
	private String sFechaYHoraIni;
	private float duracion;
	private int codigo;
	
	public SesionEntrenamientoDTO(String usuario, String titulo, DeporteDTO deporte, float distancia,
			String sFechaYHoraIni, float duracion, int codigo) {
		super();
		this.usuario = usuario;
		this.titulo = titulo;
		this.deporte = deporte;
		this.distancia = distancia;
		this.sFechaYHoraIni = sFechaYHoraIni;
		this.duracion = duracion;
		this.codigo = codigo;
	}
	
	public SesionEntrenamientoDTO() {
		super();
		this.usuario = "";
		this.titulo = "";
		this.deporte = null;
		this.distancia = 0;
		this.sFechaYHoraIni = "";
		this.duracion = 0;
		this.codigo = 0;
	}

	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public DeporteDTO getDeporte() {
		return deporte;
	}


	public void setDeporte(DeporteDTO deporte) {
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
