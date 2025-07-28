<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서버 에러</title>
</head>
<body>

	<h3>일시적인 서버 장애가 발생했습니다. 고객센터로 문의하시기 바랍니다.</h3>
	<p>
		에러 종류 : <%=exception.getClass().getName()%> <br>
		에러 종류 : <%=exception.getMessage()%> <br>
	</p>
	<button onclick="window.history.back();">이전 페이지로 가기</button>
</body>
</html>