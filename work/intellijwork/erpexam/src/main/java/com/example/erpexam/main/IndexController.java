package com.example.erpexam.main;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
    @GetMapping("/index.do")
    public String index() {
        return index;
    }
}
