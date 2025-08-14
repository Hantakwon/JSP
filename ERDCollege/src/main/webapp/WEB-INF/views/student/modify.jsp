<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 수정</title>
</head>
<body>
	<h3>학생 수정</h3>

	<a href="/ERDCollege/">처음으로</a>
	<a href="/ERDCollege/student/list.do">목록으로</a>

	<form action="/ERDCollege/student/modify.do" method="POST">
		<table border="1">
			<tr>
				<td>학번</td>
				<td><input type="text" name="stdNo" value="${student.stdNo}" readonly/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="stdName" value="${student.stdName}" /></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="stdHp" value="${student.stdHp}" /></td>
			</tr>
			<tr>
				<td>학년</td>
				<td><input type="number" name="stdYear" value="${student.stdYear}" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="stdAddress" value="${student.stdAddress}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>