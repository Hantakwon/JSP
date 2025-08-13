<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop/Customer::list</title>
</head>
<body>
	<h3>회원목록</h3>
	
	<a href="/shopApp">처음으로</a>
	<a href="/shopApp/customer/register.do">등록하기</a>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>주소</th>
			<th>가입일</th>
			<th>관리</th>
		</tr>
		<c:forEach var="customer" items="${customerList}">
		<tr>
			<td>${customer.custId}</td>
			<td>${customer.name}</td>
			<td>${customer.hp}</td>
			<td>${customer.addr}</td>
			<td>${customer.rdate}</td>		
			<td>
				<a href="/shopApp/customer/modify.do?custId=${customer.custId}">수정</a>
				<a href="/shopApp/customer/delete.do?custId=${customer.custId}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>