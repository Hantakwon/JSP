<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>College/Student::modify</title>
</head>
<body>
	<h3>College/Student 수정</h3>

	<a href="/ch10">처음으로</a>
	<a href="/ch10/college/student/list.do">목록으로</a>

	<form action="/ch10/college/student/modify.do" method="POST">
		<table border="1">
			<tr>
				<td>학번</td>
				<td><input type="text" name="stdno" value="${student.stdno}" readonly/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${student.name}" /></td>
			</tr>
			<tr>
				<td>생일</td>
				<td><input type="date" name="birth" value="${student.birth}" /></td>
			</tr>
			<tr>
				<td>전공</td>
				<td>
					<select name="major">
					    <option value="국문학과" ${student.major eq '국문학과' ? 'selected' : ''}>국문학과</option>
					    <option value="영문학과" ${student.major eq '영문학과' ? 'selected' : ''}>영문학과</option>
					    <option value="일문학과" ${student.major eq '일문학과' ? 'selected' : ''}>일문학과</option>
					    <option value="중문학과" ${student.major eq '중문학과' ? 'selected' : ''}>중문학과</option>
					    <option value="컴공학과" ${student.major eq '컴공학과' ? 'selected' : ''}>컴공학과</option>
					    <option value="통계학과" ${student.major eq '통계학과' ? 'selected' : ''}>통계학과</option>
					    <option value="수학학과" ${student.major eq '수학학과' ? 'selected' : ''}>수학학과</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>입학일</td>
				<td><input type="date" name="enr_date" value="${student.enr_date}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="수정하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>