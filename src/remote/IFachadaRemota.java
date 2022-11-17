package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import clases.Reto;
import clases.SesionEntrenamiento;
//import clases.Reto;
import dto.RetoDTO;
import dto.SesionEntrenamientoDTO;

public interface IFachadaRemota extends Remote{
	/*ns si tienen que ser long*/
	public long registro(String email, String contrasena, String nombre, String fechaNac, float peso, float altura, float fcm, float fcr)throws RemoteException;
	//Pensar si pasar un Usuario DTO
	
	public long login(String email, String contrasena) throws RemoteException;
	
	public void logout(long token) throws RemoteException;
	
	public List<SesionEntrenamientoDTO> getSesiones() throws RemoteException;
	//Filtrar - usar Token (vinculado a un usuario que previamente ha hecho Token)
	
	public List<RetoDTO> getRetos() throws RemoteException;
	//Filtrar - usar Token (vinculado a un usuario que previamente ha hecho Token)
	
	public List<RetoDTO> obtenerRetosActivos() throws RemoteException;
	
	public boolean aceptarReto(long token, String nombre) throws RemoteException;
	
	//Devuelve el reto
	public Reto crearReto(String nombre, String sfechaIni, String sfechaFin, float distancia, float tiempoObjetivo, String deporte, boolean estado) throws RemoteException;
	
	//Devuelve la sesión de entrenamiento
	public SesionEntrenamiento crearSesionEntrenamiento(String titulo, String deporte, float distancia, String sFechaYHoraIni, float duracion) throws RemoteException;
 
}
