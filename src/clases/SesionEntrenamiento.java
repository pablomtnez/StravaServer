package clases;

public class SesionEntrenamiento {
private String usuario;
	
	private String titulo;
	private Deporte deporte;
	private float distancia;
	private String sFechaYHoraIni;
	private float duracion;
	private int codigo;
	
	
	
	public SesionEntrenamiento(String usuario, String titulo, Deporte deporte, float distancia, String sFechaYHoraIni,
			float duracion, int codigo) {
		super();
		this.usuario = usuario;
		this.titulo = titulo;
		this.deporte = deporte;
		this.distancia = distancia;
		this.sFechaYHoraIni = sFechaYHoraIni;
		this.duracion = duracion;
		this.codigo = codigo;
	}
	
	public SesionEntrenamiento() {
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
		return "SesionEntrenamiento [usuario=" + usuario + ", titulo=" + titulo + ", deporte=" + deporte
				+ ", distancia=" + distancia + ", sFechaYHoraIni=" + sFechaYHoraIni + ", duracion=" + duracion
				+ ", codigo=" + codigo + "]";
	}
	
}
