package com.siugi.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.siugi.marketplace.service.CartItemService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
    private final CartItemService cartItemService;

    public CartController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }
    
    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long productId,
                       HttpSession session, Model model) {

        String user = (String) session.getAttribute("loginUser");
        if (user == null) {
            return "redirect:/";
        }
        cartItemService.addCartItem(user, productId);
        return "redirect:/buyer/home";
    }
}
