<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			// 서블릿에서 공유한 데이터를 추출
			String bookTitle = (String)request.getAttribute("bookTitle");
			String bookPage = (String)request.getAttribute("bookPage");
			// encoding된 데이터를 변경
			// URLDecoder.decode(bookTitle,"UTF-8");
		%>
		<h2>최근에 보신 책의 제목은 <%=bookTitle %>이고 <%=bookPage%>까지 읽었습니다.</h2>
	</body>
</html>