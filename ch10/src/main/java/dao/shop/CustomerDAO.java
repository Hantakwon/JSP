package dao.shop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.shop.CustomerDTO;
import util.DBHelper;

public class CustomerDAO extends DBHelper{
	private final static CustomerDAO INSTANCE = new CustomerDAO();

	public static CustomerDAO getInstance() {
		return INSTANCE;
	}

	private CustomerDAO() {
	}

	private final String DBCP = "jdbc/shop";
	
	// 로거 생성
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertCustomer(CustomerDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "INSERT INTO CUSTOMER VALUES(?, ?, ?, ?, ?)";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getCid());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getHp());
			psmt.setString(4, dto.getAddress());
			psmt.setDate(5, dto.getRdate());

			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	};

	public CustomerDTO selectCustomer(String cid) {
		
		CustomerDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "SELECT * FROM CUSTOMER WHERE CID = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cid);

			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new CustomerDTO();
				dto.setCid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setRdate(rs.getDate(5));
			}

			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return dto;
	};

	public List<CustomerDTO> selectAllCustomer() {

		List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();
		
		try {
			conn = getConnection(DBCP);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM CUSTOMER";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				CustomerDTO dto = new CustomerDTO();
				dto.setCid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setRdate(rs.getDate(5));

				customerList.add(dto);
			}

			closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}

		return customerList;
	};

	public void updateCustomer(CustomerDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "UPDATE CUSTOMER SET NAME =?, HP =?, ADDRESS=?, RDATE =? WHERE CID = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getHp());
			psmt.setString(3, dto.getAddress());
			psmt.setDate(4, dto.getRdate());
			psmt.setString(5, dto.getCid());

			psmt.execute();

			closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	};

	public void deleteCustomer(String cid) {

		try {
			conn = getConnection(DBCP);
			
			String sql = "DELETE FROM CUSTOMER WHERE CID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cid);

			psmt.execute();

			closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	};
}
