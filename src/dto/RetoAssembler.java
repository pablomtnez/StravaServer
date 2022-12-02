package dto;

import java.util.ArrayList;
import java.util.List;

import clases.Deporte;
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
			dto.setSfechaIni(reto.getSfechaIni());
			dto.setSfechaFin(reto.getSfechaFin());
			dto.setDistancia(reto.getDistancia());
			dto.setTiempoObjetivo(reto.getTiempoObjetivo());
			dto.setCodigo(reto.getCodigo());
			
			if(reto.getDeporte().equals(Deporte.CICLISMO)) {
				dto.setDeporte(DeporteDTO.CICLISMO);
			}else if(reto.getDeporte().equals(Deporte.RUNNING)){
				dto.setDeporte(DeporteDTO.RUNNING);
			}
			
			return dto;
		}
		
		public Reto dtoToReto(RetoDTO dto) {
			
			Reto reto = new Reto();
			
			reto.setUsuario(dto.getUsuario());
			reto.setNombre(dto.getNombre());
			reto.setSfechaIni(dto.getSfechaIni());
			reto.setSfechaFin(dto.getSfechaFin());
			reto.setDistancia(dto.getDistancia());
			reto.setTiempoObjetivo(dto.getTiempoObjetivo());
			reto.setEstado(dto.getEstado());
			reto.setCodigo(dto.getCodigo());
			
			if(dto.getDeporte().equals(DeporteDTO.CICLISMO)) {
				reto.setDeporte(Deporte.CICLISMO);
			}else if(dto.getDeporte().equals(DeporteDTO.RUNNING)){
				reto.setDeporte(Deporte.RUNNING);
			}
			
			return reto;
		}
		
		public List<Reto> retosNormales (List<RetoDTO> retos) {
			
			List<Reto> retosNormales = new ArrayList<>();
			
			for (RetoDTO reto : retos) {
				retosNormales.add(this.dtoToReto(reto));
			}
			
			return retosNormales;		
		}
		
		public List<RetoDTO> retosDTO (List<Reto> retos) {
			
			List<RetoDTO> retosDTO = new ArrayList<>();
			
			for (Reto reto : retos) {
				retosDTO.add(this.retoToDTO(reto));
			}
			
			return retosDTO;		
		}
		
		
	}