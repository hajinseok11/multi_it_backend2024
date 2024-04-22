package basic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.MemberDTO;
@WebServlet(name = "include", urlPatterns = { "/include" })
public class IncludeTestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  response.getWriter();
		
		System.out.println("include 연습 - IncludeTestServlet");
		out.println("<h1> 요청 재지정연습 - Include</h1>");
		out.println("<hr/></hr><hr/></hr>");
		
		// 데이터 공유하기
		MemberDTO dto = new MemberDTO("bts1","1234","슈가","대구","래퍼");
		// 공유하고 싶은 scope객체의 메소드를 호출
		request.setAttribute("mydata",dto);
		
		// 요청 재지정
		RequestDispatcher rd = request.getRequestDispatcher("/jspbasic/result.jsp");
		rd.include(request, response);
	}

}
