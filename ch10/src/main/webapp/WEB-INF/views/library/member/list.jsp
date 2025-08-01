<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library/Member::list</title>
</head>
<body>
	<h3>Library/Member 목록</h3>
	
	<a href="/ch10">처음으로</a>
	<a href="/ch10/library/member/register.do">등록하기</a>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>휴대폰</th>
			<th>가입일</th>
			<th>관리</th>
		</tr>
		<c:forEach var="member" items="${members}">
		<tr>
			<td>${member.member_id}</td>
			<td>${member.name}</td>
			<td>${member.address}</td>
			<td>${member.hp}</td>
			<td>${member.join_date}</td>
			<td>
				<a href="/ch10/library/member/modify.do?member_id=${member.member_id}">수정</a>
				<a href="/ch10/library/member/delete.do?member_id=${member.member_id}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>