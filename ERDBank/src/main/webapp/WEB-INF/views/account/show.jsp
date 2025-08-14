<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>거래 목록</title>
</head>
<body>
	<h3>거래 목록</h3>
	
	<a href="/ERDBank/">처음으로</a>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>계좌번호</th>
			<th>구분</th>
			<th>금액</th>
			<th>거래일</th>
			<th>관리</th>
		</tr>	
		<c:forEach var="transaction" items="${transactionList}">
		<tr>
			<td>${transaction.t_no}</td>
			<td>${transaction.t_a_no}</td>
			<td>${transaction.t_dist}</td>
			<td>${transaction.t_amount}</td>
			<td>${transaction.t_dateTime}</td>		
			<td>
				<a href="/ERDBank/transaction/modify.do?t_no=${transaction.t_no}">수정</a>
				<a href="/ERDBank/transaction/delete.do?t_no=${transaction.t_no}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>