<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank/Customer::register</title>
</head>
<body>
	<h3>Bank/Customer 등록</h3>
	
	<a href="/ch10">처음으로</a>
	<a href="/ch10/bank/customer/list.do">목록으로</a>
	
	<form action="/ch10/bank/customer/register.do" method="POST">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="c_id" placeholder="아이디 입력" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="c_name" placeholder="이름 입력" /></td>
			</tr>
			<tr>
				<td>종류</td>
				<td><input type="number" name="c_type" placeholder="종류 입력" /></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="c_hp" placeholder="휴대폰 입력" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="c_addr" placeholder="주소 입력" /></td>
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