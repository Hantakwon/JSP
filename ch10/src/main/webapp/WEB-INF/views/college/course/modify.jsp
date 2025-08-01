<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>College/Course::modify</title>
</head>
<body>
	<h3>College/Course 수정</h3>

	<a href="/ch10">처음으로</a>
	<a href="/ch10/college/course/list.do">목록으로</a>

	<form action="/ch10/college/course/modify.do" method="POST">
		<table border="1">
			<tr>
				<td>과목 번호</td>
				<td><input type="number" name="cs_id" value="${course.cs_id}" readonly/></td>
			</tr>
			<tr>
				<td>과목 이름</td>
				<td><input type="text" name="cs_name" value="${course.cs_name}" /></td>
			</tr>
			<tr>
				<td>학점</td>
				<td><input type="number" name="cs_credit" value="${course.cs_credit}" /></td>
			</tr>
			<tr>
				<td>학과</td>
				<td><input type="text" name="cs_dept" value="${course.cs_dept}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>