package com.siugi.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping("/") // 처음 접속하는 경로
    public String home() {
        return "login"; // 로 들어오면 login.html 뷰를 반환
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/seller")
    public String sellerHome() {
        return "seller";
    }

    @GetMapping("/admin")
    public String adminHome() {
        return "admin";
    }

    @PostMapping("/join")
    public String joinForm() {
        return "create_account";
    }
}