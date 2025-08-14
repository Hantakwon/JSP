<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 목록</title>
</head>
<body>
	<h3>학생 목록</h3>
	
	<a href="/ERDCollege/">처음으로</a>
	<a href="/ERDCollege/student/register.do">등록하기</a>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>주소</th>
			<th>가입일</th>
			<th>관리</th>
		</tr>
		<c:forEach var="student" items="${studentList}">
		<tr>
			<td>${student.stdNo}</td>
			<td>${student.stdName}</td>
			<td>${student.stdHp}</td>
			<td>${student.stdYear}</td>
			<td>${student.stdAddress}</td>		
			<td>
				<a href="/ERDCollege/student/modify.do?stdNo=${student.stdNo}">수정</a>
				<a href="/ERDCollege/student/delete.do?stdNo=${student.stdNo}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>