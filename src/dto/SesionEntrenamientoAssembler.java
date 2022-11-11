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
		
		dto.setUsuario(null);
		dto.setTitulo(null);
		dto.setDistancia(0);
		dto.setFechaIni(null);
		dto.setHoraIni(0);
		dto.setDuracion(0);
		
		return dto;
	}
	

}
