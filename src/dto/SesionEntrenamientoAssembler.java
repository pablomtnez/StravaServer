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
	
	public static SesionEntrenamientoDTO sesionToDTO(SesionEntrenamiento sesion) {
		SesionEntrenamientoDTO dto = new SesionEntrenamientoDTO();
		
		dto.setDeporte(sesion.getDeporte());
		dto.setDistancia(sesion.getDistancia());
		dto.setDuracion(sesion.getDuracion());
		dto.setsFyH(sesion.getsFyH());
		dto.setTitulo(sesion.getTitulo());
		
		return dto;
	}
	
	public List<SesionEntrenamientoDTO> sesionToDTO (List<SesionEntrenamiento> sesiones){
		List<SesionEntrenamientoDTO> dtos = new ArrayList<>();
		
		for(SesionEntrenamiento sesion : sesiones) {
			dtos.add(sesionToDTO(sesion));
		}
		
		return dtos;
	}
}
