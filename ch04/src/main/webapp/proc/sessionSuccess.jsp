<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="vo.UserVO"%>
<%
UserVO user = (UserVO) session.getAttribute("user");
	// 로그인 하지 않고 접근하면 로그인 화면 이동
	if (user == null) {
		response.sendRedirect("../session.jsp");
	
		return; // 처리 종료
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionSuccess</title>
</head>
<body>
	<h3>세션 로그인 성공</h3>
	<p>
		<%=user.getName()%>님 반갑습니다.<br> <a href="./sessionLogout.jsp">로그아웃</a>
	</p>
</body>
</html>