package com.siugi.marketplace.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siugi.marketplace.domain.Products;
import com.siugi.marketplace.repository.ProductRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/seller")
public class SellerController {
    private final ProductRepository productRepository;

    public SellerController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
   
    @GetMapping("/dashboard")
    public String dashboard() {
        return "seller/dashboard";
    }

    @GetMapping("/products")
    public String products(Model model, HttpSession session) {
        String username = (String) session.getAttribute("loginUser");
        List<Products> products = productRepository.findBySellerName(username);
        model.addAttribute("userProducts", products);
        return "seller/products";
    }

    @GetMapping("/orders")
    public String orders() {
        return "seller/orders";
    }

    @GetMapping("/messages")
    public String messages() {
        return "seller/messages";
    }

    @GetMapping("/finance")
    public String finance() {
        return "seller/finance";
    }
}

