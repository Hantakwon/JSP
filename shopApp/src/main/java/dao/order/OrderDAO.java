package dao.order;

import java.util.ArrayList;
import java.util.List;

import dto.OrderDTO;
import util.DBHelper;

public class OrderDAO extends DBHelper {

	private static final OrderDAO INSTANCE = new OrderDAO();

	public static OrderDAO getInstance() {
		return INSTANCE;
	}

	private OrderDAO() {
	}

	private final String DBCP = "jdbc/shopERD";

	public void insertOrder(OrderDTO dto) {

		try {
			conn = getConnection(DBCP);

			String sql = "INSERT INTO \"Order\" (ORDERID, ORDERPRODUCT, ORDERCOUNT, ORDERDATE) VALUES (?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getOrderId());
			psmt.setInt(2, dto.getOrderProduct());
			psmt.setInt(3, dto.getOrderCount());
			psmt.setDate(4, dto.getOrderDate());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public OrderDTO selectOrder(int orderNo) {
		OrderDTO dto = new OrderDTO();
		
		try {
			conn = getConnection(DBCP);
			String sql = "SELECT * FROM \"Order\" WHERE ORDERNO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, orderNo);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto.setOrderId(rs.getString(1));
				dto.setOrderProduct(rs.getInt(2));
				dto.setOrderCount(rs.getInt(3));
				dto.setOrderDate(rs.getDate(4));
				dto.setOrderNo(rs.getInt(5));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public List<OrderDTO> selectAllOrder() {

		List<OrderDTO> dtoList = new ArrayList<OrderDTO>();

		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT * FROM \"Order\"");

			while (rs.next()) {
				OrderDTO dto = new OrderDTO();
				dto.setOrderId(rs.getString(1));
				dto.setOrderProduct(rs.getInt(2));
				dto.setOrderCount(rs.getInt(3));
				dto.setOrderDate(rs.getDate(4));
				dto.setOrderNo(rs.getInt(5));
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	public void updateOrder(OrderDTO dto) {
		try {
			conn = getConnection(DBCP);

			String sql = "UPDATE \"Order\" SET ORDERID=?, ORDERPRODUCT=?, ORDERCOUNT=?, ORDERDATE=? WHERE ORDERNO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getOrderId());
			psmt.setInt(2, dto.getOrderProduct());
			psmt.setInt(3, dto.getOrderCount());
			psmt.setDate(4, dto.getOrderDate());
			psmt.setInt(5, dto.getOrderNo());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteOrder(int orderNo) {
		try {
			conn = getConnection(DBCP);

			String sql = "DELETE FROM \"Order\" WHERE ORDERNO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, orderNo);
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
