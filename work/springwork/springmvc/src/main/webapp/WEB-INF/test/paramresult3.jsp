<%@page import="test.ParamDTO"%>
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
	System.out.println("===============================");
	ParamDTO dto = (ParamDTO)request.getAttribute("dto"); %>
	<h2>DTO에서 데이터 꺼내기</h2>
	<hr/>
	<h3>데이터:<%= dto.getId() %></h3>
	<h3>EL에서 dto.data는 getter메소드에서 get을 없애고 첫 글자를 소문자로 바꾼 이름을 정의 즉, getter메소드가 호출</h3>
	<h3>아이디:${dto.data}</h3>
	<h3>패스워드:${dto.pass}</h3>
</body>
</html>