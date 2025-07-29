<%@page import="vo.User6VO"%>
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
	
	String sql = "SELECT * FROM USER6";
	ResultSet rs = stmt.executeQuery(sql);
	
	List<User6VO> userList = new ArrayList<User6VO>();
	
	while(rs.next()) {
		User6VO userVO = new User6VO();
		userVO.setSeq(rs.getInt(1));
		userVO.setName(rs.getString(2));
		userVO.setGe(rs.getString(3));
		userVO.setAge(rs.getInt(4));
		userVO.setAddr(rs.getString(5));
		
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
<title>user6::list</title>
</head>
<body>
	<h3>User6 목록</h3>
	
	<a href="../jdbc.jsp">처음으로</a>
	<a href="./register.jsp">등록하기</a>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>성별</th>
			<th>나이</th>
			<th>주소</th>
			<th>관리</th>
		</tr>
		<% for (User6VO userVO : userList) { %>
		<tr>
			<td><%= userVO.getSeq() %></td>
			<td><%= userVO.getName() %></td>
			<td><%= userVO.getGe() %></td>
			<td><%= userVO.getAge() %></td>
			<td><%= userVO.getAddr() %></td>
			<td>
				<a href="./modify.jsp?seq=<%= userVO.getSeq() %>">수정</a>
				<a href="./delete.jsp?seq=<%= userVO.getSeq() %>">삭제</a>
			</td>
		</tr>
		<%} %>
	</table>
</body>
</html>