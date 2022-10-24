<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");	//날짜 표시 형식
	
	long creationTime = session.getCreationTime();	//최초 요청 시 세션이 생성된 시각을 가져옴
	String creationTimeStr =  dateFormat.format(new Date(creationTime));

	long lastTime = session.getLastAccessedTime();	//마지막 요청시간
	String lastTimeStr = dateFormat.format(new Date(lastTime));
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Session 설정 확인하기</title>
</head>
<body>
	<ul>
		<li>세션 유지 시간 : <%= session.getMaxInactiveInterval() %></li>
		<li>세션 아이디 : <%= session.getId()%></li>
		<li>최초 요청 시각 : <%= creationTimeStr %></li>
		<li>마지막 요청 시각 : <%= lastTimeStr %></li>
	</ul>
</body>
</html>