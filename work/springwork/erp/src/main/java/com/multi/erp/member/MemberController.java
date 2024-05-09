package com.multi.erp.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController {
	private MemberService service;
	@Autowired
	public MemberController(MemberService service) {
		super();
		this.service = service;
	}
	@GetMapping("/list")
	public ModelAndView list() {	
		ModelAndView mav = new ModelAndView("member/list");
		System.out.println("컨트롤러");
		List<MemberDTO> memberlist = service.getMemberList();
		System.out.println(memberlist);
		mav.addObject("memberlist",memberlist);
		return mav;
	}
	
}
