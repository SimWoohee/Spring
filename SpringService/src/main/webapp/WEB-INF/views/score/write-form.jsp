<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action='<c:url value="/score/register"></c:url>' method="POST">
		<p>
			<h2>시험점수 등록</h2>
			# 이름 : <input type="text" name="stuName"/><br>
			# 국어 : <input type="text" name="kor"/><br>
			# 영어 : <input type="text" name="eng"/><br>
			# 수학 : <input type="text" name="math"/><br>
			<input type="submit" value="확인">
		</p>
	</form>

</body>
</html>