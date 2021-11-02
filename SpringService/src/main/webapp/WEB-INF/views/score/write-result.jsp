<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write-result.jsp</title>
</head>
<body>
<h2>점수 등록 성공!</h2>
<p>
			
	<a href='<c:url value="/score/register"></c:url>'>다른 점수 등록하기</a>
	<a href='<c:url value="/score/list"></c:url>'>점수 전체 조회</a>
	<a href='<c:url value="/score/search"></c:url>'>점수 개별 조회</a>
</p>
	

</body>
</html>

