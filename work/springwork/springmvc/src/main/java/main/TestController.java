package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 서블릿의 역할을 수행
// @Controller로 정의하지 않으면 스프링 MVC에서 실행되는 컨트롤러로 인식하지 않는다. 무조건 @Controller로 정의

@Controller
public class TestController {
	@RequestMapping("/test.html")
	public String test() {
		System.out.println("컨트롤러 요청");
		return "test/test";
	}
}
