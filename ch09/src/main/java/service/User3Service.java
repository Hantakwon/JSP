package service;

import java.util.List;

import dao.User3DAO;
import dto.User3DTO;

/*
 * Service 
 *  - Controller의 비즈니스 처리를 담당
 *  - Controller의 요청을 받아 DAO를 호출, Controller와 DAO의 중간 매개 컴포넌트
 */
public class User3Service {

	// 싱글톤
	private static User3Service instance = new User3Service();
	public static User3Service getInstance() {
		return instance;
	}
	private User3Service() {}
	
	private User3DAO dao = User3DAO.getInstance();
	
	// DAO 메서드 호출 - service에 맞게 네이밍
	public void register(User3DTO dto) {
		dao.insertUser3(dto);
	};
	
	public User3DTO findById(String user_id) {
		return dao.selectUser3(user_id);
	};
	
	public List<User3DTO> findAll() {
		return dao.selectAllUser3();
	};
	
	public void modify(User3DTO dto) {
		dao.updateUser3(dto);
	};
	
	public void delete(String user_id) {
		dao.deleteUser3(user_id);
	};
}
