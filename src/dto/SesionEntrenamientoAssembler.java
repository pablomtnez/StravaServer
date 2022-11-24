package dto;

import java.util.ArrayList;
import java.util.List;

import clases.SesionEntrenamiento;

public class SesionEntrenamientoAssembler {
	
private static SesionEntrenamientoAssembler instance;
	
	public SesionEntrenamientoAssembler() { }
	
	public static SesionEntrenamientoAssembler getInstance() {
		if (instance ==  null) {
			instance = new SesionEntrenamientoAssembler();
		}
		return instance;
	}
	
	public SesionEntrenamientoDTO sesionEntrenamientoToDTO (SesionEntrenamiento sesionEntrenamiento) {
		
		SesionEntrenamientoDTO dto = new SesionEntrenamientoDTO();
		
		dto.setUsuario(sesionEntrenamiento.getUsuario());
		dto.setTitulo(sesionEntrenamiento.getTitulo());
		dto.setDistancia(sesionEntrenamiento.getDistancia());
		dto.setsFechaYHoraIni(sesionEntrenamiento.getsFechaYHoraIni());
		dto.setDuracion(sesionEntrenamiento.getDuracion());
		
		return dto;
	}
	
	public SesionEntrenamiento dtoToSesionEntrenamiento(SesionEntrenamientoDTO dto) {
		
		SesionEntrenamiento sesion = new SesionEntrenamiento();
		
		sesion.setUsuario(dto.getUsuario());
		sesion.setTitulo(dto.getTitulo());
		sesion.setDistancia(dto.getDistancia());
		sesion.setsFechaYHoraIni(dto.getsFechaYHoraIni());
		sesion.setDuracion(dto.getDuracion());
		
		return sesion;
	}
	
	public List<SesionEntrenamientoDTO> sesionEntrenamientoToDTO(List<SesionEntrenamiento> sesiones) {
		List<SesionEntrenamientoDTO> dtos = new ArrayList<>();
		
		for (SesionEntrenamiento sesion : sesiones) {
			dtos.add(this.sesionEntrenamientoToDTO(sesion));
		}
		
		return dtos;		
	}
	

}
