package com.multi.erp.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.multi.erp.member.MemberDTO;

@Controller
@RequestMapping("board/")
public class BoardController {
	private BoardService service;
	@Autowired
	public BoardController (BoardService service) {
		super();
		this.service= service;
	}
	@GetMapping("/list")
	public ModelAndView list(String category) {
		System.out.println(category+"============");
		ModelAndView mav = new ModelAndView("board/list");
		System.out.println("컨트롤러");
		// 서비스메소드를 호출
		List<BoardDTO> boardlist = service.findByCategory(category);
		System.out.println(boardlist);
		// 데이터 공유
		mav.addObject("boardlist",boardlist);
		mav.addObject("category",category);
	
		return mav;
	}
	@GetMapping("/write")
	public String writePage() {
		return "board/writepage"; // view이름
	}
	@PostMapping("/write")
	public String insert(BoardDTO board) {
		System.out.println(board);
		service.insert(board);
		return "redirect:/board/list?category=all";
	}
	// 동적 쿼리를 테스트
	// 사용자가 select에서 어떤 option을 선택하냐에 따라 다른 쿼리가 실행되어야 한다.
	@PostMapping("/search")
	public ModelAndView search(String tag,String search) {
		ModelAndView mav = new ModelAndView("board/list");
		System.out.println("컨트롤러");
		// 서비스메소드를 호출
		List<BoardDTO> boardlist = service.search(tag, search);
		System.out.println(boardlist);
		// 데이터 공유
		mav.addObject("boardlist",boardlist);
		return mav;
	}
	// Model 타입의 변수를 매개변수에 정의하면 스프링MVC 내부에서 데이터를 담을 수 있는 모델 객체를 만들어서 넘겨준다.
	@GetMapping("/read")
	public String read(String board_no,String action, Model model) {
		BoardDTO board = service.getBoardInfo(board_no);
		System.out.println("**************************" + board);
		String view = "";
		if(action.equals("READ")) {
			view = "board/read";
		}else {
			view = "board/read";
		}
		// 스프링이 만들어준 모델객체에 공유할 데이터를 공유한다.
		model.addAttribute("board",board);
		// 모델객체에 데이터를 공유했으므로 뷰 정보만 리턴
		// => 리턴되면서 DispatcherServlet에 ModelAndView객체로 만들어져서 리턴된다.
		return view;
	}	
	@PostMapping("/update")
	public String update(BoardDTO board) {
		System.out.println(board);
		service.update(board);
		return "redirect:/board/list?category=all";
	}
	@GetMapping("/delete")
	public String delete(String board_no) {
		service.getBoardInfo(board_no);
		return "redirect:/board/list?category=all";
	}	
}
