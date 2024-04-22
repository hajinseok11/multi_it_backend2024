<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	<% ArrayList<MemberDTO> userlist = (ArrayList<MemberDTO>)request.getAttribute("select_result");%>
	<jsp:include page = "../top.jsp"/>
	<div class = "container-fluid">
		<div class = "row">
			<div class ="col-lg-2 sidenav">
				<jsp:include page = "/layout/emp_menu.jsp"/>
			</div>
			<div class ="col-lg-10">
				<jsp:include page = "/member_mvc/search.jsp"/>
				<table border ='1'>
		<h1>회원목록보기</h1>
		<hr/>
		<jsp:include page = "/member_mvc/search.jsp"/>
		<tr bgcolor = 'pink'>
		<th>아이디</th><th>패스워드</th><th>성명</th>
		<th>주소</th><th>가입날짜</th><th>포인트</th>
		<th>정보</th>
		</tr>
		<h1>회원목록보기</h1>
   		<hr/>
   		
        <% for(MemberDTO user:userlist){%>
            <tr><td><a href ="/serverweb/member/mvc/read?id=<%= user.getId() %>"><%= user.getId() %></a></td>
            <td><%= user.getPass() %></td>
            <td><%= user.getName() %></td>
            <td><%= user.getAddr() %></td>
            <td><%= user.getRegDate() %></td>
            <td><%= user.getPoint() %></td>
            <td><%= user.getInfo() %></td>
            <td><a href ="/serverweb/member/mvc/delete?id=?<%= user.getId() %>">삭제</a></td>
        </tr> 
        <%}%>
    	</table>
			</div>
		</div>
		
	</div>
		
	</body>
</html>