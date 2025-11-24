package com.siugi.marketplace;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.siugi.marketplace.repository.JpaProductRepository;
import com.siugi.marketplace.repository.JpaUserRepository;
import com.siugi.marketplace.repository.ProductRepository;
import com.siugi.marketplace.repository.UserRepository;
import com.siugi.marketplace.service.ProductService;
import com.siugi.marketplace.service.UserService;

import jakarta.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
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
        return new ProductService(productRepository());
    }

    @Bean
    public ProductRepository productRepository() {
        return new JpaProductRepository(em);
    }
}