package member;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "member", urlPatterns = { "/member/insert" })
public class MemberInsertServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 1. 요청정보추출 
		System.out.println("서블릿 요청성공!");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String info = request.getParameter("info");
		// 2. 비지니스 메소드 호출
		MemberDTO member = new MemberDTO(id,pass,name,addr,info);
		MemberDAOImpl dao = new MemberDAOImpl();
		int result = dao.insert(member);
		System.out.println(result);
		//3. 응답메시지 생성
		if(result >=1) {
			System.out.println("<h3>"+result+"명의 회원가입이 성공!!</h3>");
		}else {
			System.out.println("<h3>회원등록실패</h3>");
		}
	}
	

}
