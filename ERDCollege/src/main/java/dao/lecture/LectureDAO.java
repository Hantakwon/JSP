package dao.lecture;

import java.util.ArrayList;
import java.util.List;

import dto.lecture.LectureDTO;
import util.DBHelper;

public class LectureDAO extends DBHelper {

	private static final LectureDAO INSTANCE = new LectureDAO();

	public static LectureDAO getInstance() {
		return INSTANCE;
	}

	private LectureDAO() {
	}

	private final String DBCP = "jdbc/collegeERD";

	public void insertLecture(LectureDTO dto) {

		try {
			conn = getConnection(DBCP);

			String sql = "INSERT INTO LECTURE VALUES (?, ?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getLecNo());
			psmt.setString(2, dto.getLecName());
			psmt.setInt(3, dto.getLecCredit());
			psmt.setInt(4, dto.getLecTime());
			psmt.setString(5, dto.getLecClass());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public LectureDTO selectLecture(int lecNo) {
		LectureDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			String sql = "SELECT * FROM LECTURE WHERE LECNO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, lecNo);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new LectureDTO();
				dto.setLecNo(rs.getInt(1));
				dto.setLecName(rs.getString(2));
				dto.setLecCredit(rs.getInt(3));
				dto.setLecTime(rs.getInt(4));
				dto.setLecClass(rs.getString(5));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public List<LectureDTO> selectAllLecture() {

		List<LectureDTO> dtoList = new ArrayList<LectureDTO>();

		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT * FROM LECTURE");

			while (rs.next()) {
				LectureDTO dto = new LectureDTO();
				dto.setLecNo(rs.getInt(1));
				dto.setLecName(rs.getString(2));
				dto.setLecCredit(rs.getInt(3));
				dto.setLecTime(rs.getInt(4));
				dto.setLecClass(rs.getString(5));
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	public void updateLecture(LectureDTO dto) {
		try {
			conn = getConnection(DBCP);

			String sql = "UPDATE LECTURE SET LECNAME=?, LECCREDIT=?, LECTIME=?, LECCLASS=? WHERE LECNO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getLecName());
			psmt.setInt(2, dto.getLecCredit());
			psmt.setInt(3, dto.getLecTime());
			psmt.setString(4, dto.getLecClass());
			psmt.setInt(5, dto.getLecNo());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteLecture(int lecNo) {
		try {
			conn = getConnection(DBCP);

			String sql = "DELETE FROM LECTURE WHERE LECNO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, lecNo);
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
