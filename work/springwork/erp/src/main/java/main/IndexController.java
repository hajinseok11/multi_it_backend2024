package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@GetMapping("/index.do")
	public String index() {
		return "index";
	}
	@GetMapping("/emp/login.do")
	public String login() {
		return "login";
	}
	@GetMapping("/menu/board.do")
	public String boardPage() {
		return "menu/board";
	}
	
}
