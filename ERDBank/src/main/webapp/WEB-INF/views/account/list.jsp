<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 목록</title>
</head>
<body>
	<h3>계좌 목록</h3>
	
	<a href="/ERDBank/">처음으로</a>
	<a href="/ERDBank/account/register.do">등록하기</a>
	
	<table border="1">
		<tr>
			<th>계좌번호</th>
			<th>계좌종류</th>
			<th>계좌 상품명</th>
			<th>입금주</th>
			<th>현재잔액</th>
			<th>계좌 개설일</th>
			<th>관리</th>
			<th>작업</th>
		</tr>
		<c:forEach var="account" items="${accountList}">
			<tr>
				<td>${account.a_no}</td>
				<td>${account.a_item_dist}</td>
				<td>${account.a_item_name}</td>
				<td>${account.a_c_name}(${account.a_c_no})</td>
				<td>${account.a_balance}</td>		
				<td>${account.a_open_date}</td>	
				<td>
					<a href="/ERDBank/account/modify.do?a_no=${account.a_no}">수정</a>
					<a href="/ERDBank/account/delete.do?a_no=${account.a_no}">삭제</a>
				</td>
				<c:if test="${sessUser.c_no eq account.a_c_no}">
					<td>				
						<a href="/ERDBank/account/deposit.do">입금</a>
						<a href="/ERDBank/account/withdraw.do">출금</a>
						<a href="/ERDBank/account/show.do">조회</a>
						<a href="/ERDBank/account/transfer.do">이체</a>
					</td>
				</c:if>
				
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>