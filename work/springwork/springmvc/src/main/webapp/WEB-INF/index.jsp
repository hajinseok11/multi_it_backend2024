<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>첫 화면</h1>
	<hr/>
	<h3><a href = "/springmvc/test.html">테스트 컨트롤러 요청</a></h3>
	<h3><a href = "/springmvc/gugu.html">구구요청</a></h3>
	<h3><a href = "/springmvc/showview">파라미터테스트뷰</a></h3>
	<h3><a href = "/springmvc/showpost">post테스트</a></h3>
	<h3><a href = "/springmvc/member/insert">회원가입</a></h3>
	<h3><a href = "/springmvc/dept/insert">부서등록</a></h3>
		
	<form method = "post" action = "/springmvc/test.html">
		<input type = "submit" value = "테스트 컨트롤러 요청">
	</form>
	
	<form method = "get" action = "/springmvc/gugu.html">
		<input type = "submit" value = "구구요청">
	</form>
</body>
</html>