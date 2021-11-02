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
<%--
	/selectOne 요청을 통해 해당 학번을 가진 학생의 성적 정보를 조회하여
	search-result.jsp에서 해당 정보를 출력하세요
 --%>
	<form action='<c:url value="/score/selectOne"></c:url>' method="post">
	<p>
		# 조회할 학번 : <input type="text" name="stuNum" size="5">
		<input type="submit" value="조회">
	</p>
	</form>
<p style="color: red;">${msg}</p>
</body>
</html>