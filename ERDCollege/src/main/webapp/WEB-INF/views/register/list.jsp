<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 목록</title>
</head>
<body>
	<h3>수강 목록</h3>
	
	<a href="/ERDCollege/">처음으로</a>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>주소</th>
			<th>가입일</th>
			<th>가입일</th>
			<th>관리</th>
		</tr>	
		<c:forEach var="register" items="${registerList}">
		<tr>
			<td>${register.regStdNo}</td>
			<td>${register.regLecNo}</td>
			<td>${register.regMidScore}</td>
			<td>${register.regFinalScore}</td>
			<td>${register.regTotalScore}</td>		
			<td>${register.regGrade}</td>		
			<td>
				<a href="/ERDCollege/register/modify.do?regStdNo=${register.regStdNo}&regLecNo=${register.regLecNo}">수정</a>
				<a href="/ERDCollege/register/delete.do?regStdNo=${register.regStdNo}&regLecNo=${register.regLecNo}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>