<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>College/Course::register</title>
</head>
<body>
	<h3>College/Course 등록</h3>
	
	<a href="/ch10">처음으로</a>
	<a href="/ch10/college/course/list.do">목록으로</a>
	
	<form action="/ch10/college/course/register.do" method="POST">
			<table border="1">
			<tr>
				<td>과목 번호</td>
				<td><input type="number" name="cs_id" placeholder = "과목 번호 입력" /></td>
			</tr>
			<tr>
				<td>과목 이름</td>
				<td><input type="text" name="cs_name" placeholder = "과목 이름 입력" /></td>
			</tr>
			<tr>
				<td>학점</td>
				<td><input type="number" name="cs_credit" placeholder = "학점 입력"/></td>
			</tr>
			<tr>
				<td>학과</td>
				<td><input type="text" name="cs_dept" placeholder = "학과 입력" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>