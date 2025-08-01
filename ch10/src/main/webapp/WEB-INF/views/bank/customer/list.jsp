<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank/customer::list</title>
</head>
<body>
	<h3>Bank/customer 목록</h3>
	
	<a href="/ch10">처음으로</a>
	<a href="/ch10/bank/customer/register.do">등록하기</a>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>종류</th>
			<th>휴대폰</th>
			<th>주소</th>
			<th>관리</th>
		</tr>
		<c:forEach var="customer" items="${customers}">
		<tr>
			<td>${customer.c_id}</td>
			<td>${customer.c_name}</td>
			<td>${customer.c_type}</td>
			<td>${customer.c_hp}</td>
			<td>${customer.c_addr}</td>		
			<td>
				<a href="/ch10/bank/customer/modify.do?c_id=${customer.c_id}">수정</a>
				<a href="/ch10/bank/customer/delete.do?c_id=${customer.c_id}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>