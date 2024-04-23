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
		<h2>꺼낸 데이터: <%= mydata %></h2>
		<hr/>
		<h3><a href = "/serverweb/stateless/session_second.jsp">데이터가 공유될까요?</a></h3>
	</body>
</html>