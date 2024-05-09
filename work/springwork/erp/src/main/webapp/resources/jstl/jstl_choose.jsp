<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_choose</title>
</head>
<body>
	<h2>자바의 if~else(if ~ else if ~ else if ~ else )를 표현 </h2>
	<h2>컨트롤러가 공유해준 데이터의 체크(컨트롤러에서 공유한 user객체가 널인지 체크하기)
		c:when이 if, c:otherwise가 else에 해당
		if - c:when
		else if - c:when
		else if - c:when
		else - c:otherwise
	</h2>
		<!--EL이 주로 하는 일은 컨트롤러가 공유해준 공유객체(컨트롤러에서 공유하는 공유명이 EL에서 객체명)를 엑세스  -->
	<c:choose>
		<c:when test="${user == null} ">
			<h3>user객체는 널이다.</h3>
		</c:when>
		<c:otherwise>
			<h3>user객체는 널이 아니다.</h3>
		</c:otherwise>
	</c:choose>
	
	<h2>c:choose가 if~else표현 가능</h2>
	<h3>age변수가 20세 미만이면 청소년 입니다. 20세 미만이면 성인입니다.</h3>
	<c:choose>
		<c:when test = "${param.age<20}">
			<h3>${param.name}님은 청소년입니다</h3>
		</c:when>
		<c:otherwise>
			<h3>${param.name}님은 성인입니다.</h3>
		</c:otherwise>
	</c:choose>
	
	<!--grade가 A이면 <h3>A등급</h3>, B, B등급, C는 C등급 나머지는 기타등급으로 출력하기   -->
	<c:choose>
		<c:when test = "${param.grade=='A' || param.grade=='a'}">
			<h3>A등급</h3>
		</c:when>
		<c:when test = "${param.grade=='B' || param.grade=='b'}">
			<h3>B등급</h3>
		</c:when>
		<c:when test = "${param.grade=='C' || param.grade=='c'}">
			<h3>c등급</h3>
		</c:when>
		<c:otherwise>
			<h3>기타등급</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>




