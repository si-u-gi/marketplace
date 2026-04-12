package com.siugi.marketplace.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItems {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Products product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Carts cart;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void incrementCount() {
        this.count++;
    }
    public void decrementCount() {
        this.count--;
    }

    public Products getProduct() {
        return product;
    }
    public void setProduct(Products product) {
        this.product = product;
    }

    public Carts getCart() {
        return cart;
    }
    public void setCart(Carts cart) {
        this.cart = cart;
    }
}
