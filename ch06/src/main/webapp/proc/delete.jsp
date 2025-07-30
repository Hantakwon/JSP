<%@page import="java.io.File"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DTO.FileDTO"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String no = request.getParameter("no");
	String savedName = null;
 
	Context ctx = (Context) new InitialContext().lookup("java:comp/env");
	DataSource ds = (DataSource) ctx.lookup("jdbc/gca1234");
	Connection conn = ds.getConnection();
	
	String sql = "SELECT SNAME FROM FILES WHERE NO = ?";
	PreparedStatement psmtSelect = conn.prepareStatement(sql);
	psmtSelect.setString(1, no);
	
	ResultSet rs = psmtSelect.executeQuery();	
	
	if(rs.next()){
		savedName = rs.getString(1);
	}
	
	PreparedStatement psmt = conn.prepareStatement("DELETE FROM FILES WHERE NO = ?");
	psmt.setString(1, no);

	psmt.executeUpdate();
	
	rs.close();
	psmt.close();
	conn.close();
	
	// 저장된 파일 삭제
	String path = application.getRealPath("/files");
	
	File savedFile = new File(path + File.separator + savedName);
	savedFile.delete();
	
	// 파일 목록 이동(리다이렉트)
	response.sendRedirect("/ch06/fileDownload.jsp");
%>