package service;

import java.util.List;

import dao.User2DAO;
import dto.User1DTO;
import dto.User2DTO;

/*
 * Service 
 *  - Controller의 비즈니스 처리를 담당
 *  - Controller의 요청을 받아 DAO를 호출, Controller와 DAO의 중간 매개 컴포넌트
 */
public class User2Service {

	// 싱글톤
	private static User2Service instance = new User2Service();
	public static User2Service getInstance() {
		return instance;
	}
	private User2Service() {}
	
	private User2DAO dao = User2DAO.getInstance();
	
	// DAO 메서드 호출 - service에 맞게 네이밍
	public void register(User2DTO dto) {
		dao.insertUser2(dto);
	};
	
	public User2DTO findById(String user_id) {
		return dao.selectUser2(user_id);
	};
	
	public List<User2DTO> findAll() {
		return dao.selectAllUser2();
	};
	
	public void modify(User2DTO dto) {
		dao.updateUser2(dto);
	};
	
	public void delete(String user_id) {
		dao.deleteUser2(user_id);
	};
}
