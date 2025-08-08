package service;

import java.util.List;

import dao.User4DAO;
import dto.User4DTO;

public enum User4Service {

	INSTANCE;
	
	private User4DAO dao = User4DAO.getInstance();
	
	public void register(User4DTO dto) {
		dao.insertUser4(dto);
	}
	public User4DTO findById(String uid) {
		return dao.selectUser4(uid);
	}
	public List<User4DTO> findAll() {
		return dao.selectAllUser4();
	}
	public void modify(User4DTO dto) {
		dao.updateUser4(dto);
	}
	public void remove(String uid) {
		dao.deleteUser4(uid);
	}
}
