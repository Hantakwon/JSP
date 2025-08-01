<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank/account::register</title>
</head>
<body>
	<h3>Bank/account 등록</h3>
	
	<a href="/ch10">처음으로</a>
	<a href="/ch10/bank/account/list.do">목록으로</a>
	
	<form action="/ch10/bank/account/register.do" method="POST">
		<table border="1">
			<tr>
				<td>번호</td>
				<td><input type="text" name="acc_no" placeholder = "번호 입력" /></td>
			</tr>
			<tr>
				<td>계좌 종류</td>
				<td><input type="text" name="acc_type" placeholder = "계좌 종류 입력" /></td>
			</tr>
			<tr>
				<td>계좌 이름</td>
				<td><input type="text" name="acc_name" placeholder = "계좌 이름 입력" /></td>
			</tr>
			<tr>
				<td>계좌 번호</td>
				<td><input type="text" name="acc_cid" placeholder = "계좌 번호 입력" /></td>
			</tr>
			<tr>
				<td>계좌 잔액</td>
				<td><input type="number" name="acc_balance" placeholder = "계좌 잔액 입력" /></td>
			</tr>
			<tr>
				<td>계좌 개설일</td>
				<td><input type="date" name="acc_date" /></td>
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