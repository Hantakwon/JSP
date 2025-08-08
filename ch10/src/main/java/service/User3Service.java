package service;

import java.util.List;

import dao.User3DAO;
import dto.User3DTO;

public enum User3Service {

	INSTANCE;
	
	private User3DAO dao = User3DAO.getInstance();
	
	public void register(User3DTO dto) {
		dao.insertUser3(dto);
	}
	public User3DTO findById(String uid) {
		return dao.selectUser3(uid);
	}
	public List<User3DTO> findAll() {
		return dao.selectAllUser3();
	}
	public void modify(User3DTO dto) {
		dao.updateUser3(dto);
	}
	public void remove(String uid) {
		dao.deleteUser3(uid);
	}
}
