package dao.college;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.college.CourseDTO;
import util.DBHelper;

public class CourseDAO extends DBHelper{
	private final static CourseDAO INSTANCE = new CourseDAO();

	public static CourseDAO getInstance() {
		return INSTANCE;
	}

	private CourseDAO() {
	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final String DBCP = "jdbc/college";
	
	public void insertCourse(CourseDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "INSERT INTO COURSE VALUES(?, ?, ?, ?)";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, dto.getCs_id());
			psmt.setString(2, dto.getCs_name());
			psmt.setInt(3, dto.getCs_credit());
			psmt.setString(4, dto.getCs_dept());

			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
	};

	public CourseDTO selectCourse(int cs_id) {
		
		CourseDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "SELECT * FROM COURSE WHERE CS_ID = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, cs_id);

			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new CourseDTO();
				dto.setCs_id(rs.getInt(1));
				dto.setCs_name(rs.getString(2));
				dto.setCs_credit(rs.getInt(3));
				dto.setCs_dept(rs.getString(4));
			}

			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 

		return dto;
	};

	public List<CourseDTO> selectAllCourse() {

		List<CourseDTO> courseList = new ArrayList<CourseDTO>();
		
		try {
			conn = getConnection(DBCP);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM COURSE";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				CourseDTO dto = new CourseDTO();
				dto.setCs_id(rs.getInt(1));
				dto.setCs_name(rs.getString(2));
				dto.setCs_credit(rs.getInt(3));
				dto.setCs_dept(rs.getString(4));

				courseList.add(dto);
			}

			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 

		return courseList;
	};

	public void updateCourse(CourseDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "UPDATE COURSE SET CS_NAME =?, CS_CREDIT =?, CS_DEPT=? WHERE CS_ID = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getCs_name());
			psmt.setInt(2, dto.getCs_credit());
			psmt.setString(3, dto.getCs_dept());
			psmt.setInt(4, dto.getCs_id());
			
			psmt.execute();

			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
	};

	public void deleteCourse(int cs_id) {

		try {
			conn = getConnection(DBCP);
			
			String sql = "DELETE FROM COURSE WHERE CS_ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, cs_id);

			psmt.execute();

			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
	};
}
