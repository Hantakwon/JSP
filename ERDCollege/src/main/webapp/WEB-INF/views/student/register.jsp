<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 등록</title>
</head>
<body>
	<h3>학생 등록</h3>
	
	<a href="/ERDCollege/">처음으로</a>
	<a href="/ERDCollege/student/list.do">목록으로</a>
	
	<form action="/ERDCollege/student/register.do" method="POST">
		<table border="1">
			<tr>
				<td>학번</td>
				<td><input type="text" name="stdNo" placeholder="학번 입력" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="stdName" placeholder="이름 입력" /></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="stdHp" placeholder="휴대폰 입력" /></td>
			</tr>
			<tr>
				<td>학년</td>
				<td><input type="number" name="stdYear" placeholder="학년 입력" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="stdAddress" placeholder="주소 입력" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="등록하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>