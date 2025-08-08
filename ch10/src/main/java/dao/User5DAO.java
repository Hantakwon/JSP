package dao;

import java.util.ArrayList;
import java.util.List;

import dto.User5DTO;
import util.DBHelper;

public class User5DAO extends DBHelper {

	private static final User5DAO INSTANCE = new User5DAO();

	public static User5DAO getInstance() {
		return INSTANCE;
	}

	private User5DAO() {
	}

	private final String DBCP = "jdbc/studydb";

	public void insertUser5(User5DTO dto) {

		try {
			conn = getConnection(DBCP);

			String sql = "INSERT INTO User5 (NAME, GENDER, AGE, ADDR) VALUES (?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getAddr());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public User5DTO selectUser5(String seq) {
		User5DTO dto = new User5DTO();
		
		try {
			conn = getConnection(DBCP);
			String sql = "SELECT * FROM User5 WHERE SEQ = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, seq);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto.setSeq(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dto.setAddr(rs.getString(5));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public List<User5DTO> selectAllUser5() {

		List<User5DTO> dtoList = new ArrayList<User5DTO>();

		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT * FROM User5");

			while (rs.next()) {
				User5DTO dto = new User5DTO();
				dto.setSeq(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dto.setAddr(rs.getString(5));
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	public void updateUser5(User5DTO dto) {
		try {
			conn = getConnection(DBCP);

			String sql = "UPDATE User5 SET NAME=?, GENDER=?, AGE=?, ADDR=? WHERE SEQ = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getAddr());
			psmt.setString(5, dto.getSeq());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteUser5(String seq) {
		try {
			conn = getConnection(DBCP);

			String sql = "DELETE FROM User5 WHERE SEQ = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, seq);
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
