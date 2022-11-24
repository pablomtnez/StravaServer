package dto;

import java.util.ArrayList;
import java.util.List;

import clases.Reto;

public class RetoAssembler {
	private static RetoAssembler instance;
	
	public RetoAssembler() {}
	
	public static RetoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAssembler();
		}
		return instance;
	}
	
	public RetoDTO retoToDTO(Reto nuevoReto) {
		RetoDTO dto = new RetoDTO();
		
		dto.setNombre(nuevoReto.getNombre());
		dto.setFechaIni(nuevoReto.getsFechaIni());
		dto.setFechaFin(nuevoReto.getsFechaFin());
		dto.setDistancia(nuevoReto.getDistancia());
		dto.setTiempoObjetivo(nuevoReto.getTiempoObjetivo());
		dto.setDeporte(nuevoReto.getDeporte());
		dto.setEstado(nuevoReto.getEstado());
		return dto;
	}
	
	public Reto dtoToReto(RetoDTO dto) {
		Reto reto = new Reto();
		
		reto.setNombre(dto.getNombre());
		reto.setsFechaIni(dto.getFechaIni());
		reto.setsFechaFin(dto.getFechaFin());
		reto.setDistancia(dto.getDistancia());
		reto.setTiempoObjetivo(dto.getTiempoObjetivo());
		reto.setDeporte(dto.getDeporte());
		reto.setEstado(dto.getEstado());
		
		return reto;
	}
	
	public List<RetoDTO> retoToDTO(List<Reto> retos) {
		List<RetoDTO> dtos = new ArrayList<>();
		
		for (Reto reto : retos) {
			dtos.add(this.retoToDTO(reto));
		}
		
		return dtos;		
	}
}
