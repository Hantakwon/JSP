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

import dto.User7DTO;

// DAO(Data Access Object) : DB 처리를 수행하는 객체
public class User7DAO {
	
	// DAO는 기본 싱글톤
	private final static User7DAO INSTANCE = new User7DAO();
	
	public static User7DAO getInstance() {
		return INSTANCE;
	}
	
	private User7DAO() {}
	
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
	public void insertUser7(User7DTO dto) {
		Connection conn = DBConnection();
		
		String sql = "INSERT INTO USER7 VALUES(?, ?, ?, ?)";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getEmail());
			
			psmt.execute();
		
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};	
	
	public User7DTO selectUser7(String id) {
		Connection conn = DBConnection();
		
		String sql = "SELECT * FROM USER7 WHERE ID = ?";
		PreparedStatement psmt;
		ResultSet rs;
		User7DTO dto = new User7DTO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setEmail(rs.getString(4));
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
	public List<User7DTO> selectAllUser7() {
		Connection conn = DBConnection();
		
		String sql = "SELECT * FROM USER7";
		Statement stmt;
		ResultSet rs;
		List<User7DTO> userList = new ArrayList<User7DTO>();
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				User7DTO dto = new User7DTO();
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setEmail(rs.getString(4));
				
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
	public void updateUser7(User7DTO dto) {
		Connection conn = DBConnection();
		
		String sql = "UPDATE USER7 SET NAME =?, AGE =?, EMAIL=? WHERE ID = ?";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setInt(2, dto.getAge());
			psmt.setString(3, dto.getEmail());
			psmt.setString(4, dto.getId());

			psmt.execute();
			
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	public void deleteUser7(String id) {
		Connection conn = DBConnection();
		
		String sql = "DELETE FROM USER7 WHERE ID = ?";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			psmt.execute();
			
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
}
