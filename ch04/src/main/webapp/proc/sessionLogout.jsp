<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 현재 세션 user값 제거 및 session 무효화
	session.removeAttribute("user");
	session.invalidate();
	
	// 자동로그인 쿠키 해제(삭제)
	Cookie autoCookie = new Cookie("auto", null);
	autoCookie.setMaxAge(0); // 쿠키 수명을 0으로해서 쿠키 삭제
	autoCookie.setPath("/");
	
	response.addCookie(autoCookie);
	
	response.sendRedirect("../session.jsp");
%>