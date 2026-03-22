package com.siugi.marketplace.service;

import com.siugi.marketplace.repository.CartRepository;

public class CartService {
    private final CartRepository cartRepository;
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void cartSave(Long userId) {
        // Cart 객체 생성
    }
}
