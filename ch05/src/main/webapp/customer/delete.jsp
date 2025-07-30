<%@page import="java.sql.PreparedStatement"%>
<%@page import="vo.CustomerDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cid = request.getParameter("cid");

	//DBCP 커넥션풀 객체 가져오기
	Context ctx = (Context) new InitialContext().lookup("java:comp/env"); // java 기본 환경 객체 검색
	DataSource ds = (DataSource) ctx.lookup("jdbc/gca1234"); // jdbc/gca1234 커넥션을 객체 섬색
	
	// 커넥션풀에서 접속 커넥션 가져오기
	Connection conn = ds.getConnection();

	String sql = "DELETE FROM CUSTOMER WHERE CID = ?";
	PreparedStatement psmt = conn.prepareStatement(sql);
	psmt.setString(1, cid);
	ResultSet rs = psmt.executeQuery();
	
	// 목록 이동
	response.sendRedirect("/ch05/customer/list.jsp");
%>