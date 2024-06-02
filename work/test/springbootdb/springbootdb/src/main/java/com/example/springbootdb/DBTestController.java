package com.example.springbootdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DBTestController {
	@Autowired
	DBTestDAO dao;
	@GetMapping("/jdbc/test")
	public String templateTest() {
		System.out.println("부서의 갯수:"+dao.jdbcTemplateTest());
		return "redirect:/";
	}
	@GetMapping("/mybatis/test")
	public String mybatisTest() {
		System.out.println(dao.select());
		return "redirect:/";
	}
}

