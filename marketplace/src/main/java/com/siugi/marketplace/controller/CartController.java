package com.siugi.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.siugi.marketplace.domain.Carts;
import com.siugi.marketplace.service.CartService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long productId,
                       HttpSession session) {

        String user = (String) session.getAttribute("loginUser");



        return "redirect:/cart";
    }
}
