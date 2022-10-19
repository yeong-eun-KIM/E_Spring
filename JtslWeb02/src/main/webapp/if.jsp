<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JSTL-if</title>
</head>
<body>
	<!-- 변수 선언 -->
	<c:set var="number" value="100" />
	<c:set var="string" value="JSTL"/>
	
	<h3>JSTL-if 태그로 짝수/홀수 판단</h3>
	<c:if test="${number mod 2 eq 0 }" var="result">
		${number }은 짝수입니다.<br>
	</c:if>
	result : ${result }<br>
	
	<h3>문자열 비교, else 구문</h3>
	<c:if test="${string eq 'Java' }" var="result2">
		'Java'가 아닙니다. <br>
	</c:if>
	<c:if test="${not result2  }">
			'Java'가 아닙니다1. <br>
	</c:if>
	
	<h3>조건식 주의사항</h3>
	<c:if test="100" var="result3">
		EL이 아닌 정수를 지정하면 결과는 false<br>
	</c:if>
	
	<c:if test="tRuE" var="result4">
		대소문자 구분 없이 "tRuE"인 경우 true<br>
	</c:if>
	result4: ${result4 }
	
	<c:if test=" ${true}" var="result5">
		EL 양쪽에 빈 공백이 있는 경우 false <br>
	</c:if>
	result5: ${result5 }
	
</body>
</html>