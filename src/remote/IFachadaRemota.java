package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import dto.RetoDTO;
import dto.SesionEntrenamientoDTO;
import dto.UsuarioTipoDTO;

public interface IFachadaRemota extends Remote{
	
	public long loginLocal(String email, String contrasena) throws RemoteException;
	
	public long loginGoogle(String email) throws RemoteException;
	
	public long loginFacebook(String email) throws RemoteException;
	
	public boolean registrarLocal(String nombre, String email, String contrasena, String fechaNac, double peso, 
			double altura, double fcm, double fcr, UsuarioTipoDTO usuarioTipo) throws RemoteException;
	
	public boolean registrarGoogle(String nombre, String email, String fechaNac, double peso, double altura, 
			double fcm, double fcr, UsuarioTipoDTO usuarioTipo) throws RemoteException;
	
	public boolean registrarFacebook(String nombre, String email, String fechaNac, double peso, double altura, 
			double fcm, double fcr, UsuarioTipoDTO usuarioTipo) throws RemoteException;
	
	public void logout(long token) throws RemoteException;
	
	public List<SesionEntrenamientoDTO> getSesiones() throws RemoteException;
	
	public List<RetoDTO> getRetos() throws RemoteException;
	
	public boolean crearReto(long token, RetoDTO retoDTO) throws RemoteException;
	
	public boolean crearSesionEntrenamiento(long token, SesionEntrenamientoDTO sesionDTO) throws RemoteException;
	
	public boolean aceptarReto(long token, RetoDTO retoDto) throws RemoteException;
	
	public List<RetoDTO> obtenerRetosActivos(long token) throws RemoteException;
}
