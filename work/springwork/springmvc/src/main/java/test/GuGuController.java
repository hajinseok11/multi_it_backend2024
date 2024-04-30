package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuGuController {
	@RequestMapping("/gugu.html")
	public String showgugu() {
		System.out.println("구구단 실행");
		return "test/gugu";
	}
}
