package dto;

import clases.Login;

public class LogInAssembler {
	
	private static LogInAssembler instance;
	
	private LogInAssembler() { }
	
	public static LogInAssembler getInstance() {
		if (instance ==  null) {
			instance = new LogInAssembler();
		}
		return instance;
		
	}
	
public LogInDTO LogInToDTO (Login login) {
		
		LogInDTO dto = new LogInDTO();
		
		dto.setEmail(null);
		return dto;
	}
	
}
