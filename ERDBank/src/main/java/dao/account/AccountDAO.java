package dao.account;

import java.util.ArrayList;
import java.util.List;

import dto.account.AccountDTO;
import util.DBHelper;
import util.Sql;

public class AccountDAO extends DBHelper {

	private static final AccountDAO INSTANCE = new AccountDAO();

	public static AccountDAO getInstance() {
		return INSTANCE;
	}

	private AccountDAO() {
	}

	private final String DBCP = "jdbc/bankERD";

	public void insertAccount(AccountDTO dto) {

		try {
			conn = getConnection(DBCP);

			String sql = "INSERT INTO BANK_ACCOUNT VALUES (?, ?, ?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getA_no());
			psmt.setString(2, dto.getA_item_dist());
			psmt.setString(3, dto.getA_item_name());
			psmt.setString(4, dto.getA_c_no());
			psmt.setInt(5, dto.getA_balance());
			psmt.setDate(6, dto.getA_open_date());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public AccountDTO selectAccount(String a_no) {
		AccountDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement(Sql.SELECT_ACCOUNT_WITH_NAME);
			psmt.setString(1, a_no);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new AccountDTO();
				dto.setA_no(rs.getString(1));
				dto.setA_item_dist(rs.getString(2));
				dto.setA_item_name(rs.getString(3));
				dto.setA_c_no(rs.getString(4));
				dto.setA_balance(rs.getInt(5));
				dto.setA_open_date(rs.getDate(6));
				dto.setA_c_name(rs.getString(7));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public List<AccountDTO> selectAllAccount() {

		List<AccountDTO> dtoList = new ArrayList<AccountDTO>();

		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();

			rs = stmt.executeQuery(Sql.SELECT_ALL_ACCOUNT_WITH_NAME);

			while (rs.next()) {
				AccountDTO dto = new AccountDTO();
				dto.setA_no(rs.getString(1));
				dto.setA_item_dist(rs.getString(2));
				dto.setA_item_name(rs.getString(3));
				dto.setA_c_no(rs.getString(4));
				dto.setA_balance(rs.getInt(5));
				dto.setA_open_date(rs.getDate(6));
				dto.setA_c_name(rs.getString(7));
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	public void updateAccount(AccountDTO dto) {
		try {
			conn = getConnection(DBCP);

			String sql = "UPDATE BANK_ACCOUNT SET A_ITEM_DIST=?, A_ITEM_NAME=?, A_C_NO=?, A_BALANCE=?, A_OPEN_DATE=? WHERE A_NO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getA_item_dist());
			psmt.setString(2, dto.getA_item_name());
			psmt.setString(3, dto.getA_c_no());
			psmt.setInt(4, dto.getA_balance());
			psmt.setDate(5, dto.getA_open_date());
			psmt.setString(6, dto.getA_no());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAccount(String a_no) {
		try {
			conn = getConnection(DBCP);

			String sql = "DELETE FROM BANK_ACCOUNT WHERE A_NO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, a_no);
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
