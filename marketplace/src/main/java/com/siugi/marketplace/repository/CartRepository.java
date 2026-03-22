package com.siugi.marketplace.repository;

import com.siugi.marketplace.domain.Cart;

public interface CartRepository {
    Cart save(Cart cart);
    Cart findByUserId(Long user_id);
}
