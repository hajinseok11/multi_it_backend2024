package test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/*
 * 1. 클라이언트의 요청 정보 추출
 * 2. get방식과 post방식에 따라 각각 요청하기
 * 3. 한글처리
 * 	  => 필터에 등록
 * 4. ModelAndView에 데이터공유
 * 5. 뷰 정보를 ModelAndView에 셋팅
 * 6. Command객체 활용하기
 */
@Controller
public class ParamTestController {
	@RequestMapping("/showview")
	public String showpage() {
		// 뷰를 실행하기 위한 컨트롤러
		return "test/paramtest";
	}
	// 뷰에 대한 정보를 지정하지 않으면 요청 path와 동일한 뷰가 response된다.
	// get방식으로 /springmvc/paramtest로 요청하면 실행되는 메소드
	// method 속성에 RequestMethod.GET으로 지정하면 get방식으로 요청
	// 4.3이후 @GetMapping, @PostMapping을 각각 지원
	@RequestMapping(value = "/paramtest", method = RequestMethod.GET)
	public ModelAndView paramtest(HttpServletRequest request,
						@RequestParam("data") String data2, String info) { // @RequestParam("data") -> 이렇게 사용하지 않으면 적용이 
																		// 않는 버전이 있음 기능은 똑같음
		String param = request.getParameter("data");
		System.out.println("data => "+data2);
		System.out.println("info => "+info);
		System.out.println("param => "+param);
		// 뷰정보와 뷰에서 출력할 데이터를 공유
		ModelAndView mav = new ModelAndView("test/paramresult");
		// 데이터 공유하기 - request.setAttribute("name",공유객체
		mav.addObject("msg","스프링이 공유해 준 데이터");
		mav.addObject("data",data2);
		return mav;
	}
	// 스프링에서 파라미터 추출하기 - post버튼을 눌렀을 때 요청정보를 추출해서 sysout으로 출력하기
	// 메소드명 posttest
	// post방식으로 /springmvc/paramtest로 요청하면 실행되는 메소드
	// 파라미터로 전달받은 값을 공유하고 출력할 수 있도록 메소드를 수정(paramresult2.jsp로 작업 - EL로 출력하기)
	@RequestMapping(value = "/paramtest", method = RequestMethod.POST)
	public ModelAndView posttest(String data, String id, String pass) {
		System.out.println("data => "+data);
		System.out.println("id => "+id);
		System.out.println("pass => "+pass);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("test/paramresult2");
		mav.addObject("data",data);
		mav.addObject("id",id);
		mav.addObject("pass",pass);
		return mav;
	}
	@RequestMapping(value = "/cmdtest",method = RequestMethod.POST)
	public ModelAndView cmdtest(ParamDTO dto) {
		System.out.println(dto);
		ModelAndView mav = new ModelAndView("test/paramresult3");
		mav.addObject("dto",dto);// db에서 조회한 데이터
		return mav;
	}
}
