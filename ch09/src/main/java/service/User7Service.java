package service;

import java.util.List;

import dao.User7DAO;
import dto.User7DTO;

/*
 * Service 
 *  - Controller의 비즈니스 처리를 담당
 *  - Controller의 요청을 받아 DAO를 호출, Controller와 DAO의 중간 매개 컴포넌트
 */
public class User7Service {

	// 싱글톤
	private static User7Service instance = new User7Service();
	public static User7Service getInstance() {
		return instance;
	}
	private User7Service() {}
	
	private User7DAO dao = User7DAO.getInstance();
	
	// DAO 메서드 호출 - service에 맞게 네이밍
	public void register(User7DTO dto) {
		dao.insertUser7(dto);
	};
	
	public User7DTO findById(String id) {
		return dao.selectUser7(id);
	};
	
	public List<User7DTO> findAll() {
		return dao.selectAllUser7();
	};
	
	public void modify(User7DTO dto) {
		dao.updateUser7(dto);
	};
	
	public void delete(String id) {
		dao.deleteUser7(id);
	};
}
