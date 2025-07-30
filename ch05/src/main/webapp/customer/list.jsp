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
	//DBCP 커넥션풀 객체 가져오기
	Context ctx = (Context) new InitialContext().lookup("java:comp/env"); // java 기본 환경 객체 검색
	DataSource ds = (DataSource) ctx.lookup("jdbc/gca1234"); // jdbc/gca1234 커넥션을 객체 섬색
	
	// 커넥션풀에서 접속 커넥션 가져오기
	Connection conn = ds.getConnection();
	Statement stmt = conn.createStatement();
	String sql = "SELECT * FROM CUSTOMER";
	ResultSet rs = stmt.executeQuery(sql);
	
	List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
	
	while(rs.next()) {
		CustomerDTO customer = new CustomerDTO();
		customer.setCid(rs.getString(1));
		customer.setName(rs.getString(2));
		customer.setHp(rs.getString(3));
		customer.setAddress(rs.getString(4));
		customer.setRdate(rs.getString(5));
		
		customers.add(customer);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer::list</title>
</head>
<body>
	<h3>customer 목록</h3>
	
	<a href="../dbcp.jsp">처음으로</a>
	<a href="./register.jsp">등록하기</a>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>주소</th>
			<th>등록일</th>
			<th>관리</th>
		</tr>
		<% for(CustomerDTO customer : customers) {%>
		<tr>
			<td><%=customer.getCid()%></td>
			<td><%=customer.getName()%></td>
			<td><%=customer.getHp()%></td>
			<td><%=customer.getAddress()%></td>
			<td><%=customer.getRdate().substring(0, 10)%></td>
			<td>
				<a href="/ch05/customer/modify.jsp?cid=<%=customer.getCid()%>">수정</a>
				<a href="/ch05/customer/delete.jsp?cid=<%=customer.getCid()%>">삭제</a>
			</td>
		</tr>
		<%} %>
	</table>
</body>
</html>