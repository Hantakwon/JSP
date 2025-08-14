package dao.register;

import java.util.ArrayList;
import java.util.List;

import dto.register.RegisterDTO;
import util.DBHelper;

public class RegisterDAO extends DBHelper {

	private static final RegisterDAO INSTANCE = new RegisterDAO();

	public static RegisterDAO getInstance() {
		return INSTANCE;
	}

	private RegisterDAO() {
	}

	private final String DBCP = "jdbc/collegeERD";

	public void insertRegister(RegisterDTO dto) {

		try {
			conn = getConnection(DBCP);

			String sql = "INSERT INTO REGISTER (REGSTDNO, REGLECNO) VALUES (?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getRegStdNo());
			psmt.setInt(2, dto.getRegLecNo());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public RegisterDTO selectRegister(String regStdNo, int regLecNo) {
		RegisterDTO dto = null;

		try {
			conn = getConnection(DBCP);
			String sql = "SELECT * FROM REGISTER WHERE REGSTDNO = ? AND REGLECNO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, regStdNo);
			psmt.setInt(2, regLecNo);

			rs = psmt.executeQuery();

			if (rs.next()) {
				dto = new RegisterDTO();
				dto.setRegStdNo(rs.getString(1));
				dto.setRegLecNo(rs.getInt(2));
				dto.setRegMidScore(rs.getInt(3));
				dto.setRegFinalScore(rs.getInt(4));
				dto.setRegTotalScore(rs.getInt(5));
				dto.setRegGrade(rs.getString(6));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public List<RegisterDTO> selectAllRegister() {

		List<RegisterDTO> dtoList = new ArrayList<RegisterDTO>();

		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT * FROM REGISTER");

			while (rs.next()) {
				RegisterDTO dto = new RegisterDTO();
				dto.setRegStdNo(rs.getString(1));
				dto.setRegLecNo(rs.getInt(2));
				dto.setRegMidScore(rs.getInt(3));
				dto.setRegFinalScore(rs.getInt(4));
				dto.setRegTotalScore(rs.getInt(5));
				dto.setRegGrade(rs.getString(6));
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	public void updateRegister(RegisterDTO dto) {
		try {
			conn = getConnection(DBCP);

			String sql = "UPDATE REGISTER SET REGMIDSCORE=?, REGFINALSCORE=?, REGTOTALSCORE=?, REGGRADE=? WHERE REGSTDNO=? AND REGLECNO=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getRegMidScore());
			psmt.setInt(2, dto.getRegFinalScore());
			psmt.setInt(3, dto.getRegTotalScore());
			psmt.setString(4, dto.getRegGrade());
			psmt.setString(5, dto.getRegStdNo());
			psmt.setInt(6, dto.getRegLecNo());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteRegister(String regStdNo, int regLecNo) {
		try {
			conn = getConnection(DBCP);

			String sql = "DELETE FROM REGISTER WHERE REGSTDNO=? AND REGLECNO=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, regStdNo);
			psmt.setInt(2, regLecNo);
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
