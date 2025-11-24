package com.siugi.marketplace.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.siugi.marketplace.domain.Products;
import com.siugi.marketplace.repository.ProductRepository;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuyerController {
    private final ProductRepository productRepository;

    public BuyerController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/buyer/home")
    public String list(Model model) {
        List<Products> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "buyer/home";
    }
}