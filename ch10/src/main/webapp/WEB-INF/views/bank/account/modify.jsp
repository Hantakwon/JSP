<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank/account::modify</title>
</head>
<body>
	<h3>Bank/account 수정</h3>

	<a href="/ch10">처음으로</a>
	<a href="/ch10/bank/account/list.do">목록으로</a>

	<form action="/ch10/bank/account/modify.do" method="POST">
		<table border="1">
			<tr>
				<td>번호</td>
				<td><input type="text" name="acc_no" value="${account.acc_no}" readonly/></td>
			</tr>
			<tr>
				<td>계좌 종류</td>
				<td><input type="text" name="acc_type" value="${account.acc_type}" /></td>
			</tr>
			<tr>
				<td>계좌 이름</td>
				<td><input type="text" name="acc_name" value="${account.acc_name}" /></td>
			</tr>
			<tr>
				<td>계좌 번호</td>
				<td><input type="text" name="acc_cid" value="${account.acc_cid}" /></td>
			</tr>
			<tr>
				<td>계좌 잔액</td>
				<td><input type="number" name="acc_balance" value="${account.acc_balance}" /></td>
			</tr>
			<tr>
				<td>계좌 개설일</td>
				<td><input type="date" name="acc_date" value="${account.acc_date}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>