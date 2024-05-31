package com.example.erp.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.erp.board.BoardService;
import com.example.erp.dto.BoardDTO;

@Controller
public class IndexController {
	private BoardService service;
	@Autowired
	public IndexController(BoardService service) {
		super();
		this.service = service;
	}
	@GetMapping("/index.do")
	public String index(Model model) {
		// 첫페이지가 로딩될 때 필요한 데이터를 가져오기 위해서 서비스랑 연결(게시판 데이터)
		List<BoardDTO> boardlist = service.findByCategory("게시판");
		model.addAttribute("boardlist",boardlist);
		return "layout/indexlayout";
	}
	@GetMapping("/emp/login.do")
	public String login() {
		return "emp/login";
	}

	@GetMapping("/menu/board.do")
	public String boardPage() {
		return "menu/board";
	}
	
}
