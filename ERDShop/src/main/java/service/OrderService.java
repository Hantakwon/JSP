package service;

import java.util.List;

import dao.order.OrderDAO;
import dto.OrderDTO;

public enum OrderService {

	INSTANCE;
	
	private OrderDAO dao = OrderDAO.getInstance();
	
	public void register(OrderDTO dto) {
		dao.insertOrder(dto);
	}
	public OrderDTO findById(int orderNo) {
		return dao.selectOrder(orderNo);
	}
	public List<OrderDTO> findAll() {
		return dao.selectAllOrder();
	}
	public void modify(OrderDTO dto) {
		dao.updateOrder(dto);
	}
	public void remove(int orderNo) {
		dao.deleteOrder(orderNo);
	}
}
