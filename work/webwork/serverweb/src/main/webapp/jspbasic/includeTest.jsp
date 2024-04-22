<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>jsp에서 include하기</h1>
		<h3>서블릿의 include와 동일하게 동작</h3>
		<% System.out.println("include실행"); %>
		<!-- jsp에서 forward하기 (잘 사용되지 않는다.) -->
		<jsp:forward page="/jspbasic/actiontag_sub.jsp"/>	
		<h1>include 액션태그 테스트</h1>
	</body>
</html>