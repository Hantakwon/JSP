<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	String user_id = request.getParameter("user_id");

	// 데이터베이스 INSERT
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "gca1234";
	String password = "1234";
	
	Connection conn;
	PreparedStatement psmt;
	
	// 드라이버 로드
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	// 데이터베이스 접속
	conn = DriverManager.getConnection(host, user, password);
	
	// SQL 실행 객체 생성
	String sql = "DELETE FROM USER2 WHERE USER_ID = ?";
	psmt = conn.prepareStatement(sql);
	psmt.setString(1, user_id);
	
	// SQL 실행
	psmt.executeUpdate();
	
	// 데이터베이스 종료
	psmt.close();
	conn.close();
	
	// 목록이동
	response.sendRedirect("./list.jsp");
%>