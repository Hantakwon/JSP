package dao.college;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.college.StudentDTO;
import util.DBHelper;

public class StudentDAO extends DBHelper{
	private final static StudentDAO INSTANCE = new StudentDAO();

	public static StudentDAO getInstance() {
		return INSTANCE;
	}

	private StudentDAO() {}
	
	// 로거 생성
	private Logger logger = LoggerFactory.getLogger(this.getClass());
		
	private final String DBCP = "jdbc/college";
	
	public void insertStudent(StudentDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "INSERT INTO STUDENT VALUES(?, ?, ?, ?, ?)";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getStdno());
			psmt.setString(2, dto.getName());
			psmt.setDate(3, dto.getBirth());
			psmt.setString(4, dto.getMajor());
			psmt.setDate(5, dto.getEnr_date());

			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	};

	public StudentDTO selectStudent(String stdno) {
		
		StudentDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "SELECT * FROM STUDENT WHERE STDNO = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdno);

			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new StudentDTO();
				dto.setStdno(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getDate(3));
				dto.setMajor(rs.getString(4));
				dto.setEnr_date(rs.getDate(5));
			}

			closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}

		return dto;
	};

	public List<StudentDTO> selectAllStudent() {

		List<StudentDTO> studentList = new ArrayList<StudentDTO>();
		
		try {
			conn = getConnection(DBCP);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM STUDENT";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setStdno(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getDate(3));
				dto.setMajor(rs.getString(4));
				dto.setEnr_date(rs.getDate(5));

				studentList.add(dto);
			}

			closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}

		return studentList;
	};

	public void updateStudent(StudentDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "UPDATE STUDENT SET NAME =?, BIRTH =?, MAJOR=?, ENR_DATE =? WHERE STDNO = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setDate(2, dto.getBirth());
			psmt.setString(3, dto.getMajor());
			psmt.setDate(4, dto.getEnr_date());
			psmt.setString(5, dto.getStdno());

			psmt.execute();

			closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	};

	public void deleteStudent(String stdno) {

		try {
			conn = getConnection(DBCP);
			
			String sql = "DELETE FROM STUDENT WHERE STDNO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdno);

			psmt.execute();

			closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	};
}
