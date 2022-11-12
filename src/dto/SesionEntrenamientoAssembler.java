package dto;

import clases.SesionEntrenamiento;

public class SesionEntrenamientoAssembler {
	
private static SesionEntrenamientoAssembler instance;
	
	private SesionEntrenamientoAssembler() { }
	
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
	

}
