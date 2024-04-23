package member.mvc;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(name="logout", urlPatterns= {"/member/mvc/logout"})
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용중인 세션을 받아오기
		HttpSession ses = request.getSession(false);
		if(ses!=null) {
			// 세션을 제거하기
			ses.invalidate();
		}
		response.sendRedirect("/serverweb/index.jsp");
	}

}
