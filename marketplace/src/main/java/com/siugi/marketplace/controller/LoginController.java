package com.siugi.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.siugi.marketplace.service.UserService;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/buyers")
    public String buyerHome() {
        return "buyers";
    }

    @PostMapping("/login")
    public String checklogin(LoginForm loginForm) {
        if (userService.checkUser(loginForm).equals("empty")) {
            return "redirect:/login?error"; // 로그인 실패 시 error 페이지로 이동
        }

        return "redirect:/buyers"; // return "buyers"가 안되는 이유를 좀 더 자세히 공부해보자.
    }
}
