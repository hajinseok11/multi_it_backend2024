package basic;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
//쿠키가져오기 - 쿠키에서 필요한 정보를 꺼내서 클라이언트가 사용할 수 있도록 공유
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="getCookie",urlPatterns ={"/getCookie"})
public class GetCookieServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//1. request메시지에 쿠키 정보가 포함되어 요청되므로 request객체에서 쿠키정보를 추출
		Cookie[] cookies = request.getCookies();
		
		// 2. Cookie[]에서 원하는 쿠키를 찾아 쿠키의 value를 저장
		String bookTitle = "";
		String bookPage = "";
		for(Cookie cookie:cookies) {
			if (cookie.getName().equals("bookTitle")){
				bookTitle = cookie.getValue();
			}else if (cookie.getName().equals("bookPage")) {
				bookPage = cookie.getValue();
			}
			System.out.println(cookie.getName()+":"+cookie.getValue());
			
		}
		// 3. 꺼낸 쿠키를 공유
		request.setAttribute("bookTitle", bookTitle);
		request.setAttribute("bookPage", bookPage);
		
		// 4. 요청 재지정
		RequestDispatcher rd = request.getRequestDispatcher("/stateless/cookieResult.jsp");
		rd.forward(request,response);
		
	}
}
