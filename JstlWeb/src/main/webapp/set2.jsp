<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.co.ezenac.Person"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	 ArrayList<Person> pList = new ArrayList<>();
	 pList.add(new Person("신사인당", 20));
	 pList.add(new Person("이방원", 10));
%>
<%
	Map<String, Person> pMan = new HashMap<>();
	pMan.put("person1", new Person("이성계", 65));
	pMan.put("person2", new Person("최영", 67));
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JSTL - set</title>
</head>
<body>
	<h4>List 컬렉션 이용</h4>

	<c:set var="personList" value="<%= pList %>" scope="request"></c:set>
	<ul>
		<li>이름 : ${personList[0].name }</li>
		<li>나이 : ${personList[0].age }</li>
	</ul>
	
	<h4>Map 컬렉션 이용</h4>
	<c:set var="personMap" value="<%=pMan %>" scope="request"></c:set>
		<ul>
		<li>이름 : ${personMap.person1.name }</li>
		<li>나이 : ${personMap.person1.age }</li>
	</ul>
</body>
</html>