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
	
	public RetoDTO retoToDTO(Reto reto) {
		RetoDTO dto = new RetoDTO();
		
		dto.setUsuario(reto.getUsuario());
		dto.setNombre(reto.getNombre());
		dto.setSfechaIni(reto.getsFechaIni());
		dto.setSfechaIni(reto.getsFechaFin());
		dto.setDistancia(reto.getDistancia());
		dto.setTiempoObjetivo(reto.getTiempoObjetivo());
		dto.setDeporte(reto.getDeporte());
		dto.setEstado(reto.getEstado());
		dto.setCodigo(reto.getCodigo());
		
		return dto;
	}
	
	public Reto dtoToReto(RetoDTO dto) {
		
		Reto reto = new Reto();
		
		reto.setUsuario(dto.getUsuario());
		reto.setNombre(dto.getNombre());
		reto.setsFechaFin(dto.getSfechaFin());
		reto.setsFechaFin(dto.getSfechaFin());
		reto.setDistancia(dto.getDistancia());
		reto.setTiempoObjetivo(dto.getTiempoObjetivo());
		reto.setDeporte(dto.getDeporte());
		reto.setEstado(dto.getEstado());
		reto.setCodigo(dto.getCodigo());
		
		return reto;
	}
	
	public List<RetoDTO> retosDTO (List<Reto> retos) {
		
		List<RetoDTO> retosDTO = new ArrayList<>();
		
		for (Reto reto : retos) {
			retosDTO.add(this.retoToDTO(reto));
		}
		
		return retosDTO;		
	}
}
