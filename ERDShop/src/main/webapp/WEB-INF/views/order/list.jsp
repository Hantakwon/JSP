<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop/Order::list</title>
</head>
<body>
	<h3>주문 목록</h3>
	
	<a href="/shopApp">처음으로</a>
	
	<table border="1">
		<tr>
			<th>주문번호</th>
			<th>주문자</th>
			<th>주문상품</th>
			<th>주문수량</th>
			<th>주문일</th>
			<th>관리</th>
		</tr>
		<c:forEach var="order" items="${orderList}">
		<tr>
			<td>${order.orderNo}</td>
			<td>${order.orderId}</td>
			<td>${order.orderProduct}</td>
			<td>${order.orderCount}</td>
			<td>${order.orderDate}</td>		
			<td>
				<a href="/shopApp/order/modify.do?orderNo=${order.orderNo}">수정</a>
				<a href="/shopApp/order/delete.do?orderNo=${order.orderNo}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>