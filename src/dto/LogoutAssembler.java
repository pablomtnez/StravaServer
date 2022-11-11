package dto;

import clases.Logout;

public class LogoutAssembler {
	private static LogoutAssembler instance;

	private LogoutAssembler() { }
	
	public static LogoutAssembler getInstance() {
		if (instance == null) {
			instance = new LogoutAssembler();
		}

		return instance;
	}

	public LogoutDTO logoutToDTO(Logout logout) {
		LogoutDTO dto = new LogoutDTO();
		
		dto.setToken(logout.getToken());		
		return dto;
	}	
}