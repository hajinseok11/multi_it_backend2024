<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>paramtest</title>
</head>
<body>
	<h1>1. 파라미터 테스트</h1>
	<h3><a href = "/springmvc/paramtest?data=first&info=1000">파라미터추출하기</a></h3>
	<form method = "post" action = "/springmvc/paramtest">
		데이터:<input type = "text" name = "data"/>
		아이디:<input type = "text" name = "id"/>
		패스워드:<input type = "text" name = "pass"/>
		<input type = "submit" value = "스프링에서 파라미터 추출하기 - post">
	</form>
	<form method = "get" action = "/springmvc/paramtest">
		데이터:<input type = "text" name = "data"/>
		아이디:<input type = "text" name = "id"/>
		패스워드:<input type = "text" name = "pass"/>
		<input type = "submit" value = "스프링에서 파라미터 추출하기 - get">
	</form>
	<hr/>
	<h1>2. 파라미터 테스트(command객체 활용하기)</h1>
	<form method = "post" action = "/springmvc/cmdtest">
		데이터:<input type = "text" name = "data"/>
		아이디:<input type = "text" name = "id"/>
		패스워드:<input type = "text" name = "pass"/>
	<input type = "submit" value = "command객체로 테스트하기">
</body>
</html>