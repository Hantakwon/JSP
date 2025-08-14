package service.register;

import java.util.List;

import dao.register.RegisterDAO;
import dto.register.RegisterDTO;

public enum RegisterService {
	
	INSTANCE;
	
	private RegisterDAO dao = RegisterDAO.getInstance();
	
	public void register(RegisterDTO dto) {
		dao.insertRegister(dto);
	}
	public RegisterDTO findById(String regStdNo, int stdLecNo) {
		return dao.selectRegister(regStdNo, stdLecNo);
	}
	public List<RegisterDTO> findAll() {
		return dao.selectAllRegister();
	}
	public void modify(RegisterDTO dto) {
		dao.updateRegister(dto);
	}
	public void remove(String regStdNo, int stdLecNo) {
		dao.deleteRegister(regStdNo, stdLecNo);
	}
	
}
