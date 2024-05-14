package com.multi.erp.board;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

@Controller
@RequestMapping("/board")
public class BoardController {
	private BoardService service;
	private FileUploadService fileuploadService;
	
	@Autowired	
	public BoardController(BoardService service, FileUploadService fileuploadService) {
		super();
		this.service = service;
		this.fileuploadService = fileuploadService;
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
	// 게시글 등록을 위해 사용자가 입력한 내용과 첨부한 파일이 업로드 되도록 처리
	@PostMapping("/write")
	public String insert(BoardDTO board,HttpSession session) 
									throws IllegalStateException, IOException {
		System.out.println("파일업로드:"+board);
		// 1. MultipartFile정보를 추출
		List<MultipartFile> file = board.getFiles();
		// 2. 업로드될 서버의 실제 위치를 추출
		//	  - 실제 서버에서 인식하는 업로드될 파일이 저장될 폴더의 경로를 추출하기
		//    - context 내부에 있으므로 ServletContext 객체를 이용
		//    - ServletContext객체는 프로젝트(context)에 대한 정보를 담고 있는 객체이고 이 안에 실제 경로를
		// 	  - 구할 수 있는 기능이 있음
		// 	  - ServletContext는 세션객체를 통해 생성
		String path = WebUtils.getRealPath(session.getServletContext(), "/WEB-INF/upload");
		System.out.println("^^^^^^^^^^^^"+path);
		
		// 3. 업로드로직을 처리하는 서비스의 메소드를 호출
		List<BoardFileDTO> boardfiledtolist = fileuploadService.uploadFiles(file,path);
		System.out.println(boardfiledtolist);
		service.insert(board,boardfiledtolist);
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
		List<BoardFileDTO> boardfiledtolist = service.getFileList(board_no);
		System.out.println("**************************" + board);
		String view = "";
		if(action.equals("READ")) {
			view = "board/read";
		}else {
			view = "board/update";
		}
		// 스프링이 만들어준 모델객체에 공유할 데이터를 공유한다.
		model.addAttribute("board",board);
		model.addAttribute("boardfiledtolist",boardfiledtolist);
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
		service.delete(board_no);
		return "redirect:/board/list?category=all";
	}	
}
