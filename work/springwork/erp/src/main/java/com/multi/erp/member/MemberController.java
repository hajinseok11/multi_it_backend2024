package com.multi.erp.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.multi.erp.board.FileUploadService;
import com.multi.erp.dept.DeptDTO;
import com.multi.erp.dept.DeptService;
//@SessionAttributes("user") user라는 것은 세션에 저장하는 어트리뷰트의 이름
//스프링 MVC 프레임워크 내부에서 컨트롤러에서 user라는 이름으로 공유된 Model객체에 저장된 어트리뷰트를 찾아서 
//"user"라는 이름의 어트리뷰트가 있으면 이를 세션에도 저장을 해준다.
@Controller
@RequestMapping("/member")
@SessionAttributes("user")
public class MemberController {
	private MemberService service;
	private DeptService deptservice;
	private FileUploadService fileuploadservice;
	
	@Autowired
	public MemberController(MemberService service, DeptService deptservice, FileUploadService fileuploadservice) {
		super();
		this.service = service;
		this.deptservice = deptservice;
		this.fileuploadservice = fileuploadservice;
	}
	
	@GetMapping("/list")
	public ModelAndView list() {	
		ModelAndView mav = new ModelAndView("member/list");
		// 서비스메서드를 호출
		System.out.println("컨트롤러");
		List<MemberDTO> memberlist = service.getMemberList();
		System.out.println(memberlist);
		// 데이터공유
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
		if(session != null) {
			// 사용하던 세션을 메모리에서 제거
			session.invalidate();
		}
		return "redirect:/index.do";
	}
	// 스프링에서 제공되는 기능을 이용해서 로그인 처리하기
	@PostMapping("/spring/login")
	public String springlogin(MemberDTO loginUserInfo,Model model) {
		System.out.println("스프링이 제공하는 @SessionAttributes를 이용해서 로그인");
		MemberDTO user = service.login(loginUserInfo);
		System.out.println("=================로그인 성공사용자 정보"+user);
		String view = "";
		if (user!=null) {
			model.addAttribute("user",user);
			view = user.getMenupath(); // menu-tiles.xml에 등록한 이름의 뷰를 찾아서 뷰를 생성
		}else {
			// 로그인 실패
			view = "redirect:/emp/login.do";
		}
		return view; 
	}
	// 스프링에서 제공되는 기능을 이용해서 로그아웃
	// 내부에서 세션의 상태를 확인할 수 있도록 - 스프링 MVC내부에서 세션을 관리하기 위한 객체 SessionStatus
	@GetMapping("/spring/logout")
	public String springlogout(SessionStatus status) {
		System.out.println("스프링이 제공하는 @SessionAttributes를 이용해서 로그아웃");
		status.setComplete(); // 세션에 있는 객체(로그인한 정보)를 제거
		return "redirect:/index.do";
	}
	// @SessionAttribute를 사용해서 세션에 저장된 데이터를 관리하는 경우
	// @ModelAttribute("user")는 모델데이터를 메소드의 매개변수에 매핑할 때 사용
	// => 모델이나 세션에 저장되어 있는 어트리뷰트를 메소드의 매개변수에 바인딩
	// user라는 이름으로 세션에 저장되어 있는 객체가 메소드의 매개변수에 매핑
	@GetMapping("/mypage")
	public String mypage(@ModelAttribute("user") MemberDTO user) {
		// 로그인한 사용자의 mypage로 이동 - mypage는 menupath를 꺼내서 forward
		// 로그인한 사용자의 정보는 세션에 저장
		// MemberDTO user = (MemberDTO) session.getAttribute("user");
		System.out.println("로그인사용자=>" + user);
		return user.getMenupath();
	}
	
	@GetMapping("/insert")
	public String insertpage(Model model) {
		// 기존의 DeptServiceImpl의 select메소드를 호출해서 결과를 공유
		List<DeptDTO> deptlist = deptservice.select();
		model.addAttribute("deptlist",deptlist);
		return "member/insert";
	}
	@PostMapping("/insert")
	public String insert(MemberDTO user,HttpSession session) throws IllegalStateException, IOException {
		System.out.println(user);
		// 1. 파일업로드
		MultipartFile file = user.getUserImage();
		String path = WebUtils.getRealPath(session.getServletContext(), "/WEB-INF/upload");
		String storeFilename = fileuploadservice.uploadFile(file, path);
		user.setProfile_photo(storeFilename);
		user.setGender("0");
		System.out.println(user);
		//2. 디비에 저장하기
		service.insert(user);

		return "member/insert";
	}
	
}




