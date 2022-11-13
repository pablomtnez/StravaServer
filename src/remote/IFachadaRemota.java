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
	public void logout(Long token) throws RemoteException;
	public List<Reto> obtenerRetosActivos(String nombre, Date fechaIni, boolean estado) throws RemoteException;
	public boolean aceptarReto(String nombre) throws RemoteException;
	

}
