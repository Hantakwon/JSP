package dao.student;

import java.util.ArrayList;
import java.util.List;

import dto.student.StudentDTO;
import util.DBHelper;

public class StudentDAO extends DBHelper {

	private static final StudentDAO INSTANCE = new StudentDAO();

	public static StudentDAO getInstance() {
		return INSTANCE;
	}

	private StudentDAO() {
	}

	private final String DBCP = "jdbc/collegeERD";

	public void insertStudent(StudentDTO dto) {

		try {
			conn = getConnection(DBCP);

			String sql = "INSERT INTO STUDENT VALUES (?, ?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getStdNo());
			psmt.setString(2, dto.getStdName());
			psmt.setString(3, dto.getStdHp());
			psmt.setInt(4, dto.getStdYear());
			psmt.setString(5, dto.getStdAddress());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public StudentDTO selectStudent(String stdNo) {
		StudentDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			String sql = "SELECT * FROM Student WHERE STDNO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdNo);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new StudentDTO();
				dto.setStdNo(rs.getString(1));
				dto.setStdName(rs.getString(2));
				dto.setStdHp(rs.getString(3));
				dto.setStdYear(rs.getInt(4));
				dto.setStdAddress(rs.getString(5));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public StudentDTO selectStudent(String stdNo, String stdName) {
		StudentDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			String sql = "SELECT * FROM Student WHERE STDNO = ? AND STDNAME = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdNo);
			psmt.setString(2, stdName);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new StudentDTO();
				dto.setStdNo(rs.getString(1));
				dto.setStdName(rs.getString(2));
				dto.setStdHp(rs.getString(3));
				dto.setStdYear(rs.getInt(4));
				dto.setStdAddress(rs.getString(5));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public List<StudentDTO> selectAllStudent() {

		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();

		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT * FROM STUDENT");

			while (rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setStdNo(rs.getString(1));
				dto.setStdName(rs.getString(2));
				dto.setStdHp(rs.getString(3));
				dto.setStdYear(rs.getInt(4));
				dto.setStdAddress(rs.getString(5));
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	public void updateStudent(StudentDTO dto) {
		try {
			conn = getConnection(DBCP);

			String sql = "UPDATE STUDENT SET STDNAME=?, STDHP=?, STDYEAR=?, STDADDRESS=? WHERE STDNO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getStdName());
			psmt.setString(2, dto.getStdHp());
			psmt.setInt(3, dto.getStdYear());
			psmt.setString(4, dto.getStdAddress());
			psmt.setString(5, dto.getStdNo());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteStudent(String stdNo) {
		try {
			conn = getConnection(DBCP);

			String sql = "DELETE FROM Student WHERE STDNO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdNo);
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
