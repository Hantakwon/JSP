<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>College</title>
</head>
<body>
	<h3>미니 학사관리 프로젝트</h3>

	<p>
		그린대학교에 오신것을 환영합니다.<br> 
		수강신청을 하려면 로그인을 하시기 바랍니다.<br>
		로그인을 해야 서비스를 이용할 수 있습니다.
	</p>

	<c:if test="${empty sessUser}">
		<form action="/ERDCollege/student/login.do" method="POST">
			<table border='1'>
				<tr>
					<td>학번</td>
					<td><input type="text" name="stdNo" placeholder="학번 입력" /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="stdName" placeholder="이름 입력" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="로그인" />
					</td>
				</tr>
			</table>
		</form>
	</c:if>

	<c:if test="${not empty sessUser}">
		<p>
			${sessUser.stdName}(${sessUser.stdNo})님,환영합니다!
			<a href="/ERDCollege/student/logout.do">로그아웃</a>
		</p>

		<a href="/ERDCollege/student/list.do">학생목록</a>
		<a href="/ERDCollege/lecture/list.do">강의목록</a>
		<a href="/ERDCollege/register/list.do">수강목록</a>

	</c:if>

</body>
</html>