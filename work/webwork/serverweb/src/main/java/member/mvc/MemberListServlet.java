package member.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.MemberDAO;
import member.MemberDAOImpl;
import member.MemberDTO;

@WebServlet(name = "mvclist", urlPatterns = { "/member/mvc/list" })
public class MemberListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 1. 요청정보추출 
		System.out.println("서블릿 요청성공!");
		// 2. 비지니스 메소드 호출
		MemberDAO dao = new MemberDAOImpl();
		List<MemberDTO> userlist = dao.select();
		// 3. 데이터공유하기
		request.setAttribute("select_result", userlist);
		
		// 4. 요청 재지정 - list.jsp
		RequestDispatcher rd = request.getRequestDispatcher("/member_mvc/list.jsp");
		rd.forward(request, response);
		
	}
}

