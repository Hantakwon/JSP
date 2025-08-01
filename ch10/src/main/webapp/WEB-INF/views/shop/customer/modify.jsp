<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop/Customer::modify</title>
</head>
<body>
	<h3>Shop/Customer 수정</h3>

	<a href="/ch10">처음으로</a>
	<a href="/ch10/shop/customer/list.do">목록으로</a>

	<form action="/ch10/shop/customer/modify.do" method="POST">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="cid" value="${customer.cid}" readonly/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${customer.name}" /></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp" value="${customer.hp}" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" value="${customer.address}" /></td>
			</tr>
			<tr>
				<td>가입일</td>
				<td><input type="date" name="rdate" value="${customer.rdate}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>