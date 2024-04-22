<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type ="text/css">
			table{
				width:600px;
				height:500px;
			}
		</style>
	</head>
	<body>
	<table border="1">
		<% for (int i = 1; i <= 9; i++) { %>
		<tr>
           <% for (int j = 1; j <= 9; j++) { %>
              <% if (j==i){%>
              		<td><%out.print("<img alt ='' src = '/serverweb/images/bts2.jpg' width = '80'/>");%></td>
              <%} else{%>
            	  <td><%out.print(i + " * " + j + " = " + (i * j)); %></td>
             <% }%>
             <%}%>
        </tr>
       <%}%>
       </table>
	</body>
</html>