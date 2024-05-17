package com.multi.erp.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.multi.erp.board.BoardDTO;
import com.multi.erp.board.BoardService;

@Controller
public class EtcViewController {
	// json 테스트페이지
	@GetMapping("/json/showpage")
	public String showJsonPage() {
		return "etcview/json";
	}
	// Ajax테스트 페이지
	@GetMapping("/ajax/showpage")
	public String showAjaxPage() {
		return "etcview/ajax";
	}
}
