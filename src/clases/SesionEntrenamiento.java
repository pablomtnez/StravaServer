package clases;

public class SesionEntrenamiento {
	
	private Usuario usuario;
	
	private String titulo;
	private Deporte deporte;
	private float distancia;
	private String sFechaYHoraIni;
	private float duracion;
	
	
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
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append("Usuario: ");
		result.append(this.usuario);
		result.append("Titulo: ");
		result.append(this.titulo);
		result.append(", Deporte: ");
		result.append(this.deporte);
		result.append(", Distancia: ");
		result.append(this.distancia);
		result.append(", Fecha y Hora de inicio: ");
		result.append(this.sFechaYHoraIni);
		result.append(", Duracion: ");
		result.append(this.duracion);
		
		return result.toString();
	}
}
