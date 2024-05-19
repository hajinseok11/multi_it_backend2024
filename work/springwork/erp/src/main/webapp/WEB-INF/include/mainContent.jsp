<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../static/common/css/main.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

</style>
<title>Insert title here</title>
<script type = "text/javascript">
	$(document).ready(function(){
		// id가 boardCategory인 엘리먼트의 하위 엘리먼트인 li태그에 동일한 코드를 적용
		$("#boardCategory>li").each(function(){
			// li가 클릭될 대 마다 alert를 실행 - 현재 선택한 객체를 지칭
			$(this).click(function(){
				// 선택한 li의 텍스트를 가져오기
				let category = $(this).text();
				// alert("선택"+category);
				// 기존 선택되었던 li의 class속성을 모두 지우기
				$("#boardCategory>li").removeAttr("class");
				// 클릭한 li탭이 선택되도록 class 속성을 active로 정의
				$(this).attr("class","active");
				// 선택한 탭에 대한 데이터를 조회해서 출력하기
				// => 해당카테고리 데이터를 DB에서 조회해서 myboardlist에 <tr>로 출력되도록 Ajax로 처리하기
				/* <tr>
				<td class="boardContent" style="">
				<a href="/erp/board/read?board_no=${board.board_no}&action=READ">${board.title}</a>
				</td>
				<td class="boardDate" style="">${board.write_date }</td>
				</tr> */
			})
		})
	}); // end ready
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-7">
				<div id="myCarousel" class="carousel slide" data-ride="carousel"
					style="width: 600px; height: 300px">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="/erp/images/multi1.jpg" alt="Image"
								style="width: 600px; height: 300px">

						</div>

						<div class="item">
							<img src="/erp/images/multi2.jpg" alt="Image"
								style="width: 800px; height: 300px">

						</div>
						<div class="item">
							<img src="/erp/images/multi3.jpg" alt="Image"
								style="width: 600px; height: 300px">

						</div>

						
					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px; width: 450px">
					<div class="panel-footer">사내소식</div>
					<div class="panel-body">
						<ul class="nav nav-tabs" id = "boardCategory">
							<li id = "board" class="active"><a href="#">게시판</a></li> <!--class "active" = 선택되어있는 상태  -->
							<li id = "notification"><a href="#">사내소식</a></li>
							<li id = "event"><a href="#">경조사</a></li>
						</ul>
						<div id="boardMain" style="padding-top: 20px; padding-left: 10px">
							<table id = "myboardlist">
								<c:forEach var = "board" items="${boardlist}">
									<tr>
										<td class = "boardContent" style="">
										<a href = "/erp/board/read?board_no=${board.board_no}&action=READ">${board.title}</a>
										</td>
										<td class = "boardDate" style = ""> ${board.write_date}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>	`
			</div>
		</div>
		<hr />
		<div class="row main-row">
			<div class="col-sm-3">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px">
					<div class="panel-footer">News</div>
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px">
					<div class="panel-footer">회사소식</div>
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px">
					<div class="panel-footer">회사소식</div>
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px">
					<div class="panel-footer">회사소식</div>
					<div class="panel-body"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>