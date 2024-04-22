package dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "deptlist", urlPatterns = { "/dept/list" })
public class DeptListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 1. 요청정보추출 
		// 2. 비지니스 메소드 호출
		DeptDAO dao = new DeptDAOImpl();
		List<DeptDTO> userlist =dao.select();
	
		out.print("<h1>사원목록보기</h1>");
		out.print("<hr/>");
		out.print("<table border ='1' width ='500'>");
		out.print("<tr bgcolor = 'pink'>");
		out.print("<th>부서번호</th><th>부서명</th><th>전화번호</th><th>주소</th><th>삭제</th>");
		out.print("</tr>");
		for(DeptDTO user: userlist) {
			out.print("<tr>");
			out.print("<td>"+user.getDeptno()+"</td>");
			out.print("<td>"+user.getDeptname()+"</td>");
			out.print("<td>"+user.getTel()+"</td>");
			out.print("<td>"+user.getAddr()+"</td>");
			out.print("<td><a href ='/serverweb/dept/delete?deptno="+user.getDeptno()+"'>삭제</a></td>");
			out.print("</tr>");
		}
		out.print("</table>");
	}
}