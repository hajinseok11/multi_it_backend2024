package fw;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 사이트를 운영하는 동안 모든 요청이 FrontServlet을 통해서 들어올 수 있도록 설정
//@WebServlet(name = "front",urlPatterns = {"*.do","*.html","*.jsp","/"})
public class FrontServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 스프링MVC DispatcherServlet내부에서는 WebApplicationContext가 설정파일(xml.어노테이션,빈)에 등록된 모든 객체를
		// 생성해서 빈으로 등록하는 작업이 처리
		// 요청되는 서블릿을 등록할 때 설정파일에 대한 정보를 같이 등록하면 된다.(보통 이런 작업은 초기화 파라미터를 통해 전달)
		//																	------------
		//																<init-param>으로 등록, 서블랏이 생성될 때 서블릿에 전달
		
		String val = getInitParameter("contextConfigLocation");
		// 예측
		System.out.println("초기화파라미터=> "+ val);
		//1. 요청정보를 분석해서 추출 - 어떤 path로 요청이 들어왔는지 분석하기
		System.out.println("frontController 패턴");
		System.out.println("request.getContextPath()=>"+ request.getContextPath());
		System.out.println("request.getRequestURI()=>" + request.getRequestURI());
		System.out.println("request.getRequestURL()=>" + request.getRequestURL());
		System.out.println("request.getRemoteAddr()=>"+ request.getRemoteAddr());
		
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());
		System.out.println("path=>" + path);
		
		// 2. 추출한 요청 path로 등록된 클래스를 찾아서 가져오는 작업
		RequestMapping mapping = new RequestMapping();
		Action action = mapping.mapping(path);
		String view = action.run(request, response);
		
		// 3. Action을 실행하면서 리턴받은 뷰의 정보를 가지고 어떤 뷰를 실행해야 하는지 뷰명을 리턴
		ViewResolver resolver = new ViewResolver();
		String viewpath = resolver.makeview(view);
		
		// 4. 전달받은 뷰로 forward
		RequestDispatcher rd = request.getRequestDispatcher(viewpath);
		rd.forward(request, response);
	}

}
