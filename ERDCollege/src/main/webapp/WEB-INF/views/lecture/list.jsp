<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강좌 목록</title>
</head>
<body>
	<h3>강좌 목록</h3>
	
	<a href="/ERDCollege/">처음으로</a>
	<a href="/ERDCollege/lecture/register.do">등록하기</a>
	
	<table border="1">
		<tr>
			<th>강좌번호</th>
			<th>강좌명</th>
			<th>학점</th>
			<th>시간</th>
			<th>강의실</th>
			<th>신청</th>
			<th>관리</th>
		</tr>
		<c:forEach var="lecture" items="${lectureList}">
			<tr>
				<td>${lecture.lecNo}</td>
				<td>${lecture.lecName}</td>
				<td>${lecture.lecCredit}</td>
				<td>${lecture.lecTime}</td>
				<td>${lecture.lecClass}</td>		
				<td>				
					<a href="/ERDCollege/register/request.do?regLecNo=${lecture.lecNo}">수강신청</a>
				</td>
				<td>
					<a href="/ERDCollege/lecture/modify.do?regLecNo=${lecture.lecNo}">수정</a>
					<a href="/ERDCollege/lecture/delete.do?regLecNo=${lecture.lecNo}">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>