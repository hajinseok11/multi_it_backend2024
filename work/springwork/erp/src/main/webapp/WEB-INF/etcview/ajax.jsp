<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
			//alert("test");
			$("#noajaxbtn").on("click",function(){
				// 동기통신 -> location.href에 컨트롤러 연결
				location.href = "/erp/ajax/noajax?id="+$("#id").val();
			});
			$("#ajaxbtn").on("click",function(){
				// 비동기통신 - jQuery의 ajax함수를 이용해서 요청
				// 비동기 방식으로 /erp/ajax/ajaxtest01을 get방식으로 요청하면서 id라는 이름의 파라미터와 입력한 값을 전송
				// 전송이 성공하면 success_run함수를 호출하고 실패하면 error_run함수를 호출
				let querydata = {"id":$("#id").val(),"pass":"1234"}
				//				-----   -------------
				// 				name 	    value
				$.ajax({
					url:"/erp/ajax/ajaxtest01",
					type:"get",
					data:querydata,
					success:success_run,
					error:error_run
				})
			})
		}); // end ready
		// ajax요청이 성공하면 success_run이 자동으로 호출되면서 서버가 실행결과를 success_run의 매개변수로 전달한다.
		function success_run(result){
			alert("요청성공"+result);
			$("#result2").html("<h2>jquery:"+result+"</h2>");
		}
		// ajax요청이 실패하면 success_run이 자동으로 호출
		// 요청실패를 하는 경우에도 error_run을 호출하면서 여러가지 값들을 전송
		// obj-XMLHttpRequest객체
		// msg-응답메시지
		// statusMsg - 에러메시지
		function error_run(obj,msg,statusMsg){
			alert("요청실패=>"+obj+","+msg+","+statusMsg);
		}
		
		
		$("#guguajaxbtn").on("click",function(){
			let querydata = {"dan":$("#dan").val()};
			$.ajax({
				url:"/erp/ajax/gugu",
				type:"get",
				data:querydata,
				success:function(result){
					$("#guguresult").html("<h2>구구단:"+result+"</h2>");
				},// end success
				error:function(obj,msg,statusMsg){
					alert("요청실패=>"+obj+","+msg+","+statusMsg);
				}// end error
			}) // end ajax
		});// end #guguajaxbtn click

		
		
	</script>
</head>
<body>
	<h3>Ajax 테스트하기</h3>
	<form name = "myform">
		<input type="text" name="id" id = "id"/>
		<input type="text" name="name" id = "name"/>
		<input type="button" value="no ajax테스트" id = "noajaxbtn"/>
		<input type="button" value="ajax테스트" id = "ajaxbtn"/>
	</form>
	<!-- 동기통신의 실행결과는 EL로 표현 -->
	<div id = "result"> ${msg}</div>
	<!-- 비동기 통신의 실행결과는 success_run함수에서 자바스크립트로 생성 -->
	<div id = "result2"></div>
	<h3>구구단출력하기</h3>
	<form name="myform">
		<input type="text" name="id" id="dan"/>
		<input type="button" id="guguajaxbtn" value="구구단출력">
	</form>
	<div id="guguresult"></div>
</body>
</html>






