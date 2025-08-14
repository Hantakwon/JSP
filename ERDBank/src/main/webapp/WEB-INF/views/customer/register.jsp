<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 등록</title>
</head>
<body>
	<h3>고객 등록</h3>
	
	<a href="/ERDBank/">처음으로</a>
	<a href="/ERDBank/customer/list.do">목록으로</a>
	
	<form action="/ERDBank/customer/register.do" method="POST">
		<table border="1">
			<tr>
				<td>주민등록번호</td>
				<td><input type="text" name="c_no" placeholder="주민등록번호 입력" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="c_name" placeholder="이름 입력"  /></td>
			</tr>
			<tr>
				<td>구분</td>
				<td><input type="number" name="c_dist" placeholder="구분 입력"  /></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="c_phone" placeholder="휴대폰 입력"  /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="c_addr" placeholder="주소 입력"  /></td>
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