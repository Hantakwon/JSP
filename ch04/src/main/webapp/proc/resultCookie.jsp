<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	// 요청 객체로 쿠키 값 가져오기
	Cookie[] cookies = request.getCookies();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>resultCookie</title>
</head>
<body>
	<h3>쿠키확인</h3>
	<% for(Cookie cookie : cookies) {%>
		<p> 쿠키명 : <%=cookie.getName() %> <br>
		 	쿠키값 : <%=cookie.getValue() %> </p>
	<% } %>
	<a href="../cookie.jsp">처음으로</a>
</body>
</html>