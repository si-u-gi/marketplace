package com.siugi.marketplace.service;

import java.util.List;
import java.util.Optional;

import com.siugi.marketplace.domain.CartItems;
import com.siugi.marketplace.domain.Carts;
import com.siugi.marketplace.domain.Products;
import com.siugi.marketplace.repository.CartItemRepository;
import com.siugi.marketplace.repository.CartRepository;
import com.siugi.marketplace.repository.ProductRepository;
import com.siugi.marketplace.repository.UserRepository;

import jakarta.transaction.Transactional;

@Transactional
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    public CartItemService(CartItemRepository cartItemRepository, CartRepository cartRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public Carts getCartByUsername(String username) {
        Long userId = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found")).getId();
        Carts cart = cartRepository.findByUser_id(userId).orElseThrow(() -> new IllegalArgumentException("Cart not found"));
        return cart;
    }

    public CartItems addCartItem(String username, Long productId) {
        Carts cart = getCartByUsername(username);
        Products product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        Optional<CartItems> cartItem = cartItemRepository.findByCartAndProduct(cart, product);
        if (cartItem.isPresent()) {
            cartItem.get().incrementCount();
            return cartItem.get();
        }
        else {
            CartItems newCartItem = new CartItems();
            newCartItem.setCart(cart);
            newCartItem.setProduct(product);
            newCartItem.setCount(1);
            cartItemRepository.save(newCartItem);
            return newCartItem;
        }
    }

    public int getCartItemCount(String username) {
        Carts cart = getCartByUsername(username);
        return cartItemRepository.findByCart(cart).size();
    }

    public List<CartItems> getCartItemListByCart(Carts cart) {
        return cartItemRepository.findByCart(cart);
    }

    public void deleteCartItem(Long id) {
        CartItems cartItem = cartItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cart item not found"));
        cartItemRepository.delete(cartItem);
    }

    public void incrementCartItemCount(Long id) {
        CartItems cartItem = cartItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cart item not found"));
        cartItem.incrementCount();
    }

    public void decrementCartItemCount(Long id) {
        CartItems cartItem = cartItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cart item not found"));
        if (cartItem.getCount() > 1) {
            cartItem.decrementCount();
        }
        else {
            cartItemRepository.delete(cartItem);
        }
    }
}
