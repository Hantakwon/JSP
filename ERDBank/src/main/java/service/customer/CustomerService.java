package service.customer;

import java.util.List;

import dao.customer.CustomerDAO;
import dto.customer.CustomerDTO;

public enum CustomerService {
	
	INSTANCE;
	
	private CustomerDAO dao = CustomerDAO.getInstance();
	
	public void register(CustomerDTO dto) {
		dao.insertCustomer(dto);
	}
	public CustomerDTO findById(String c_no) {
		return dao.selectCustomer(c_no);
	}
	
	public CustomerDTO findByIdAndName(String c_no, String c_name) {
		return dao.selectCustomer(c_no, c_name);
	}
	
	public List<CustomerDTO> findAll() {
		return dao.selectAllCustomer();
	}
	public void modify(CustomerDTO dto) {
		dao.updateCustomer(dto);
	}
	public void remove(String c_no) {
		dao.deleteCustomer(c_no);
	}
}
