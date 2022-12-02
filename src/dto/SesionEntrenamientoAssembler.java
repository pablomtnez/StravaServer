package dto;

import java.util.ArrayList;
import java.util.List;

import clases.Deporte;
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
		dto.setCodigo(sesionEntrenamiento.getCodigo());
		
		if(sesionEntrenamiento.getDeporte().equals(Deporte.CICLISMO)) {
			dto.setDeporte(DeporteDTO.CICLISMO);
		}else if(sesionEntrenamiento.getDeporte().equals(Deporte.RUNNING)){	
			dto.setDeporte(DeporteDTO.RUNNING);
		}
		
		return dto;
	}
	
	public SesionEntrenamiento dtoToSesionEntrenamiento(SesionEntrenamientoDTO dto) {
		
		SesionEntrenamiento sesion = new SesionEntrenamiento();
		
		sesion.setUsuario(dto.getUsuario());
		sesion.setTitulo(dto.getTitulo());
		sesion.setDistancia(dto.getDistancia());
		sesion.setsFechaYHoraIni(dto.getsFechaYHoraIni());
		sesion.setDuracion(dto.getDuracion());
		sesion.setCodigo(dto.getCodigo());
		
		if(dto.getDeporte().equals(DeporteDTO.CICLISMO)) {
			sesion.setDeporte(Deporte.CICLISMO);
		}else if(dto.getDeporte().equals(DeporteDTO.RUNNING)){	
			sesion.setDeporte(Deporte.RUNNING);
		}
		
		return sesion;
	}
	
	public List<SesionEntrenamientoDTO> sesionEntrenamientoToDTO(List<SesionEntrenamiento> sesiones) {
		List<SesionEntrenamientoDTO> dtos = new ArrayList<>();
		
		for (SesionEntrenamiento sesion : sesiones) {
			dtos.add(this.sesionEntrenamientoToDTO(sesion));
		}
		
		return dtos;		
	}
	
	public List<SesionEntrenamiento> dtoToSesionEntrenamiento(List<SesionEntrenamientoDTO> dtos) {
		List<SesionEntrenamiento> sesiones = new ArrayList<>();
		
		for (SesionEntrenamientoDTO dto : dtos) {
			sesiones.add(this.dtoToSesionEntrenamiento(dto));
		}
		
		return sesiones;		
	}
	

}
