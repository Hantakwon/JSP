<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library/Member::modify</title>
</head>
<body>
	<h3>Library/Member 수정</h3>

	<a href="/ch10">처음으로</a>
	<a href="/ch10/library/member/list.do">목록으로</a>

	<form action="/ch10/library/member/modify.do" method="POST">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="number" name="member_id" value="${member.member_id}" readonly/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${member.name}" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" value="${member.address}" /></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp" value="${member.hp}" /></td>
			</tr>
			<tr>
				<td>가입일</td>
				<td><input type="date" name="join_date" value="${member.join_date}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>