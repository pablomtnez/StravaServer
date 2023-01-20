package dto;

import java.util.ArrayList;
import java.util.List;

import clases.Reto;

public class RetoAssembler {
	
	private static RetoAssembler instance;
		
	public RetoAssembler() { }
		
	public static RetoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAssembler();
		}
		return instance;
	}
	
	public static RetoDTO retoToDTO(Reto reto) {
		RetoDTO dto = new RetoDTO();
		
		dto.setDeporte(reto.getDeporte());
		dto.setDistancia(reto.getDistancia());
		dto.setFechaFin(reto.getFechaFin());
		dto.setFechaIni(reto.getFechaIni());
		dto.setNombre(reto.getNombre());
		dto.setTiempoObjetivo(reto.getTiempoObjetivo());
		
		return dto;
	}
	
	public List<RetoDTO> retoToDTO(List<Reto> retos){
		List<RetoDTO> dtos = new ArrayList<>();
		for(Reto reto : retos) {
			dtos.add(retoToDTO(reto));
		}
		return dtos;
	}
	
}