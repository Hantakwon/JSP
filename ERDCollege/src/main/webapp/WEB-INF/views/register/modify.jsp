<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 수정</title>
</head>
<body>
	<h3>수강 수정</h3>

	<a href="/ERDCollege/">처음으로</a>
	<a href="/ERDCollege/register/list.do">목록으로</a>

	<form action="/ERDCollege/register/modify.do" method="POST">
		<table border="1">
			<tr>
				<td>학번</td>
				<td><input type="text" name="regStdNo" value="${register.regStdNo}" readonly/></td>
			</tr>
			<tr>
				<td>강의번호</td>
				<td><input type="number" name="regLecNo" value="${register.regLecNo}" readonly/></td>
			</tr>
			<tr>
				<td>중간고사 점수</td>
				<td><input type="number" name="regMidScore" value="${register.regMidScore}" /></td>
			</tr>
			<tr>
				<td>기말고사 점수</td>
				<td><input type="number" name="regFinalScore" value="${register.regFinalScore}" /></td>
			</tr>
			<tr>
				<td>총합 점수</td>
				<td><input type="number" name="regTotalScore" value="${register.regTotalScore}" /></td>
			</tr>
			<tr>
				<td>등급</td>
				<td><input type="text" name="regGrade" value="${register.regGrade}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>