package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import clases.Reto;
//import clases.SesionEntrenamiento;
//import clases.SesionEntrenamiento;
//import clases.UsuarioLocal;
//import clases.Reto;
import dto.RetoDTO;
import dto.SesionEntrenamientoDTO;
//import dto.UsuarioDTO;
import dto.UsuarioLocalDTO;

public interface IFachadaRemota extends Remote{
	/*ns si tienen que ser long*/
	//public long registro(String email, String contrasena, String nombre, String fechaNac, float peso, float altura, float fcm, float fcr)throws RemoteException;
	//Pensar si pasar un Usuario DTO
	public long registro(UsuarioLocalDTO usuario) throws RemoteException;	
	//De momento se queda como UsuarioDTO pero habrá que cambiarlo a UsuarioLocalDTO
	
//	public long login(String email, String contrasena) throws RemoteException;
	public long login(UsuarioLocalDTO usuario) throws RemoteException;
	
	public void logout(long token) throws RemoteException;
	
	public List<SesionEntrenamientoDTO> getSesiones(long token) throws RemoteException;
	//Filtrar - usar Token (vinculado a un usuario que previamente ha hecho registro)
	
	public List<RetoDTO> getRetos(long token) throws RemoteException;
	//Filtrar - usar Token (vinculado a un usuario que previamente ha hecho registro)
	
	public List<Reto> obtenerRetosActivos(long token) throws RemoteException;
	
	public boolean aceptarReto(long token, RetoDTO retoDto) throws RemoteException;
	
	//Devuelve el reto
	//public Reto crearReto(String nombre, String sfechaIni, String sfechaFin, float distancia, float tiempoObjetivo, String deporte, boolean estado) throws RemoteException;
	public boolean crearReto(long token, RetoDTO nuevoReto) throws RemoteException;
	
	//Devuelve la sesión de entrenamiento
	//public SesionEntrenamiento crearSesionEntrenamiento(String titulo, String deporte, float distancia, String sFechaYHoraIni, float duracion) throws RemoteException;
	public boolean crearSesionEntrenamiento(long token, SesionEntrenamientoDTO nuevaSesion) throws RemoteException;
}
