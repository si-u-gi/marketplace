package com.siugi.marketplace.repository;

import com.siugi.marketplace.domain.Cart;

import jakarta.persistence.EntityManager;

public class JpaCartRepository implements CartRepository {
    private final EntityManager em;

    public JpaCartRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Cart save(Cart cart) {
        em.persist(cart);
        return cart;
    }

    @Override
    public Cart findByUserId(Long user_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUserId'");
    }
        
}
