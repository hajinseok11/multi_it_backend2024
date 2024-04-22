<%@page import="member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<jsp:include page = "../top.jsp"/>
	<div class = "container-fluid">
		<div class = "row">
			<div class ="col-lg-2 sidenav">
				<jsp:include page = "/layout/emp_menu.jsp"/>
		<h2>요청 재지정으로 실행되는 jsp - 서블릿이 공유해준 데이터를 꺼내서 웹페이지 출력하기</h2>
		<%
			// 공유데이터 꺼내기
			MemberDTO data = (MemberDTO)request.getAttribute("mydata");
		%>
		<h2><%= data.getId() %> 님 환영합니다.!! </h2>
				</div>
			</div>
		</div>
	</body>
</html>