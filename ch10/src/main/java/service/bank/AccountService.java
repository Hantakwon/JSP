package service.bank;

import java.util.List;

import dao.bank.AccountDAO;
import dto.bank.AccountDTO;
import dto.college.CourseDTO;

// 열거형으로 싱글톤 객체 생성
public enum AccountService {

	INSTANCE;
	
	private AccountDAO dao = AccountDAO.getInstance();
	
	// DAO 메서드 호출 - service에 맞게 네이밍
	public void register(AccountDTO dto) {
		dao.insertAccount(dto);
	};
	
	public AccountDTO findById(String acc_no) {
		return dao.selectAccount(acc_no);
	};
	
	public List<AccountDTO> findAll() {
		return dao.selectAllAccount();
	};
	
	public void modify(AccountDTO dto) {
		dao.updateAccount(dto);
	};
	
	public void delete(String acc_no) {
		dao.deleteAccount(acc_no);
	};
}
