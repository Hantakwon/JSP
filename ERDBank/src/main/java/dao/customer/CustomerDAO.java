package dao.customer;

import java.util.ArrayList;
import java.util.List;

import dto.customer.CustomerDTO;
import util.DBHelper;
import util.Sql;

public class CustomerDAO extends DBHelper {

	private static final CustomerDAO INSTANCE = new CustomerDAO();

	public static CustomerDAO getInstance() {
		return INSTANCE;
	}

	private CustomerDAO() {
	}

	private final String DBCP = "jdbc/bankERD";

	public void insertCustomer(CustomerDTO dto) {

		try {
			conn = getConnection(DBCP);

			String sql = "INSERT INTO BANK_CUSTOMER VALUES (?, ?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getC_no());
			psmt.setString(2, dto.getC_name());
			psmt.setInt(3, dto.getC_dist());
			psmt.setString(4, dto.getC_phone());
			psmt.setString(5, dto.getC_addr());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public CustomerDTO selectCustomer(String c_no) {
		CustomerDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement(Sql.SELECT_CUSTOMER_WITH_ACCOUNT_NO);
			psmt.setString(1, c_no);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new CustomerDTO();
				dto.setC_no(rs.getString(1));
				dto.setC_name(rs.getString(2));
				dto.setC_dist(rs.getInt(3));
				dto.setC_phone(rs.getString(4));
				dto.setC_addr(rs.getString(5));
				dto.setC_a_no(rs.getString(6));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public CustomerDTO selectCustomer(String c_no, String c_name) {
		CustomerDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement(Sql.SELECT_CUSTOMER_BY_NO_AND_NAME);
			psmt.setString(1, c_no);
			psmt.setString(2, c_name);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new CustomerDTO();
				dto.setC_no(rs.getString(1));
				dto.setC_name(rs.getString(2));
				dto.setC_dist(rs.getInt(3));
				dto.setC_phone(rs.getString(4));
				dto.setC_addr(rs.getString(5));
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

			rs = stmt.executeQuery("SELECT * FROM BANK_CUSTOMER");

			while (rs.next()) {
				CustomerDTO dto = new CustomerDTO();
				dto.setC_no(rs.getString(1));
				dto.setC_name(rs.getString(2));
				dto.setC_dist(rs.getInt(3));
				dto.setC_phone(rs.getString(4));
				dto.setC_addr(rs.getString(5));
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

			String sql = "UPDATE BANK_CUSTOMER SET C_NAME=?, C_DIST=?, C_PHONE=?, C_ADDR=? WHERE C_NO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getC_name());
			psmt.setInt(2, dto.getC_dist());
			psmt.setString(3, dto.getC_phone());
			psmt.setString(4, dto.getC_addr());
			psmt.setString(5, dto.getC_no());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCustomer(String c_no) {
		try {
			conn = getConnection(DBCP);

			String sql = "DELETE FROM BANK_CUSTOMER WHERE C_NO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_no);
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
