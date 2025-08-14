<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop/product::modify</title>
</head>
<body>
	<h3>상품 수정</h3>

	<a href="/shopApp">처음으로</a>
	<a href="/shopApp/product/list.do">목록으로</a>

	<form action="/shopApp/product/modify.do" method="POST">
		<table border="1">
			<tr>
				<td>상품번호</td>
				<td><input type="text" name="prodNo" value="${product.prodNo}" readonly/></td>
			</tr>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="prodName" value="${product.prodName}" /></td>
			</tr>
			<tr>
				<td>재고량</td>
				<td><input type="number" name="stock" value="${product.stock}" /></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="number" name="price" value="${product.price}" /></td>
			</tr>
			<tr>
				<td>제조사</td>
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