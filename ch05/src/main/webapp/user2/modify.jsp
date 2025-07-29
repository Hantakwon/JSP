<%@page import="java.sql.PreparedStatement"%>
<%@page import="vo.User2VO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String user_id = request.getParameter("user_id");
	
	//데이터베이스 INSERT
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "gca1234";
	String password = "1234";
	
	Connection conn;
	PreparedStatement psmt;
	
	// 드라이버 로드
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	// 데이터베이스 접속
	conn = DriverManager.getConnection(host, user, password);
	
	String sql = "SELECT * FROM USER2 WHERE USER_ID = ?";
	psmt = conn.prepareStatement(sql);
	psmt.setString(1, user_id);
	
	ResultSet rs = psmt.executeQuery();

	User2VO userVO = new User2VO();

	if(rs.next()){
		userVO.setUser_id(rs.getString(1));
		userVO.setName(rs.getString(2));
		userVO.setHp(rs.getString(3));
		userVO.setAge(rs.getInt(4));
	}
	
	rs.close();
	psmt.close();
	conn.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User2 수정</title>
</head>
<body>
	<h3>User2 수정</h3>

	<a href="../jdbc.jsp">처음으로</a>
	<a href="./list.jsp">목록이동</a>

	<form action="./proc/modify.jsp" method="POST">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="user_id" value=<%= userVO.getUser_id() %> readonly/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=<%= userVO.getName() %> /></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp" value=<%= userVO.getHp() %> /></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="age" value=<%= userVO.getAge() %> /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>