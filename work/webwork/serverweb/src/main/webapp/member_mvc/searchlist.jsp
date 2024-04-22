<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<% List<MemberDTO> userlist = (List<MemberDTO>)request.getAttribute("search_result");%>
		<table border ='1'>
		<tr bgcolor = 'pink'>
		<th>아이디</th><th>패스워드</th><th>성명</th>
		<th>주소</th><th>가입날짜</th><th>포인트</th>
		<th>정보</th>
		</tr>
		<h1>회원목록보기</h1>
   		<hr/>
   		
        <% for(MemberDTO user:userlist){%>u
         <tr>
            <td><%= user.getId() %></td>
            <td><%= user.getPass() %></td>
            <td><%= user.getName() %></td>
            <td><%= user.getAddr() %></td>
            <td><%= user.getRegDate() %></td>
            <td><%= user.getPoint() %></td>
            <td><%= user.getInfo() %></td>
        </tr> 
        <%}%>
    	</table>
	</body>
</html>