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

	String sql = "SELECT * FROM CUSTOMER WHERE CID = ?";
	PreparedStatement psmt = conn.prepareStatement(sql);
	psmt.setString(1, cid);
	ResultSet rs = psmt.executeQuery();
	
	CustomerDTO customer = new CustomerDTO();
	
	if(rs.next()) {
		customer.setCid(rs.getString(1));
		customer.setName(rs.getString(2));
		customer.setHp(rs.getString(3));
		customer.setAddress(rs.getString(4));
		customer.setRdate(rs.getString(5));
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer 수정</title>
</head>
<body>
	<h3>customer 수정</h3>

	<a href="../jdbc.jsp">처음으로</a>
	<a href="./list.jsp">목록이동</a>

	<form action="./proc/modify.jsp" method="POST">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="cid" value=<%=customer.getCid()%> readonly /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=<%=customer.getName()%> /></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp" value=<%=customer.getHp()%> /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" value=<%=customer.getAddress()%> /></td>
			</tr>
			<tr>
				<td>등록일</td>
				<td><input type="date" name="rdate" value=<%=customer.getRdate()%> /></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="등록하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>