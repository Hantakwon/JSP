<%@page import="vo.User7VO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//데이터베이스 INSERT
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "gca1234";
	String password = "1234";
	
	Connection conn;
	Statement stmt;
	
	// 드라이버 로드
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	// 데이터베이스 접속
	conn = DriverManager.getConnection(host, user, password);
	stmt = conn.createStatement();
	
	String sql = "SELECT * FROM USER7";
	ResultSet rs = stmt.executeQuery(sql);
	
	List<User7VO> userList = new ArrayList<User7VO>();
	
	while(rs.next()) {
		User7VO userVO = new User7VO();
		userVO.setId(rs.getString(1));
		userVO.setName(rs.getString(2));
		userVO.setAge(rs.getInt(3));
		userVO.setEmail(rs.getString(4));
		
		userList.add(userVO);
	}
	
	rs.close();
	stmt.close();
	conn.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user7::list</title>
</head>
<body>
	<h3>User7 목록</h3>
	
	<a href="../jdbc.jsp">처음으로</a>
	<a href="./register.jsp">등록하기</a>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>이메일</th>
			<th>관리</th>
		</tr>
		<% for (User7VO userVO : userList) { %>
		<tr>
			<td><%= userVO.getId() %></td>
			<td><%= userVO.getName() %></td>
			<td><%= userVO.getAge() %></td>
			<td><%= userVO.getEmail() %></td>
			<td>
				<a href="./modify.jsp?id=<%= userVO.getId() %>">수정</a>
				<a href="./delete.jsp?id=<%= userVO.getId() %>">삭제</a>
			</td>
		</tr>
		<%} %>
	</table>
</body>
</html>