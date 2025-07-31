package service;

import java.util.List;

import dao.User6DAO;
import dto.User6DTO;

/*
 * Service 
 *  - Controller의 비즈니스 처리를 담당
 *  - Controller의 요청을 받아 DAO를 호출, Controller와 DAO의 중간 매개 컴포넌트
 */
public class User6Service {

	// 싱글톤
	private static User6Service instance = new User6Service();
	public static User6Service getInstance() {
		return instance;
	}
	private User6Service() {}
	
	private User6DAO dao = User6DAO.getInstance();
	
	// DAO 메서드 호출 - service에 맞게 네이밍
	public void register(User6DTO dto) {
		dao.insertUser6(dto);
	};
	
	public User6DTO findById(int seq) {
		return dao.selectUser6(seq);
	};
	
	public List<User6DTO> findAll() {
		return dao.selectAllUser6();
	};
	
	public void modify(User6DTO dto) {
		dao.updateUser6(dto);
	};
	
	public void delete(int seq) {
		dao.deleteUser6(seq);
	};
}
