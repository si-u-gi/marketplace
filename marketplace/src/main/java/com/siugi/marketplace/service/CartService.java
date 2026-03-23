package com.siugi.marketplace.service;

import org.springframework.stereotype.Service;

import com.siugi.marketplace.domain.Carts;
import com.siugi.marketplace.repository.CartRepository;

import jakarta.transaction.Transactional;

@Transactional
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Carts join(Long userId) {
        Carts carts = new Carts();
        carts.setUser_id(userId);
        cartRepository.save(carts);
        return carts;
    }
}
