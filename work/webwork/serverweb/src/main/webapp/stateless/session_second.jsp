<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
		String mydata = (String)session.getAttribute("mydata");
		
		%>
		<h2>꺼낸 데이터(second문서 - 서블릿에서 공유한 데이터) <%= mydata %></h2>
		<hr/>
		
	</body>
</html>