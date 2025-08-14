<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop/Order::modify</title>
</head>
<body>
	<h3>주문 수정</h3>

	<a href="/shopApp">처음으로</a>
	<a href="/shopApp/order/list.do">목록으로</a>

	<form action="/shopApp/order/modify.do" method="POST">
		<table border="1">
			<tr>
				<td>주문번호</td>
				<td><input type="text" name="orderNo" value="${order.orderNo}" readonly/></td>
			</tr>
			<tr>
				<td>주문자</td>
				<td><input type="text" name="orderId" value="${order.orderId}" /></td>
			</tr>
			<tr>
				<td>주문상품</td>
				<td><input type="text" name="orderProduct" value="${order.orderProduct}" /></td>
			</tr>
			<tr>
				<td>주문수량</td>
				<td><input type="text" name="orderCount" value="${order.orderCount}" /></td>
			</tr>
			<tr>
				<td>주문일</td>
				<td><input type="date" name="orderDate" value="${order.orderDate}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>