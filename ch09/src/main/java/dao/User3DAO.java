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

import dto.User3DTO;

// DAO(Data Access Object) : DB 처리를 수행하는 객체
public class User3DAO {
	
	// DAO는 기본 싱글톤
	private final static User3DAO INSTANCE = new User3DAO();
	
	public static User3DAO getInstance() {
		return INSTANCE;
	}
	
	private User3DAO() {}
	
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
	public void insertUser3(User3DTO dto) {
		Connection conn = DBConnection();
		
		String sql = "INSERT INTO USER3 VALUES(?, ?, ?, ?)";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUser_id());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getHp());
			psmt.setInt(4, dto.getAge());

			psmt.execute();
		
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};	
	
	public User3DTO selectUser3(String user_id) {
		Connection conn = DBConnection();
		
		String sql = "SELECT * FROM USER3 WHERE USER_ID = ?";
		PreparedStatement psmt;
		ResultSet rs;
		User3DTO dto = new User3DTO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);

			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setUser_id(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAge(rs.getInt(4));
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
	public List<User3DTO> selectAllUser3() {
		Connection conn = DBConnection();
		
		String sql = "SELECT * FROM USER3";
		Statement stmt;
		ResultSet rs;
		List<User3DTO> userList = new ArrayList<User3DTO>();
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				User3DTO dto = new User3DTO();
				dto.setUser_id(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAge(rs.getInt(4));
				
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
	public void updateUser3(User3DTO dto) {
		Connection conn = DBConnection();
		
		String sql = "UPDATE USER3 SET NAME =?, HP =?, AGE=? WHERE USER_ID = ?";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getHp());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getUser_id());

			psmt.execute();
			
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	public void deleteUser3(String user_id) {
		Connection conn = DBConnection();
		
		String sql = "DELETE FROM USER3 WHERE USER_ID = ?";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);

			psmt.execute();
			
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
}
