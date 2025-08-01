<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library/Book::list</title>
</head>
<body>
	<h3>Library/Book 목록</h3>
	
	<a href="/ch10">처음으로</a>
	<a href="/ch10/library/book/register.do">등록하기</a>
	
	<table border="1">
		<tr>
			<th>책 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>출판사</th>
			<th>대출 가능 여부</th>
			<th>반납 일</th>
			<th>관리</th>
		</tr>
		<c:forEach var="book" items="${books}">
		<tr>
			<td>${book.book_id}</td>
			<td>${book.title}</td>
			<td>${book.author}</td>
			<td>${book.publisher}</td>
			<td>${book.available}</td>
			<td>${book.reg_date}</td>
			<td>
				<a href="/ch10/library/book/modify.do?book_id=${book.book_id}">수정</a>
				<a href="/ch10/library/book/delete.do?book_id=${book.book_id}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>