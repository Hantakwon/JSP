<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 수정</title>
</head>
<body>
	<h3>계좌 수정</h3>

	<a href="/ERDBank/">처음으로</a>
	<a href="/ERDBank/account/list.do">목록으로</a>

	<form action="/ERDBank/account/modify.do" method="POST">
		<table border="1">
			<tr>
				<td>계좌번호</td>
				<td><input type="text" name="a_no" value="${account.a_no}" readonly/></td>
			</tr>
			<tr>
				<td>계좌구분</td>
				<td><input type="text" name="a_item_dist" value="${account.a_item_dist}" /></td>
			</tr>
			<tr>
				<td>계좌이름</td>
				<td><input type="text" name="a_item_name" value="${account.a_item_name}" /></td>
			</tr>
			<tr>
				<td>주민등록번호</td>
				<td><input type="text" name="a_c_no" value="${account.a_c_no}" readonly/></td>
			</tr>
			<tr>
				<td>잔액</td>
				<td><input type="number" name="a_balance" value="${account.a_balance}" /></td>
			</tr>
			<tr>
				<td>신청일</td>
				<td><input type="date" name="a_open_date" value="${account.a_open_date}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>