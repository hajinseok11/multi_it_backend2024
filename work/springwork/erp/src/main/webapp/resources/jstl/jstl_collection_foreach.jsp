<%@page import="test.JSTLDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>컬렉션에 저장된 데이터에 접근하기(가장 많이 사용)</h1>
	<h2>jsp가 하는 일은 컨트롤러에서 공유한 attribute를 꺼내서 출력</h2>
	<h2>1. 배열</h2>
	<%
		String[] arr = {"java","servlet","jsp","spring"};
	%>
	<c:forEach var = "data" items= "<%=arr %>">
		<h3> ${data}</h3>
	</c:forEach>
	
	<h2>2. ArrayList(컨트롤러에서 공유한 데이터)</h2>
	<%
		ArrayList<String> list = new ArrayList<String>();
		list.add("하둡");
		list.add("스파크");
		list.add("몽고디비");
		list.add("Pig");
		request.setAttribute("list", list); // 컨트롤러에서 공유된 데이터가 있다는 가정
	%>
	<c:forEach var = "data" items = "${list}" varStatus = "status">
		<h3>${data},current=>${status.current},index=>${status.index}</h3>
	</c:forEach>
	
	<h2>3. ArrayList에 DTO가 저장된 경우</h2>
	<%
		ArrayList<JSTLDTO> userlist = new ArrayList<JSTLDTO>();
		userlist.add(new JSTLDTO("jang","1234"));
		userlist.add(new JSTLDTO("bts","1234"));
		userlist.add(new JSTLDTO("kang","1234"));
		userlist.add(new JSTLDTO("kim","1234"));
		// 컨트롤러에서 공유된 데이터라 가정
		request.setAttribute("userlist", userlist);
	
	%>
	<hr/><hr/><hr/><hr/>
	<h3>jsp코드</h3>
	<%
	ArrayList<JSTLDTO> jspuserlist =(ArrayList<JSTLDTO>)request.getAttribute("userlist");
	for(JSTLDTO dto:jspuserlist){ %>
		<h3><%= dto.getId() %>:<%=dto.getPass() %></h3>
	<%} %>
	
	<hr/><hr/><hr/><hr/>
	<h3>JSTL코드</h3>
	<c:forEach var = "user" items= "${userlist}">
		<h3> ${user.id}:${user.pass}</h3>
	</c:forEach>	
</body>
</html>