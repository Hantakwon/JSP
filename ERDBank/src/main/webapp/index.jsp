<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank</title>
</head>
<body>
	<h3>미니 뱅킹 프로젝트</h3>
				
	<p>
		그린은행에 오신것을 환영합니다.<br/>
		계좌이체를 하려면 로그인을 하시기 바랍니다.<br/>
		로그인을 해야 서비스를 이용할 수 있습니다.
	</p>

	<c:if test="${empty sessUser}">
		<form action="/ERDBank/customer/login.do" method="POST">
			<table border='1'>
				<tr>
					<td>주민번호</td>
					<td><input type="text" name="c_no" placeholder="주민번호 입력 하세요"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="c_name" placeholder="이름 입력 하세요"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="로그인" />
					</td>
				</tr>
			</table>
		</form>
	</c:if>

	<c:if test="${not empty sessUser}">
		<p>
			${sessUser.c_name}(${sessUser.c_no})님,환영합니다!
			<a href="/ERDBank/customer/logout.do">로그아웃</a>
		</p>

		<a href="/ERDBank/account/list.do">계좌목록</a>
		<a href="/ERDBank/customer/list.do">고객목록</a>
		<a href="/ERDBank/transaction/list.do">거래내역</a>	

	</c:if>

</body>
</html>