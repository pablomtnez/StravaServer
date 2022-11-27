package clases;

import dto.DeporteDTO;

public class Reto {
	
	private Usuario usuario;
	
	private SesionEntrenamiento sesionEntrenamiento;
	
	private String nombre;
	private String sfechaIni;
	private String sfechaFin;
	private float distancia;
	private float tiempoObjetivo;
	private DeporteDTO deporte;	//Añadimos así el enum?
	private boolean estado;
	private int codigo;	//Aplicarlo en todas las clases necesarias
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public SesionEntrenamiento getSesionEntrenamiento() {
		return sesionEntrenamiento;
	}
	public void setSesionEntrenamiento(SesionEntrenamiento sesionEntrenamiento) {
		this.sesionEntrenamiento = sesionEntrenamiento;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getsFechaIni() {
		return sfechaIni;
	}
	public void setsFechaIni(String sfechaIni) {
		this.sfechaIni = sfechaIni;
	}
	public String getsFechaFin() {
		return sfechaFin;
	}
	public void setsFechaFin(String sfechaFin) {
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
	
	//Así el enum de deporte?
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
		StringBuffer result = new StringBuffer();
		
//		result.append("Usuario: ");
//		result.append(this.usuario);
//		result.append("Sesion entrenamiento: ");
//		result.append(this.sesionEntrenamiento);
		result.append("Nombre: ");
		result.append(this.nombre);
		result.append(", Fecha inicio: ");
		result.append(this.sfechaIni);
		result.append(", Fecha final: ");
		result.append(this.sfechaFin);
		result.append(", Distancia: ");
		result.append(this.distancia);
		result.append(", Tiempo Objetivo: ");
		result.append(this.tiempoObjetivo);
		result.append(", Deporte: ");
		result.append(this.deporte);
		result.append(", Estado: ");
		result.append(this.estado);
		
		return result.toString();
	}
	
	
}
