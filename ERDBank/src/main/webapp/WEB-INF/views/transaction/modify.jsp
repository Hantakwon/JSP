<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>거래 수정</title>
</head>
<body>
	<h3>거래 수정</h3>

	<a href="/ERDBank/">처음으로</a>
	<a href="/ERDBank/transaction/list.do">목록으로</a>
			
	<form action="/ERDBank/transaction/modify.do" method="POST">
		<table border="1">
			<tr>
				<td>번호</td>
				<td><input type="number" name="t_no" value="${transaction.t_no}" readonly/></td>
			</tr>
			<tr>
				<td>계좌번호</td>
				<td><input type="text" name="t_a_no" value="${transaction.t_a_no}" readonly/></td>
			</tr>
			<tr>
				<td>구분</td>
				<td><input type="number" name="t_dist" value="${transaction.t_dist}" /></td>
			</tr>
			<tr>
				<td>금액</td>
				<td><input type="number" name="t_amount" value="${transaction.t_amount}" /></td>
			</tr>
			<tr>
				<td>거래일</td>
				<td><input type="date" name="t_dateTime" value="${transaction.t_dateTime}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>