<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user4::list</title>
</head>
<body>
	<h3>User4 목록</h3>
	
	<a href="/ch09">처음으로</a>
	<a href="/ch09/user4/register.do">등록하기</a>
	
	<table border="1">
		<tr>
			<th>이름</th>
			<th>성별</th>
			<th>나이</th>
			<th>주소</th>
			<th>관리</th>
		</tr>
		<c:forEach var="user" items="${userList}">
		<tr>
			<td>${user.name}</td>
			<td>${user.gender}</td>
			<td>${user.age}</td>
			<td>${user.address}</td>
			<td>
				<a href="/ch09/user4/modify.do?name=${user.name}">수정</a>
				<a href="/ch09/user4/delete.do?name=${user.name}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>