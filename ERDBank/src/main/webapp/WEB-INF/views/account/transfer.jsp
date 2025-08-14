<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 이체</title>
</head>
<body>
	<h3>계좌 이체</h3>
	
	<a href="/ERDBank/">처음으로</a>
	<a href="/ERDBank/account/list.do">목록으로</a>
	
	<form action="/ERDBank/account/transfer.do" method="POST">
		<table border="1">
			<tr>
				<td>출금 계좌번호</td>
				<td><input type="text" name="a_no_from" value="${customer.c_a_no}" readonly /></td>
			</tr>
			<tr>
				<td>입금 계좌번호</td>
				<td><input type="text" name="a_no_to" placeholder="입금 계좌번호 입력." /></td>
			</tr>
			<tr>
				<td>입금주</td>
				<td><input type="text" name="a_c_name" value="${customer.c_name}" readonly  /></td>
			</tr>
			<tr>
				<td>이체금액</td>
				<td><input type="text" name="a_amount" placeholder="이체금액 입력" /></td>
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