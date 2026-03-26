package com.siugi.marketplace;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.siugi.marketplace.repository.CartItemRepository;
import com.siugi.marketplace.repository.CartRepository;
import com.siugi.marketplace.repository.JpaCartItemRepository;
import com.siugi.marketplace.repository.JpaCartRepository;
import com.siugi.marketplace.repository.JpaProductRepository;
import com.siugi.marketplace.repository.JpaUserRepository;
import com.siugi.marketplace.repository.ProductRepository;
import com.siugi.marketplace.repository.UserRepository;
import com.siugi.marketplace.service.CartItemService;
import com.siugi.marketplace.service.CartService;
import com.siugi.marketplace.service.FileUploadService;
import com.siugi.marketplace.service.ProductService;
import com.siugi.marketplace.service.UserService;

import jakarta.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final EntityManager em;
    private final FileUploadService fileUploadService;

    public SpringConfig(EntityManager em, FileUploadService fileUploadService) {
        this.em = em;
        this.fileUploadService = fileUploadService;
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new JpaUserRepository(em);
    }

    @Bean
    public ProductService productService() {
        return new ProductService(productRepository(), fileUploadService);
    }

    @Bean
    public ProductRepository productRepository() {
        return new JpaProductRepository(em);
    }

    @Bean
    public CartService cartService() {
        return new CartService(cartRepository());
    }

    @Bean
    public CartRepository cartRepository() {
        return new JpaCartRepository(em);   
    }

    @Bean
    public CartItemService cartItemService() {
        return new CartItemService(cartItemRepository(), cartRepository(), userRepository());
    }

    @Bean
    public CartItemRepository cartItemRepository() {
        return new JpaCartItemRepository(em);
    }
}