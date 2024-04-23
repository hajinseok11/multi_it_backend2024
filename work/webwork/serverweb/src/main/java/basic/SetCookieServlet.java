package basic;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="setCookie",urlPatterns ={"/setCookie"})
public class SetCookieServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 1. 쿠키로 클라이언트에 보내고 싶은 데이터를 세팅해서 Cookie객체를 생성
		// => 쿠키에 한글을 쓰는 경우 인코딩을 해야한다.
		// URL에 한글이 포함된 경우 한글이 깨질 수 있으므로 %기호를 포함해서 변환
		// 인코딩은 데이터 형식을 변환하는 과정
		// Cookie cookie1 = new Cookie("bookTitle",URLEncoder.encode("이클립스","UTF-8"));
		Cookie cookie1 = new Cookie("bookTitle","이클립스");
		Cookie cookie2 = new Cookie("bookPage","128");
		
		// 2. 쿠키에 옵션들을 설정
		// 1) 유효시간 - 초단위
		cookie1.setMaxAge(60*60*24);
		cookie2.setMaxAge(60*60*24);
		
		// 3. response에 쿠키를 저장하기
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		// 4. 요청재지정 (jsp로 response하기)
		response.sendRedirect("/serverweb/stateless/cookieResult.jsp");
		
	}
}
