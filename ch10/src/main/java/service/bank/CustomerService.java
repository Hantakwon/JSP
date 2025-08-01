package service.bank;

import java.util.List;

import dao.bank.CustomerDAO;
import dto.bank.CustomerDTO;

// 열거형으로 싱글톤 객체 생성
public enum CustomerService {

	INSTANCE;
	
	private CustomerDAO dao = CustomerDAO.getInstance();
	
	// DAO 메서드 호출 - service에 맞게 네이밍
	public void register(CustomerDTO dto) {
		dao.insertCustomer(dto);
	};
	
	public CustomerDTO findById(String c_id) {
		return dao.selectCustomer(c_id);
	};
	
	public List<CustomerDTO> findAll() {
		return dao.selectAllCustomer();
	};
	
	public void modify(CustomerDTO dto) {
		dao.updateCustomer(dto);
	};
	
	public void delete(String c_id) {
		dao.deleteCustomer(c_id);
	};
}
