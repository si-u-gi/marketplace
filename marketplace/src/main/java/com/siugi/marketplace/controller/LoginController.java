package com.siugi.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.siugi.marketplace.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String checklogin(LoginForm loginForm, HttpSession session) {
        String role = userService.checkUser(loginForm);
        if (role.equals("empty")) {
            return "redirect:/login?error"; // 로그인 실패 시 로그인 페이지로 리다이렉트하여 error 파라미터 전달
        }

        session.setAttribute("loginUser", loginForm.getUsername());
        session.setAttribute("userRole", role);

        if (role.equals("seller")) {
            return "redirect:/seller/dashboard"; // 판매자 대시보드로 리다이렉트
        }
        else if (role.equals("buyer")) {
            return "redirect:/buyer/home"; // 구매자 홈으로 리다이렉트
        }
        else {
            return "redirect:/admin/admin"; // 알 수 없는 역할일 경우 로그인 페이지로 리다이렉트하여 error 파라미터 전달
        }
    }
}
