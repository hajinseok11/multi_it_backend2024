package basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Ex03_LifeCycleTestServlet extends HttpServlet{
	public Ex03_LifeCycleTestServlet() {
		System.out.println("Ex03_LifeCycleTestServlet서블릿생성");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("init()");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service(): "+req.getMethod());
		if(req.getMethod().equals("GET")) {
			doGet(req,resp);
		}else {
			doPost(req,resp);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost()");
	}
	@Override
	public void destroy() {
		System.out.println("destroy()");
	}
}
