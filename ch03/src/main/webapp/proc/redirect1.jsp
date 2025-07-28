<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirect1</title>
</head>
<body>
	<h3>redirect1 페이지</h3>
	<%
		// 1_request.jsp 페이지로 리다이렉트(다시 요청)
		response.sendRedirect("../1_request.jsp");
	%>
	
	<a href="../2_reponse.jsp">뒤로가기</a>
</body>
</html>