package member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController {
	MemberService service;
	@Autowired
	public MemberController(MemberService service) {
		super();
		this.service = service;
	}
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String  showpage() {
		return "member/register";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(MemberDTO user) {
		System.out.println(user);
		int result = service.insert(user);
		ModelAndView mav = new ModelAndView("member/insertResult");
		mav.addObject("user",user);
		return mav;
	}
}
