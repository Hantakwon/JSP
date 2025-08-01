<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>College/Course::list</title>
</head>
<body>
	<h3>College/Course 목록</h3>
	
	<a href="/ch10">처음으로</a>
	<a href="/ch10/college/course/register.do">등록하기</a>
	
	<table border="1">
		<tr>
			<th>과목 번호</th>
			<th>과목 이름</th>
			<th>학점</th>
			<th>학과</th>
			<th>관리</th>
		</tr>
		<c:forEach var="course" items="${courses}">
		<tr>
			<td>${course.cs_id}</td>
			<td>${course.cs_name}</td>
			<td>${course.cs_credit}</td>
			<td>${course.cs_dept}</td>
			<td>
				<a href="/ch10/college/course/modify.do?cs_id=${course.cs_id}">수정</a>
				<a href="/ch10/college/course/delete.do?cs_id=${course.cs_id}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>