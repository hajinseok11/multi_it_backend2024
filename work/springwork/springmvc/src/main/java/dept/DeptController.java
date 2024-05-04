package dept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dept")
public class DeptController {
	DeptService service;
	@Autowired
	public DeptController(DeptService service) {
		super();
		this.service = service;
	}
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String showpage() {
		return "dept/dept";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(DeptDTO dept) {
		System.out.println(dept);
		int result = service.insert(dept);
		ModelAndView mav = new ModelAndView("dept/insertResult");
		mav.addObject("dept",dept);
		return mav;
	}
}