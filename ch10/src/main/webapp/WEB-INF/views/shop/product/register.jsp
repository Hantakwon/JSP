<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop/Product::register</title>
</head>
<body>
	<h3>Shop/product 등록</h3>
	
	<a href="/ch10">처음으로</a>
	<a href="/ch10/shop/product/list.do">목록으로</a>
	
	<form action="/ch10/shop/product/register.do" method="POST">
		<table border="1">
			<tr>
				<td>번호</td>
				<td><input type="number" name="pno" placeholder="번호 입력" /></td>
			</tr>
			<tr>
				<td>제품명</td>
				<td><input type="text" name="pname" placeholder="제품명 입력" /></td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="number" name="stock" placeholder="수량 입력" /></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="number" name="price" placeholder="가격 입력" /></td>
			</tr>
			<tr>
				<td>회사</td>
				<td><input type="text" name="company" placeholder="회사 입력" /></td>
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