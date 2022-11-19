package clases;



public class Usuario {
	
	private String nombre;
	private String email;
	//private String contrasena;
	private String sfechaNac; 
	private float peso;
	private float altura;
	private float fcm;	//Frecuencia cardiaca máxima
	private float fcr;	//Frecuencia cardiaca reposo
	
	//Cómo lo añadimos?
	private UsuarioTipo UsuarioTipo;
	
	
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
//	public String getContrasena() {
//		return contrasena;
//	}
//	public void setContrasena(String contrasena) {
//		this.contrasena = contrasena;
//	}
//	public boolean comprobarContrasena(String contrasena) {
//		return this.contrasena.equals(contrasena);
//	}
	public String getsFechaNac() {
		return sfechaNac;
	}
	public void setsFechaNac(String sfechaNac) {
		this.sfechaNac = sfechaNac;
	}
	
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getFcm() {
		return fcm;
	}
	public void setFcm(float fcm) {
		this.fcm = fcm;
	}
	public float getFcr() {
		return fcr;
	}
	public void setFcr(float fcr) {
		this.fcr = fcr;
	}
	public String getSfechaNac() {
		return sfechaNac;
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
		//result.append(", Contrasena: ");
		//Sresult.append(this.contrasena);
		result.append(", Fecha Nacimiento: ");
		result.append(this.sfechaNac);
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
