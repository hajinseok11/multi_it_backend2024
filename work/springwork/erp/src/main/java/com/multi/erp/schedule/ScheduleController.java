package com.multi.erp.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.erp.board.BoardDTO;

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
	public String showListPage() {
		return "schedule/list";
		
	}
	@GetMapping("/insert")
	public String insertSchedule() {
		return "schedule/insert"; 
	}
	@PostMapping("/insert")
	public String insert(ScheduleDTO schedule) {
		System.out.println(schedule);
		return "schedule/list";
	}
	
	
	
}
