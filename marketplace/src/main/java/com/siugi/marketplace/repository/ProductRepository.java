package com.siugi.marketplace.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.siugi.marketplace.domain.Products;

@Repository
public interface ProductRepository {
    Products save(Products product);
    Optional<Products> findByProductName(String productName);
    List<Products> findBySellerName(String sellerName);
    List<Products> findAll();
}
