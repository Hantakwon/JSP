<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User6 등록</title>
</head>
<body>
	<h3>User6 등록</h3>
	
	<a href="../jdbc.jsp">처음으로</a>
	<a href="./list.jsp">목록이동</a>
	
	<form action="./proc/register.jsp" method="POST">
		<table border="1">
			<tr>
				<td>번호</td>
				<td><input type="text" name="seq" placeholder="번호 입력"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" placeholder="이름 입력" /></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<label><input type="radio" name="ge" value="M" />M</label>
					<label><input type="radio" name="ge" value="F" />F</label>
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="age" placeholder="숫자 입력" /></td>
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