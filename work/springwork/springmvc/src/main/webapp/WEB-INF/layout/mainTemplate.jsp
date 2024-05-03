<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- tiles의 설정파일에 등록된 각 영역이 실제 어느 위치에 연결을 할 것인지 지정하는 작업을 tiles에서 제공하는 태그  -->
<!-- 외부 라이브러리를 등록해서 태그를 사용할 수 있도록 정의 -->
<%@ taglib prefix = "tiles" uri = "http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- top영역 -->
	<!--tiles:insertAttribute엘리먼트를 이용해서 설정파일에 등록한 영역의 이름만 정의(name속성에)  -->
	<tiles:insertAttribute name = "top"></tiles:insertAttribute>


	<div class="container-fluid">
		<!-- 실제 작업이 추가되면 메뉴나 컨텐츠가 교체 -->
		<div class="row">
			<div class="col-lg-2 sidenav">
				<!-- 메뉴 -->
				<tiles:insertAttribute name = "menu"></tiles:insertAttribute>
			</div>	
			<div class="col-lg-10">
				<!-- 컨텐츠 -->
				<tiles:insertAttribute name = "content"></tiles:insertAttribute>
			</div>
		</div>
	</div>
</body>
</html>