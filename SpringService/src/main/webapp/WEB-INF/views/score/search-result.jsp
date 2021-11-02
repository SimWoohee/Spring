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
	<h2>${score.stuName} 성적 정보 조회</h2>
	<p>
	#이름:${score.stuName}<br> 
	#국어:${score.kor}<br>
	#수학:${score.math}<br>
	#영어:${score.eng}<br>
	#총점:${score.total}<br>
	#평균:${score.average}<br>
	<!-- a 태그는 get요청으로 들어가서 ScoreController에서 get요청메소드를 호출한다 -->
	<a href='<c:url value="/score/register"></c:url>'>다른 점수 등록하기</a>
	<a href='<c:url value="/score/list"></c:url>'>점수 전체 조회</a>
	<a href='<c:url value="/score/search"></c:url>'>점수 개별 조회</a>
	</p>

</body>
</html>