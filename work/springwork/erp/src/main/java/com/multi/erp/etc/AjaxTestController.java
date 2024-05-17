package com.multi.erp.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.multi.erp.board.BoardDTO;
import com.multi.erp.board.BoardService;

@Controller
@RequestMapping("/ajax")
public class AjaxTestController {
	private BoardService service;
	@Autowired
	public AjaxTestController(BoardService service) {
		super();
		this.service = service;
	}
	// 동기통신으로 요청을 처리하는 방식
	@GetMapping("/noajax")
	public String noajax(String id, Model model) {
		String msg="";
		if(id.equals("jang")) {
			msg = "사용가능 아이디";
		}else {
			msg = "사용불가능 아이디";
		}
		model.addAttribute("msg",msg);
		return "etcview/ajax"; // forward방식
	}
	// Ajax요청으로 실행되는 컨트롤러로 String결과를 컨트롤러로 전송
	// response는 기존의 방식처럼 view를 response하지 않고 response할 데이터의 형식을 리턴타입에 정의
	// ajax로 요청하는 경우는 데이터만 요청하는 것이므로 @ResponseBody를 추가하거나 모두 @RestController로 작업을 해야한다.
	// Ajax로 컨트롤러를 요청하면 서버에서 결과를 String이나 JSON으로 만들어서 넘긴다.
	// produces속성에 response되는 데이터의 형식(MIME type)과 인코딩을 명시
	@GetMapping(value = "/ajaxtest01",produces = "application/text;charset=utf-8")
	@ResponseBody
	public String ajaxtest(String id,String pass) {
		System.out.println(id+"============="+pass);
		String msg="";
		if(id.equals("jang")) {
			msg = "사용불가능 아이디";
		}else {
			msg = "사용가능 아이디";
		}
		return msg;
	}
	@GetMapping(value = "/gugu",produces = "application/text;charset=utf-8")
	@ResponseBody
	public String getGugu(String dan) {
		String gugudan = "";
		for (int i = 1; i<= 9; i++) {
			gugudan = gugudan +(dan+ " x " + i + " = " + (Integer.parseInt(dan)*i)+"\n");
        }
		return gugudan;
	}
	
	@GetMapping("/exam")
	public String showexamPage() {
		return "etcview/ajaxexam";
	}
	
	@GetMapping("/getBoardJson")
	@ResponseBody
	public BoardDTO getBoardJson(String boardno) {
		// @ResponseBody로 정의한 후
		// 리턴타입을 DTO로 명시하면 jackson-bind라이브러리가 자동으로 DTO 객체를 JSON으로 변환해서 리턴
		return service.getBoardInfo(boardno);
	}
	@GetMapping("/exam02")
	@ResponseBody
	public List<BoardDTO> getBoardJsonArr() {
		return service.boardList();
	}
}




