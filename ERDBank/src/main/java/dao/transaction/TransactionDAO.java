package dao.transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.transaction.TransactionDTO;
import util.DBHelper;
import util.Sql;

public class TransactionDAO extends DBHelper {

	private static final TransactionDAO INSTANCE = new TransactionDAO();

	public static TransactionDAO getInstance() {
		return INSTANCE;
	}

	private TransactionDAO() {
	}

	private final String DBCP = "jdbc/bankERD";

	public void insertAndUpdateTransaction(TransactionDTO dto) {

		try {
			conn = getConnection(DBCP);
			
			conn.setAutoCommit(false);
			
			psmt = conn.prepareStatement(Sql.INSERT_TRANSACTION);
			psmt.setString(1, dto.getT_a_no());
			psmt.setInt(2, dto.getT_dist());
			psmt.setInt(3, dto.getT_amount());
			psmt.executeUpdate();
			
			psmt1 = conn.prepareStatement(Sql.UPDATE_ACCOUNT_PLUS);
			psmt1.setInt(1, dto.getT_amount());
			psmt1.setString(2, dto.getT_a_no_to());
			psmt1.executeUpdate();
			
			psmt2 = conn.prepareStatement(Sql.UPDATE_ACCOUNT_MINUS);
			psmt2.setInt(1, dto.getT_amount());
			psmt2.setString(2, dto.getT_a_no());
			psmt2.executeUpdate();
			
			conn.commit();
			closeAll();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public TransactionDTO selectTransaction(int t_no) {
		TransactionDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			String sql = "SELECT * FROM BANK_TRANSACTION WHERE T_NO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, t_no);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new TransactionDTO();
				dto.setT_no(rs.getInt(1));
				dto.setT_a_no(rs.getString(2));
				dto.setT_dist(rs.getInt(3));
				dto.setT_amount(rs.getInt(4));
				dto.setT_dateTime(rs.getDate(5));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<TransactionDTO> selectByTANoTransaction(String t_a_no) {
		List<TransactionDTO> dtoList = new ArrayList<TransactionDTO>();

		try {
			conn = getConnection(DBCP);
			psmt = conn.prepareStatement(Sql.SELECT_TRANSACTION_BY_T_A_NO);
			psmt.setString(1, t_a_no);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				TransactionDTO dto = new TransactionDTO();
				dto.setT_no(rs.getInt(1));
				dto.setT_a_no(rs.getString(2));
				dto.setT_dist(rs.getInt(3));
				dto.setT_amount(rs.getInt(4));
				dto.setT_dateTime(rs.getDate(5));
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	public List<TransactionDTO> selectAllTransaction() {

		List<TransactionDTO> dtoList = new ArrayList<TransactionDTO>();

		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT * FROM BANK_TRANSACTION");

			while (rs.next()) {
				TransactionDTO dto = new TransactionDTO();
				dto.setT_no(rs.getInt(1));
				dto.setT_a_no(rs.getString(2));
				dto.setT_dist(rs.getInt(3));
				dto.setT_amount(rs.getInt(4));
				dto.setT_dateTime(rs.getDate(5));
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	public void updateTransaction(TransactionDTO dto) {
		try {
			conn = getConnection(DBCP);

			String sql = "UPDATE BANK_TRANSACTION SET T_A_NO=?, T_DIST=?, T_AMOUNT=?, T_DATETIME=? WHERE T_NO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getT_a_no());
			psmt.setInt(2, dto.getT_dist());
			psmt.setInt(3, dto.getT_amount());
			psmt.setDate(4, dto.getT_dateTime());
			psmt.setInt(5, dto.getT_no());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTransaction(int t_no) {
		try {
			conn = getConnection(DBCP);

			String sql = "DELETE FROM BANK_TRANSACTION WHERE T_NO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, t_no);
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
