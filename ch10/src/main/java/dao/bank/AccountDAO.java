package dao.bank;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.bank.AccountDTO;
import dto.college.CourseDTO;
import util.DBHelper;

public class AccountDAO extends DBHelper{
	private final static AccountDAO INSTANCE = new AccountDAO();

	public static AccountDAO getInstance() {
		return INSTANCE;
	}

	private AccountDAO() {
	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final String DBCP = "jdbc/bank2";
	
	public void insertAccount(AccountDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "INSERT INTO ACCOUNT VALUES(?, ?, ?, ?, ?, ?)";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getAcc_no());
			psmt.setString(2, dto.getAcc_type());
			psmt.setString(3, dto.getAcc_name());
			psmt.setString(4, dto.getAcc_cid());
			psmt.setInt(5, dto.getAcc_balance());
			psmt.setDate(6, dto.getAcc_date());

			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
	};

	public AccountDTO selectAccount(String acc_no) {
		
		AccountDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "SELECT * FROM ACCOUNT WHERE ACC_NO = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, acc_no);

			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new AccountDTO();
				dto.setAcc_no(rs.getString(1));
				dto.setAcc_type(rs.getString(2));
				dto.setAcc_name(rs.getString(3));
				dto.setAcc_cid(rs.getString(4));
				dto.setAcc_balance(rs.getInt(5));
				dto.setAcc_date(rs.getDate(6));
			}

			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 

		return dto;
	};

	public List<AccountDTO> selectAllAccount() {

		List<AccountDTO> accountList = new ArrayList<AccountDTO>();
		
		try {
			conn = getConnection(DBCP);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM ACCOUNT";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				AccountDTO dto = new AccountDTO();
				dto.setAcc_no(rs.getString(1));
				dto.setAcc_type(rs.getString(2));
				dto.setAcc_name(rs.getString(3));
				dto.setAcc_cid(rs.getString(4));
				dto.setAcc_balance(rs.getInt(5));
				dto.setAcc_date(rs.getDate(6));
				
				accountList.add(dto);
			}

			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 

		return accountList;
	};

	public void updateAccount(AccountDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "UPDATE ACCOUNT SET ACC_TYPE =?, ACC_NAME =?, ACC_CID=?, ACC_BALANCE=?, ACC_DATE=? WHERE ACC_NO = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getAcc_type());
			psmt.setString(2, dto.getAcc_name());
			psmt.setString(3, dto.getAcc_cid());
			psmt.setInt(4, dto.getAcc_balance());
			psmt.setDate(5, dto.getAcc_date());
			psmt.setString(6, dto.getAcc_no());
			
			psmt.execute();

			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
	};

	public void deleteAccount(String acc_no) {

		try {
			conn = getConnection(DBCP);
			
			String sql = "DELETE FROM ACCOUNT WHERE ACC_NO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, acc_no);

			psmt.execute();

			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
	};
}
