package dept;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "deptinsert", urlPatterns = { "/dept/insert" })
public class DeptInsertServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 1. 요청정보추출 
		System.out.println("서블릿 요청성공!");
		String deptno = request.getParameter("deptno");
		String deptname = request.getParameter("deptname");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		// 2. 비지니스 메소드 호출
		DeptDTO dept = new DeptDTO(deptno,deptname,tel,addr);
		DeptDAO dao = new DeptDAOImpl();
		int result = dao.insert(dept);

		//3. 응답메시지 생성
		if(result >=1) {
			out.println("<h3>"+result+"명의 부서등록 성공!!</h3>");
			out.println("부서번호: "+deptno);
			out.println("부서명: "+deptname);
			out.println("전화번호: "+tel);
			out.println("주소: "+addr);
		}else {
			out.println("<h3>부서등록실패</h3>");
		}
	}

}
