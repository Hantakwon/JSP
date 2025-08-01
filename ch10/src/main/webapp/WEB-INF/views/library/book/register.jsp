<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library/Book::register</title>
</head>
<body>
	<h3>Library/Book 등록</h3>
	
	<a href="/ch10">처음으로</a>
	<a href="/ch10/library/book/list.do">목록으로</a>
	
	<form action="/ch10/library/book/register.do" method="POST">
			<table border="1">
			<tr>
				<td>책 번호</td>
				<td><input type="number" name="book_id" placeholder="책 번호 입력" /></td>
			</tr>
			<tr>
				<td>책 제목</td>
				<td><input type="text" name="title" placeholder="책 제목 입력" /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="number" name="author" placeholder="작성자 입력" /></td>
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type="text" name="publisher" placeholder="출판사 입력" /></td>
			</tr>
			<tr>
				<td>대출가능여부</td>
				<td><input type="text" name="available" placeholder="대출가능 입력" /></td>
			</tr>
			<tr>
				<td>반납일</td>
				<td><input type="date" name="reg_date" placeholder="반납일 입력" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>