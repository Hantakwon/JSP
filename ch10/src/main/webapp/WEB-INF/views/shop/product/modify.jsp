<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop/Product::modify</title>
</head>
<body>
	<h3>Shop/Product 수정</h3>

	<a href="/ch10">처음으로</a>
	<a href="/ch10/shop/product/list.do">목록으로</a>

	<form action="/ch10/shop/product/modify.do" method="POST">
		<table border="1">
			<tr>
				<td>번호</td>
				<td><input type="number" name="pno" value="${product.pno}" readonly/></td>
			</tr>
			<tr>
				<td>제품명</td>
				<td><input type="text" name="pname" value="${product.pname}" /></td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="number" name="stock" value="${product.stock}" /></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="number" name="price" value="${product.price}" /></td>
			</tr>
			<tr>
				<td>회사</td>
				<td><input type="text" name="company" value="${product.company}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>