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

import dto.User5DTO;

// DAO(Data Access Object) : DB 처리를 수행하는 객체
public class User5DAO {
	
	// DAO는 기본 싱글톤
	private final static User5DAO INSTANCE = new User5DAO();
	
	public static User5DAO getInstance() {
		return INSTANCE;
	}
	
	private User5DAO() {}
	
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
	public void insertUser5(User5DTO dto) {
		Connection conn = DBConnection();
		
		String sql = "INSERT INTO USER5 VALUES(?, ?, ?, ?)";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getAddress());
			
			psmt.execute();
		
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};	
	
	public User5DTO selectUser5(String name) {
		Connection conn = DBConnection();
		
		String sql = "SELECT * FROM USER5 WHERE NAME = ?";
		PreparedStatement psmt;
		ResultSet rs;
		User5DTO dto = new User5DTO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);

			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setName(rs.getString(1));
				dto.setGender(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setAddress(rs.getString(4));
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
	public List<User5DTO> selectAllUser5() {
		Connection conn = DBConnection();
		
		String sql = "SELECT * FROM USER5";
		Statement stmt;
		ResultSet rs;
		List<User5DTO> userList = new ArrayList<User5DTO>();
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				User5DTO dto = new User5DTO();
				dto.setName(rs.getString(1));
				dto.setGender(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setAddress(rs.getString(4));
				
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
	public void updateUser5(User5DTO dto) {
		Connection conn = DBConnection();
		
		String sql = "UPDATE USER5 SET GENDER =?, AGE =?, ADDR=? WHERE NAME = ?";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getGender());
			psmt.setInt(2, dto.getAge());
			psmt.setString(3, dto.getAddress());
			psmt.setString(4, dto.getName());

			psmt.execute();
			
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	public void deleteUser5(String name) {
		Connection conn = DBConnection();
		
		String sql = "DELETE FROM USER5 WHERE NAME = ?";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);

			psmt.execute();
			
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
}
