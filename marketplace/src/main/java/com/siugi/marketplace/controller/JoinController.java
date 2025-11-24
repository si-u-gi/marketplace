package com.siugi.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.siugi.marketplace.domain.Users;
import com.siugi.marketplace.service.UserService;

@Controller
public class JoinController {
    private final UserService userService;

    public JoinController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/summit")
    public String createAccount(Users user) {
        try {
            userService.join(user);
        } catch (IllegalStateException e) {
            return "redirect:/join?error"; // 회원가입 실패 시 회원가입 페이지로 리다이렉트하여 error 파라미터 전달
        }

        return "redirect:/login";
    }
}
