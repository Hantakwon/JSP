<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User5 등록</title>
</head>
<body>
	<h3>MySQL User5 등록</h3>
	
	<a href="/ch10">처음으로</a>
	<a href="/ch10/user5/list.do">목록으로</a>
	
	<form action="/ch10/user5/register.do" method="POST">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" placeholder="이름 입력" /></td>
			</tr>
			<tr>
				<td>성별</td>
				
				<td><input type="text" name="gender" placeholder="성별 입력" /></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="age" placeholder="나이 입력" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" placeholder="주소 입력" /></td>
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