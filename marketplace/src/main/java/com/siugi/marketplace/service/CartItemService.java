package com.siugi.marketplace.service;

import java.util.Optional;

import com.siugi.marketplace.domain.CartItems;
import com.siugi.marketplace.domain.Carts;
import com.siugi.marketplace.repository.CartItemRepository;
import com.siugi.marketplace.repository.CartRepository;
import com.siugi.marketplace.repository.UserRepository;

import jakarta.transaction.Transactional;

@Transactional
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;


    public CartItemService(CartItemRepository cartItemRepository, CartRepository cartRepository, UserRepository userRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    public Long getCartIdByUsername(String username) {
        Long userId = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found")).getId();
        Carts cart = cartRepository.findByUser_id(userId).orElseThrow(() -> new IllegalArgumentException("Cart not found"));
        return cart.getId();
    }


    public CartItems addCartItem(String username, Long productId) {
        Long cartId = getCartIdByUsername(username);
        Optional<CartItems> cartItem = cartItemRepository.findByCart_idAndProduct_id(cartId, productId);
        if (cartItem.isPresent()) {
            cartItem.get().incrementCount();
            return cartItem.get();
        }
        else {
            CartItems newCartItem = new CartItems();
            newCartItem.setCart_id(cartId);
            newCartItem.setProduct_id(productId);
            newCartItem.setCount(1);
            cartItemRepository.save(newCartItem);
            return newCartItem;
        }
    }

    public int getCartItemCount(String username) {
        Long cartId = getCartIdByUsername(username);
        return cartItemRepository.findByCart_id(cartId).size();
    }
}
