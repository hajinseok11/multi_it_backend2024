<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#testbtn").on("click",function(){
			let querydata = {"boardno":$("#boardno").val()};	
			$.ajax({
				url:"/erp/ajax/getBoardJson",
				type:"get",
				data:querydata,
				dataType:"json",
				success:function(result){
					// alert(result+":"+result.board_no)
					$("#no").text(result.board_no);
					$("#title").text(result.title);
					$("#writer").text(result.id);
					$("#content").text(result.content);
				},
				error:error_run
			}) // end ajax
		})
		
		$("#testjsonbtn").on("click",function(){
			let querydata = {"boardno":$("#boardno").val()};	
			$.ajax({
				url:"/erp/ajax/exam02",
				type:"get",
				data:querydata,
				dataType:"json",
				success:function(result){
					alert(result.length"========"+result[0].title)
				},
				error:error_run
			})
		})	
		error:function(obj,msg,statusMsg){
			alert("요청실패=>"+obj+","+msg+","+statusMsg);
			// JSONArray객체는 자바스크립트에서 배열처럼 처리
			let myarr = [10,20,30]
			for(const value of myarr){
				alert(value);
			}
		}
		
		
	}
	</script>
	<form>
		글번호:<input type="text" name="boardno" id="boardno"/>
		<input type="button" value="ajax_jsonobj" id="testbtn"/>
		<input type="button" value="ajax_jsonarr" id="testjsonbtn"/>
	</form>
	<div id="result">
		<h4>글번호:<span id="no"></span></h4>
		<h4>제목:<span id="title"></span></h4>
		<h4>작성자:<span id="writer"></span></h4>
		<h4>내용:<span id="content"></span></h4>
	</div>
	<div id="printarr">
	
		</div>
	</body>
</html>