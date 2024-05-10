package com.multi.erp.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	// 로그인 - 기존방식
	@PostMapping("/login")
	public String login(MemberDTO loginUserInfo,Model model,HttpServletRequest request) {
		String view = "";
		System.out.println("********"+loginUserInfo);
		MemberDTO user = service.login(loginUserInfo);
		if(user!=null) {
			// 로그인 성공
			view = "redirect:/index.do";
			// 세션에 로그인한 사용자의 데이터를 공유
			HttpSession session = request.getSession(); // 세션만들기 - 로그인 성공하면 무조건 세션을 만든다.
			session.setAttribute("user", user);
		}else {
			// 로그인 실패
			view = "redirect:/emp/login.do";
		}
		return view;
	}
	// 로그아웃 - 기존 방식
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
	}
}
