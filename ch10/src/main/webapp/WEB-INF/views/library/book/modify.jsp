<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library/Book::modify</title>
</head>
<body>
	<h3>Library/Book 수정</h3>

	<a href="/ch10">처음으로</a>
	<a href="/ch10/library/book/list.do">목록으로</a>

	<form action="/ch10/library/book/modify.do" method="POST">
		<table border="1">
			<tr>
				<td>책 번호</td>
				<td><input type="number" name="book_id" value="${book.cs_id}" readonly/></td>
			</tr>
			<tr>
				<td>책 제목</td>
				<td><input type="text" name="title" value="${book.title}" /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="number" name="author" value="${book.author}" /></td>
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type="text" name="publisher" value="${book.publisher}" /></td>
			</tr>
			<tr>
				<td>대출가능여부</td>
				<td><input type="text" name="available" value="${book.available}" /></td>
			</tr>
			<tr>
				<td>반납일</td>
				<td><input type="date" name="reg_date" value="${book.reg_date}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>