<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 목록</title>
</head>
<body>
	<h3>고객 목록</h3>
	
	<a href="/ERDBank/">처음으로</a>
	<a href="/ERDBank/customer/register.do">등록하기</a>
	
	<table border="1">
		<tr>
			<th>주민등록번호</th>
			<th>이름</th>
			<th>구분</th>
			<th>휴대폰</th>
			<th>주소</th>
			<th>관리</th>
		</tr>
		<c:forEach var="customer" items="${customerList}">
		<tr>
			<td>${customer.c_no}</td>
			<td>${customer.c_name}</td>
			<td>${customer.c_dist}</td>
			<td>${customer.c_phone}</td>
			<td>${customer.c_addr}</td>		
			<td>
				<a href="/ERDBank/customer/modify.do?c_no=${customer.c_no}">수정</a>
				<a href="/ERDBank/customer/delete.do?c_no=${customer.c_no}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>