<%@page import="vo.User3VO"%>
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
	
	String sql = "SELECT * FROM USER3";
	ResultSet rs = stmt.executeQuery(sql);
	
	List<User3VO> userList = new ArrayList<User3VO>();
	
	while(rs.next()) {
		User3VO userVO = new User3VO();
		userVO.setUser_id(rs.getString(1));
		userVO.setName(rs.getString(2));
		userVO.setHp(rs.getString(3));
		userVO.setAge(rs.getInt(4));
		
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
<title>user3::list</title>
</head>
<body>
	<h3>User3 목록</h3>
	
	<a href="../jdbc.jsp">처음으로</a>
	<a href="./register.jsp">등록하기</a>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>나이</th>
			<th>관리</th>
		</tr>
		<% for (User3VO userVO : userList) { %>
		<tr>
			<td><%= userVO.getUser_id() %></td>
			<td><%= userVO.getName() %></td>
			<td><%= userVO.getHp() %></td>
			<td><%= userVO.getAge() %></td>
			<td>
				<a href="./modify.jsp?user_id=<%= userVO.getUser_id() %>">수정</a>
				<a href="./delete.jsp?user_id=<%= userVO.getUser_id() %>">삭제</a>
			</td>
		</tr>
		<%} %>
	</table>
</body>
</html>