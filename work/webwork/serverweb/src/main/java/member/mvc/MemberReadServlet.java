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


@WebServlet(name = "readmvc", urlPatterns = { "/member/mvc/read" })
public class MemberReadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//1. 요청정보
		String id = request.getParameter("id");
		//2. 비지니스메소드 호출
		MemberDAO dao = new MemberDAOImpl();
		List<MemberDTO> user = dao.findById(id);

		// 3. 데이터공유
		request.setAttribute("user", user);
		//4. 요청재지정
		RequestDispatcher rd = request.getRequestDispatcher("/member_mvc/member_read.jsp");
		rd.forward(request, response);

	}

}
