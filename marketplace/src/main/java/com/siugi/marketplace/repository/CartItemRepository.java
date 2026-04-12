package com.siugi.marketplace.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.siugi.marketplace.domain.CartItems;
import com.siugi.marketplace.domain.Carts;
import com.siugi.marketplace.domain.Products;

@Repository
public interface CartItemRepository {
    CartItems save(CartItems cartItem);
    void delete(CartItems cartItem);
    Optional<CartItems> findById(Long id);
    List<CartItems> findByCart(Carts cart);
    Optional<CartItems> findByCartAndProduct(Carts cart, Products product);
}
