<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 입금</title>
</head>
<body>
	<h3>계좌 입금</h3>
	
	<a href="/ERDBank/">처음으로</a>
	<a href="/ERDBank/account/list.do">목록으로</a>
	
	<form action="/ERDBank/account/deposit.do" method="POST">
		<table border="1">
			<tr>
				<td>계좌번호</td>
				<td><input type="text" name="a_no" value="${customer.c_a_no}" readonly /></td>
			</tr>
			<tr>
				<td>입금주</td>
				<td><input type="text" name="a_c_name" value="${customer.c_name}" readonly /></td>
			</tr>
			<tr>
				<td>입금액</td>
				<td><input type="number" name="a_amount" placeholder="입금액 입력"  /></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="입금하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>