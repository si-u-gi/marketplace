package com.siugi.marketplace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siugi.marketplace.domain.Products;
import com.siugi.marketplace.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Long enroll(Products product) {
        productRepository.save(product);
        return product.getProduct_id();
    }

    public List<Products> findAllProducts() {
        return productRepository.findAll();
    }

    public List<Products> findProductsBySellerName(String sellerName) {
        return productRepository.findBySellerName(sellerName);
    }
}
