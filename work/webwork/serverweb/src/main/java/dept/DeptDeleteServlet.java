package dept;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(description = "deptdelete", urlPatterns = { "/dept/delete" })
public class DeptDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//1. 요청정보
		String deptno = request.getParameter("deptno"); // 전송된 파라미터 수신, url에서 보낸 변수명과 일치, 항상 String타입
		//2. 비지니스메소드 호출
		DeptDAO dao = new DeptDAOImpl();
		int result = dao.delete(deptno);
		//3. 응답메시지 생성
		if(result >=1) {
			out.println("<h3>"+result+"부서삭제 성공!!</h3>");
		}else {
			out.println("<h3>부서삭제실패</h3>");
		}	
	}

}
