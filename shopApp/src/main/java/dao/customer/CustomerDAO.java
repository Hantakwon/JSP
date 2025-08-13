package dao.customer;

import java.util.ArrayList;
import java.util.List;

import dto.CustomerDTO;
import util.DBHelper;

public class CustomerDAO extends DBHelper {

	private static final CustomerDAO INSTANCE = new CustomerDAO();

	public static CustomerDAO getInstance() {
		return INSTANCE;
	}

	private CustomerDAO() {
	}

	private final String DBCP = "jdbc/shopERD";

	public void insertCustomer(CustomerDTO dto) {

		try {
			conn = getConnection(DBCP);

			String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getCustId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getHp());
			psmt.setString(4, dto.getAddr());
			psmt.setDate(5, dto.getRdate());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public CustomerDTO selectCustomer(String custId) {
		CustomerDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			String sql = "SELECT * FROM Customer WHERE CUSTID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, custId);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new CustomerDTO();
				dto.setCustId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAddr(rs.getString(4));
				dto.setRdate(rs.getDate(5));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public List<CustomerDTO> selectAllCustomer() {

		List<CustomerDTO> dtoList = new ArrayList<CustomerDTO>();

		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT * FROM Customer");

			while (rs.next()) {
				CustomerDTO dto = new CustomerDTO();
				dto.setCustId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAddr(rs.getString(4));
				dto.setRdate(rs.getDate(5));
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	public void updateCustomer(CustomerDTO dto) {
		try {
			conn = getConnection(DBCP);

			String sql = "UPDATE Customer SET NAME=?, HP=?, ADDR=?, RDATE=? WHERE CUSTID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getHp());
			psmt.setString(3, dto.getAddr());
			psmt.setDate(4, dto.getRdate());
			psmt.setString(5, dto.getCustId());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCustomer(String custId) {
		try {
			conn = getConnection(DBCP);

			String sql = "DELETE FROM Customer WHERE CUSTID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, custId);
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
