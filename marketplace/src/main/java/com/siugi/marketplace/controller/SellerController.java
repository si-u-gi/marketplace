package com.siugi.marketplace.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siugi.marketplace.domain.ProductForm;
import com.siugi.marketplace.domain.Products;
import com.siugi.marketplace.repository.ProductRepository;
import com.siugi.marketplace.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/seller")
public class SellerController {
    private final ProductService productService;

    public SellerController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "seller/dashboard";
    }

    @GetMapping("/products")
    public String products(Model model, HttpSession session) {
        String username = (String) session.getAttribute("loginUser");
        List<Products> products = productService.findProductsBySellerName(username);

        if (products == null) {
            products = new ArrayList<>();
        }

        model.addAttribute("products", products);
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

    @GetMapping("/products/create")
    public String createProductForm() {
        return "seller/products_create";
    }

    @PostMapping("/products/create")
    public String createProduct(ProductForm form, HttpSession session) {
        String username = (String) session.getAttribute("loginUser");
        productService.create(form, username);
        return "redirect:/seller/products";
    }
}

