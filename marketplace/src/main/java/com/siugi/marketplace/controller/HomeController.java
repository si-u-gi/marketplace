package com.siugi.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") // 처음 접속하는 경로
    public String home() {
        return "login"; // 로 들어오면 login.html 뷰를 반환
    }
}