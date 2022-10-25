<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JSTL - out</title>
</head>
<body>
	<c:set var="iTag">
		i태그는 <I>기울임</I>을 표현합니다.
	</c:set>
	
	<H4>기본사용</H4>
	<c:out value="${iTag }"></c:out>
	
	<h4>excapeXml 응용</h4>
	<c:out value="${iTag }" escapeXml="false"></c:out>
</body>
</html>