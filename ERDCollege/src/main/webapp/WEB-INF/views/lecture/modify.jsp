<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 수정</title>
</head>
<body>
	<h3>강의 수정</h3>

	<a href="/ERDCollege/">처음으로</a>
	<a href="/ERDCollege/lecture/list.do">목록으로</a>

	<form action="/ERDCollege/lecture/modify.do" method="POST">
		<table border="1">
			<tr>
				<td>강좌번호</td>
				<td><input type="text" name="lecNo" value="${lecture.lecNo}" readonly/></td>
			</tr>
			<tr>
				<td>강좌명</td>
				<td><input type="text" name="lecName" value="${lecture.lecName}" /></td>
			</tr>
			<tr>
				<td>학점</td>
				<td><input type="number" name="lecCredit" value="${lecture.lecCredit}" /></td>
			</tr>
			<tr>
				<td>시간</td>
				<td><input type="number" name="lecTime" value="${lecture.lecTime}" /></td>
			</tr>
			<tr>
				<td>강의실</td>
				<td><input type="text" name="lecClass" value="${lecture.lecClass}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>