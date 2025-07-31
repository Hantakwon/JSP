<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User4 수정</title>
</head>
<body>
	<h3>User4 수정</h3>

	<a href="/ch09">처음으로</a>
	<a href="/ch09/user4/list.do">등록하기</a>

	<form action="/ch09/user4/modify.do" method="POST">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${user.name}" readonly/></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
				<c:choose>
					<c:when test="${user.gender eq 'M'}">
						<label><input type="radio" name="gender" value="M" checked/>M</label>
						<label><input type="radio" name="gender" value="F" />F</label>
					</c:when>
					<c:otherwise>
						<label><input type="radio" name="gender" value="M" />M</label>
						<label><input type="radio" name="gender" value="F" checked/>F</label>
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="age" value="${user.age}" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" value="${user.address}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>