<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank/customer::modify</title>
</head>
<body>
	<h3>Bank/customer 수정</h3>

	<a href="/ch10">처음으로</a>
	<a href="/ch10/bank/customer/list.do">목록으로</a>

	<form action="/ch10/bank/customer/modify.do" method="POST">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="c_id" value="${customer.c_id}" readonly/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="c_name" value="${customer.c_name}" /></td>
			</tr>
			<tr>
				<td>종류</td>
				<td><input type="number" name="c_type" value="${customer.c_type}" /></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="c_hp" value="${customer.c_hp}" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="c_addr" value="${customer.c_addr}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>