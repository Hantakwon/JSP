<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 등록</title>
</head>
<body>
	<h3>게좌 등록</h3>
	
	<a href="/ERDBank/">처음으로</a>
	<a href="/ERDBank/account/list.do">목록으로</a>
	
	<form action="/ERDBank/account/register.do" method="POST">
		<table border="1">
			<tr>
				<td>계좌번호</td>
				<td><input type="text" name="a_no" placeholder="계좌번호 입력" /></td>
			</tr>
			<tr>
				<td>계좌구분</td>
				<td><input type="text" name="a_item_dist" placeholder="계좌구분 입력" /></td>
			</tr>
			<tr>
				<td>계좌이름</td>
				<td><input type="text" name="a_item_name" placeholder="계좌이름 입력"  /></td>
			</tr>
			<tr>
				<td>주민등록번호</td>
				<td><input type="text" name="a_c_no" placeholder="주민등록번호 입력"  /></td>
			</tr>
			<tr>
				<td>잔액</td>
				<td><input type="number" name="a_balance" placeholder="잔액 입력"  /></td>
			</tr>
			<tr>
				<td>신청일</td>
				<td><input type="date" name="a_open_date" placeholder="신청일 입력"  /></td>
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