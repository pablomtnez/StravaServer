package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.RetoDTO;
import dto.SesionEntrenamientoDTO;
import dto.UsuarioDTO;

public interface IFachadaRemota extends Remote{
	
	/*public void registarLocal(UsuarioDTO dto) throws RemoteException;
	
	public void registarFacebook(UsuarioDTO dto) throws RemoteException;
	
	public void registrarGoogle(UsuarioDTO dto) throws RemoteException;
	
	Combinamos los registros específicos de cada uno que teníamos y creamos un único:
	*/
	public void registrar(UsuarioDTO dto) throws RemoteException;

	/*
	public long loginLocal(String email, String contrasena) throws RemoteException;
	
	public long loginFacebook(String email) throws RemoteException;	
	
	public long loginGoogle(String email) throws RemoteException;
	
	Combinamos los inicios de sesión específicos de cada uno y creamos uno común:
	*/
	public long logIn(String email, String contrasena) throws RemoteException;
	
	
	public void logout(long token) throws RemoteException;
	
	public List<RetoDTO> getReto(long token) throws RemoteException;
	
	public List<RetoDTO> obtenerRetosActivos(long token) throws RemoteException;
	
	public List<SesionEntrenamientoDTO> getSesiones(long token) throws RemoteException;
	
	public void crearSesion(SesionEntrenamientoDTO dto, long token) throws RemoteException;
	
	public void crearReto(RetoDTO dto, long token) throws RemoteException;
	
	public void aceptarReto(String nombre, long token) throws RemoteException;
}
