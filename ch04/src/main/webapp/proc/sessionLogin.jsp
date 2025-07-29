<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String auto = request.getParameter("auto");
	
	// 데이터베이스 사용자 조회 후 사용자 객체 생성
	UserVO userVO = null;
	
	if(id.equals("abc123") && pw.equals("1234")){
		userVO = new UserVO();
		userVO.setId(id);
		userVO.setPw(pw);
		userVO.setName("김유신");
		userVO.setAge(23);	
	}	
	
	if (userVO != null) {
		
		// 자동 로그인 처리
		if(auto != null) {
			Cookie autoCookie = new Cookie("auto", id);
			autoCookie.setMaxAge(60 * 60 * 24 * 7);
			autoCookie.setPath("/");
			
			response.addCookie(autoCookie);		
		}
		
		// 사용자가 회원이면 세션에 사용자 객체 저장
		session.setAttribute("user", userVO);
		
		// 리다이렉트(페이지 이동)
		response.sendRedirect("./sessionSuccess.jsp");
	} else {
		// 사용자가 회원이 아니면
		response.sendRedirect("../session.jsp");
	}
%>