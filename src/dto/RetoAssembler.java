package dto;

import java.util.ArrayList;
import java.util.List;

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
		dto.setFechaIni(reto.getsFechaIni());
		dto.setFechaFin(reto.getsFechaFin());
		dto.setDistancia(reto.getDistancia());
		dto.setTiempoObjetivo(reto.getTiempoObjetivo());
		dto.setDeporte(reto.getDeporte());
		dto.setEstado(reto.getEstado());
		return dto;
	}
	
	public List<RetoDTO> retoToDTO(List<Reto> retos) {
		List<RetoDTO> dtos = new ArrayList<>();
		
		for (Reto reto : retos) {
			dtos.add(this.retoToDTO(reto));
		}
		
		return dtos;		
	}
}
