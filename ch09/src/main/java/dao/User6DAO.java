package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dto.User6DTO;

// DAO(Data Access Object) : DB 처리를 수행하는 객체
public class User6DAO {
	
	// DAO는 기본 싱글톤
	private final static User6DAO INSTANCE = new User6DAO();
	
	public static User6DAO getInstance() {
		return INSTANCE;
	}
	
	private User6DAO() {}
	
	public Connection DBConnection() {
		Connection conn = null;
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/gca1234");
			conn = ds.getConnection();
			
			return conn;
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 기본 CRUD 메서드
	public void insertUser6(User6DTO dto) {
		Connection conn = DBConnection();
		
		String sql = "INSERT INTO USER6 VALUES(?, ?, ?, ?, ?)";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getSeq());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getGender());
			psmt.setInt(4, dto.getAge());
			psmt.setString(5, dto.getAddress());
			
			psmt.execute();
		
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};	
	
	public User6DTO selectUser6(int seq) {
		Connection conn = DBConnection();
		
		String sql = "SELECT * FROM USER6 WHERE SEQ = ?";
		PreparedStatement psmt;
		ResultSet rs;
		User6DTO dto = new User6DTO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);

			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dto.setAddress(rs.getString(5));
			}	
			
			rs.close();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return dto;
	};
	public List<User6DTO> selectAllUser6() {
		Connection conn = DBConnection();
		
		String sql = "SELECT * FROM USER6";
		Statement stmt;
		ResultSet rs;
		List<User6DTO> userList = new ArrayList<User6DTO>();
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				User6DTO dto = new User6DTO();
				dto.setSeq(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dto.setAddress(rs.getString(5));
				
				userList.add(dto);
			}	
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return userList;
	};
	public void updateUser6(User6DTO dto) {
		Connection conn = DBConnection();
		
		String sql = "UPDATE USER6 SET NAME = ?, GENDER =?, AGE =?, ADDR=? WHERE SEQ = ?";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getAddress());
			psmt.setInt(5, dto.getSeq());
			
			psmt.execute();
			
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	public void deleteUser6(int seq) {
		Connection conn = DBConnection();
		
		String sql = "DELETE FROM USER6 WHERE SEQ = ?";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);

			psmt.execute();
			
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
}
