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
	Context ctx = (Context) new InitialContext().lookup("java:comp/env");
	DataSource ds = (DataSource) ctx.lookup("jdbc/gca1234");
	Connection conn = ds.getConnection();

	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT * FROM FILES");
	
	List<FileDTO> files = new ArrayList<FileDTO>();
	
	while(rs.next()) {
		FileDTO dto = new FileDTO();
		
		dto.setNo(rs.getInt(1));
		dto.setTitle(rs.getString(2));
		dto.setName(rs.getString(3));
		dto.setOname(rs.getString(4));
		dto.setSname(rs.getString(5));
		dto.setRdate(rs.getString(6));
		
		files.add(dto);
	}
	
	rs.close();
	stmt.close();
	conn.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileDownload</title>
	<!-- 
		날짜 : 2025/07/30
		이름 : 한탁원
		내용 : JSP 파일 업로드 실습하기
	 -->
</head>
<body>
	<h3>파일 다운로드</h3>
	
	<a href="/ch06/fileUpload.jsp">파일 업로드</a>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>파일명</th>
			<th>관리</th>
		</tr>
		<% for(FileDTO file : files) { %>
		<tr>
			<td><%= file.getNo() %></td>
			<td><%= file.getTitle() %></td>
			<td><%= file.getName() %></td>
			<td>><a href="/ch06/proc/fileDownload.jsp?no=<%= file.getNo() %>"><%= file.getOname() %></a></td>
			<td>
				<a href="/ch06/proc/delete.jsp?no=<%= file.getNo() %>">삭제</a>
				<a href="/ch06/proc/fileDownload.jsp?no=<%= file.getNo() %>">다운로드</a>
			</td>
		</tr>
		<%} %>
	</table>
</body>
</html>				