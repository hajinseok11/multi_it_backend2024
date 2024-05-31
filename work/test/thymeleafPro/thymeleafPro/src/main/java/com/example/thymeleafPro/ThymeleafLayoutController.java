package com.example.thymeleafPro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout")
public class ThymeleafLayoutController {
	@GetMapping("/fragmenttest")
	public String fragment_test() {
		return "fragment/main";
	}
	@GetMapping("/mypage")
	public String mypage() {
		// return "layout/mypageLayout";	1차 작업 - 타임리프프레그먼트를 이용해서 작업
		return "member/mypage";
	}
	@GetMapping("/prdlist")
	public String prdlist() {
		return "product/prdlist";
	}
	@GetMapping("/prdread")
	public String prdread(String prdno, String prdname, Model model) {
		System.out.println(prdname+":"+prdno);
		model.addAttribute("prdname",prdname);
		model.addAttribute("prdno",prdno);
		return "product/productRead";
	}
}
