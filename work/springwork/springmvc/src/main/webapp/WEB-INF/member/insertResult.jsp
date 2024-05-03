<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel = "stylesheet" href = "/springmvc/common/css/mystyle.css">
	<script type = "text/javascript" src = "/springmvc/common/js/myjs.js"></script>
</head>
<body onload = "test()">
	<h1>가입</h1>
	<hr/>
	<img src = "/springmvc/images/bts2.jpg"/>
	<h2>아이디: ${user.id}</h2>
	<h2>패스워드: ${user.pass}</h2>
	<h2>성명: ${user.name}</h2>
	<h2>주소: ${user.addr}</h2>
	<h2>기타: ${user.info}</h2>
</body>
</html>