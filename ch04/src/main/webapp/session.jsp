<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import='vo.UserVO'%>
<%
	// 자동 로그인 여부 확인
	Cookie[] cookies = request.getCookies();
	
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("auto")) {
			String id = cookie.getValue();
		
			// 사용자 객체 생성
			UserVO userVO = new UserVO();
			userVO.setId(id);
			
			// 세션 처리
			session.setAttribute("user", userVO);
		
			// 로그인 성공 페이지 이동
			response.sendRedirect("./proc/sessionSuccess.jsp");
			return; // 처리종료
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session</title>
<!-- 
		날짜 : 2025/07/28
		이름 : 한탁원
		내용 : JSP 세션 실습하기
	 -->
</head>
<body>
	<h3>session 실습하기</h3>

	<h4>session ID 확인</h4>
	<p>
		session : <% session.getId(); %>
		request session : <%=request.getSession().getId()%>
	</p>

	<form action='./proc/sessionLogin.jsp' method='POST'>
		<input type='text' name='id' placeholder="아이디 입력" /> <br> 
		<input type='password' name='pw' placeholder="비빌번호 입력" /> <br>
		<label><input type="checkbox" name="auto" value="true" />자동로그인</label>
		<input type='submit' value='로그인' />
	</form>

</body>
</html>