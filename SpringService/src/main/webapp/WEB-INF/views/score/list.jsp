<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생들의 전체 성적 조회</h2>
<!-- sList에는 scoreVO list가 들어있다
list에서 한개 꺼내면 scoreVO객체가 되고
scoreVO 객체는 var="score"이다 
그래서 score.stuName, score.kor 형식으로 사용가능하다! -->
	<c:forEach var="score" items="${sList}" varStatus="stuNum">
	<p>
		# 학번: ${stuNum.index+1}, 이름:${score.stuName}, 국어:${score.kor}, 수학:${score.math}, 영어:${score.eng},
		총점:${score.total}, 평균:${score.average}
		&nbsp;
		<a href='<c:url value="/score/delete?stuNum=${stuNum.index+1}"></c:url>'>삭제</a>
		<a href='<c:url value="/score/register"></c:url>'>다른 점수 등록하기</a>
	</p>
	</c:forEach>
	<script type="text/javascript">
		const msg = "${message}";
		
		if(msg === "delSuccess"){
			alert('정상 삭제 되었습니다');
		}
	</script>

</body>
</html>