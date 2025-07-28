<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirect3</title>
</head>
<body>
	<h3>redirect3 페이지</h3>
	<%
		// 해당 페이지를 파일로 응답
		response.setHeader("Content-type", "application/octet-stream");
	%>
	
	<a href="../2_reponse.jsp">뒤로가기</a>
</body>
</html>