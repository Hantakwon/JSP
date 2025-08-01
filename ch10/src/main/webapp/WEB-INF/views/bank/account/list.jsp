<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank/account::list</title>
</head>
<body>
	<h3>Bank/account 목록</h3>
	
	<a href="/ch10">처음으로</a>
	<a href="/ch10/bank/account/register.do">등록하기</a>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>계좌 종류</th>
			<th>계좌 이름</th>
			<th>계좌 번호</th>
			<th>계좌 잔액</th>
			<th>계좌 개설일</th>
			<th>관리</th>
		</tr>
		<c:forEach var="account" items="${accounts}">
		<tr>
			<td>${account.acc_no}</td>
			<td>${account.acc_type}</td>
			<td>${account.acc_name}</td>
			<td>${account.acc_cid}</td>
			<td>${account.acc_balance}</td>
			<td>${account.acc_date}</td>			
			<td>
				<a href="/ch10/bank/account/modify.do?acc_no=${account.acc_no}">수정</a>
				<a href="/ch10/bank/account/delete.do?acc_no=${account.acc_no}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>