package basic;

import java.io.IOException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
// 세션테스트하기
@WebServlet(name="sessionTest",urlPatterns ={"/sessionTest"})
public class SessionTestServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 1. 요청정보 추출하기
		String id = request.getParameter("id");		
		// 2. 데이터 공유하기 - request는 한 번에 요청에 대해서만 데이터를 공유하므르 사이트에서 서비스하는 기능을 사용하는
		// 					동안 데이터가 유지될 수 있도록 하기 어렵다.
		// 세션을 활용 - HttpSession 객체를 만들어서 데이터를 공유
		// 			  request객체가 제공하는 getSession메소드를 이용
		// getSession() - 무조건 세션객체를 생성
		// getSession(true) - getSession()과 동일
		// getSession(false) - 사용하던 세션이 서버에 만들어져 있으면 해당 세션객체를 리턴하고 없으면 null을 리턴
		HttpSession session = request.getSession();
		session.setAttribute("mydata", id);
		
		// 3. 요청재지정
		RequestDispatcher rd = request.getRequestDispatcher("/stateless/session_first.jsp");
		rd.forward(request,response);
		
	}
}
