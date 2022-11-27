package clases;

public class Usuario {
	
	private String nombre;
	private UsuarioTipo UsuarioTipo;
	private String email;
	private String fechaNac; 
	private double peso;
	private double altura;
	private double fcm;	//Frecuencia cardiaca máxima
	private double fcr;	//Frecuencia cardiaca reposo
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String sfechaNac) {
		this.fechaNac = sfechaNac;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getFcm() {
		return fcm;
	}
	public void setFcm(double fcm) {
		this.fcm = fcm;
	}
	public double getFcr() {
		return fcr;
	}
	public void setFcr(double fcr) {
		this.fcr = fcr;
	}
	public String getSfechaNac() {
		return fechaNac;
	}
	public UsuarioTipo getUsuarioTipo() {
		return UsuarioTipo;
	}
	public void setUsuarioTipo(UsuarioTipo usuarioTipo) {
		UsuarioTipo = usuarioTipo;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append("Nombre: ");
		result.append(this.nombre);
		result.append(", Email: ");
		result.append(this.email);
		result.append(", Fecha Nacimiento: ");
		result.append(this.fechaNac);
		result.append(", Peso: ");
		result.append(this.peso);
		result.append(", Altura: ");
		result.append(this.altura);
		result.append(", FCM: ");
		result.append(this.fcm);
		result.append(", FCR: ");
		result.append(this.fcr);
		result.append(", Tipo Usuario: ");
		result.append(this.UsuarioTipo);
		return result.toString();
	}
	
}
