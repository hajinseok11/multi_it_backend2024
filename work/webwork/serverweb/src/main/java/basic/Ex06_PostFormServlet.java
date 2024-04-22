package basic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex06_PostFormServlet
 */
@WebServlet(name = "post", urlPatterns = {"/post.do"})
public class Ex06_PostFormServlet extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 한글셋팅과 출력스트림 구하기
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 클라이언트가 입력한 요청정보를 추출
		String id = request.getParameter("userId");
		String name = request.getParameter("userName");
		String pass = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String [] items = request.getParameterValues("item");
		
		// 응답메시지를 생성
		out.print("<h1>customer</h1>");
		out.println("<hr/>");
		out.print("<h3>아이디:" + id+ "</h3>");
		out.print("<h3>성명:" + name+ "</h3>");
		out.print("<h3>패스워드:" + pass+ "</h3>");
		out.print("<h3>성별:" + gender+ "</h3>");
		out.print("<h3>직업:" + job+ "</h3>");
		out.print("<h3>좋아하는 항목:");
		for(String item:items) {
			out.println(item+ " ");
		}
		
		System.out.println("아이디: "+id);
		System.out.println("성명: "+name);
		System.out.println("패스워드: "+pass);
		System.out.println("성별: "+gender);
		System.out.println("직업: "+job);
		System.out.println("좋아하는 항목:");
		for(String item:items) {
			System.out.println((item+" "));
		}
		
		out.print("</h3>");
		
	}
}
