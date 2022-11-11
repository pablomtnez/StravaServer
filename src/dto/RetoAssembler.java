package dto;

import java.util.Date;

import clases.Reto;

public class RetoAssembler {
	private static RetoAssembler instance;
	
	private RetoAssembler() {}
	
	public static RetoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAssembler();
		}
		return instance;
	}
	
	public RetoDTO retoToDTO(Reto reto) {
		RetoDTO dto = new RetoDTO();
		
		dto.setNombre(reto.getNombre());
		dto.setFechaIni(reto.getFechaIni());
		dto.setFechaFin(reto.getFechaFin());
		dto.setDistancia(reto.getDistancia());
		dto.setTiempoObjetivo(reto.getTiempoObjetivo());
		dto.setDeporte(reto.getDeporte());
		
		
		return dto;
	}
}
