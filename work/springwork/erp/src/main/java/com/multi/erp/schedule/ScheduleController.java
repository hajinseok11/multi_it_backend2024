package com.multi.erp.schedule;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.erp.board.BoardDTO;
import com.multi.erp.member.MemberDTO;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
	private ScheduleService service;
	@Autowired
	public ScheduleController(ScheduleService service) {
		super();
		this.service = service;
	}
	// 디비에서 스케쥴 조회하는 코드로 변경
	@GetMapping("/list")
	public String scheduleListPage(HttpSession session, Model model) {
		List<ScheduleDTO> scheduleList =null;
		if(session!=null) {
			MemberDTO user = (MemberDTO) session.getAttribute("user");
			System.out.println("loginUser : " + user.getId());
			scheduleList = service.printSchedule(user.getId());
		}
		model.addAttribute("schedulelist",scheduleList);
		return "schedule/list";
		
	}
	
	@GetMapping("/insert")
	public String insertSchedule() {
		return "schedule/insert"; 
	}
	@PostMapping("/insert")
	public String insert(HttpSession session, ScheduleDTO schedule) {
		System.out.println(schedule);
		if (session!=null) {
			MemberDTO user = (MemberDTO)session.getAttribute("user");
			schedule.setScheduleUserId(user.getId());
			service.addSchedule(schedule);	
		}
		return "redirect:/schedule/list";
	}
	
	
	
}
