<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet</title>
	<%--
		날짜 : 2025/07/31
		이름 : 한탁원
		내용 : 서블릿(Servlet) 실습하기
	 --%>
</head>
<body>
	<h3>서블릿(Servlet) 실습</h3>
	
	<a href="/ch08/hello.do">Hello Servlet</a>
	<a href="/ch08/welcome.do">Welcome Servlet</a>
	<a href="/ch08/greeting.do">Greeting Servlet</a>
	
	<form action="/ch08/hello.do" method="POST">
		<input type="text" name="id" /><br>
		<input type="text" name="pw" /><br>
		<input type="submit" value="전송하기" /><br>
	</form>
</body>
</html>