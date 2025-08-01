<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop/Product::list</title>
</head>
<body>
	<h3>Shop/Product 목록</h3>
	
	<a href="/ch10">처음으로</a>
	<a href="/ch10/shop/product/register.do">등록하기</a>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제품명</th>
			<th>수량</th>
			<th>가격</th>
			<th>회사</th>
			<th>관리</th>
		</tr>
		<c:forEach var="product" items="${products}">
		<tr>
			<td>${product.pno}</td>
			<td>${product.pname}</td>
			<td>${product.stock}</td>
			<td>${product.price}</td>
			<td>${product.company}</td>
			<td>
				<a href="/ch10/shop/product/modify.do?pno=${product.pno}">수정</a>
				<a href="/ch10/shop/product/delete.do?pno=${product.pno}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>