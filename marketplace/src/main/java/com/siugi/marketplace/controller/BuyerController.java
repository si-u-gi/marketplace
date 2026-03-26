package com.siugi.marketplace.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.siugi.marketplace.domain.Products;
import com.siugi.marketplace.repository.ProductRepository;
import com.siugi.marketplace.service.CartItemService;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuyerController {
    private final ProductRepository productRepository;
    private final CartItemService cartItemService;

    public BuyerController(ProductRepository productRepository, CartItemService cartItemService) {
        this.productRepository = productRepository;
        this.cartItemService = cartItemService;
    }

    @GetMapping("/buyer/home")
    public String home(HttpSession session, Model model) {
        List<Products> products = productRepository.findAll();
        model.addAttribute("products", products);

        String user = (String) session.getAttribute("loginUser");
        if (user != null) {
            model.addAttribute("cartItemCount", cartItemService.getCartItemCount(user));
        }
        else {
            model.addAttribute("cartItemCount", 0);
        }
        return "buyer/home";
    }
}