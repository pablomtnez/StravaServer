package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import clases.Reto;
import clases.SesionEntrenamiento;

public interface IFachadaRemota extends Remote{
	/*ns si tienen que ser long*/
	public long registro(String email, String nombre, Date fechaNac, float peso, float altura, float fcm, float fcr)throws RemoteException;
	public long login(String email, String contrasena) throws RemoteException;
	public long logout(String token) throws RemoteException;
	public SesionEntrenamiento crearSesion(String titulo, String deporte, float distancia, Date fechaIni, float horaIni, float duracion) throws RemoteException;
	public Reto crearReto(String nombre, Date fechaIni, Date fechaFin, float distancia, float tiempoObjetivo, String deporte) throws RemoteException;
	public List<Reto> obtenerRetosActivos(String nombre, Date fechaIni) throws RemoteException;
	public boolean aceptarReto(String nombre) throws RemoteException;
	

}
