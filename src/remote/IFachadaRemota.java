package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

//import clases.Reto;
import dto.RetoDTO;

public interface IFachadaRemota extends Remote{
	/*ns si tienen que ser long*/
	public long registro(String email,String contrasena, String nombre, String fechaNac, float peso, float altura, float fcm, float fcr)throws RemoteException;
	public long login(String email, String contrasena) throws RemoteException;
	public void logout(long token) throws RemoteException;
	public List<RetoDTO> obtenerRetosActivos() throws RemoteException;
	public boolean aceptarReto(long token, String nombre) throws RemoteException;
	
	

}
