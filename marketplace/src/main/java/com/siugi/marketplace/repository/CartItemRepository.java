package com.siugi.marketplace.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.siugi.marketplace.domain.CartItems;

@Repository
public interface CartItemRepository {
    CartItems save(CartItems cartItem);
    List<CartItems> findByCart_id(Long cart_id);
    Optional<CartItems> findByCart_idAndProduct_id(Long cart_id, Long product_id);
}
