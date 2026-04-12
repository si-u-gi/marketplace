package com.siugi.marketplace.repository;

import java.util.List;
import java.util.Optional;

import com.siugi.marketplace.domain.Carts;

import jakarta.persistence.EntityManager;

public class JpaCartRepository implements CartRepository {
    private final EntityManager em;

    public JpaCartRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Carts save(Carts cart) {
        em.persist(cart);
        return cart;
    }

    @Override
    public Optional<Carts> findById(Long id) {
        Carts cart = em.find(Carts.class, id);
        return Optional.ofNullable(cart);
    }

    @Override
    public Optional<Carts> findByUser_id(Long user_id) {
        String jpql = "select c from Carts c Where c.user_id = :user_id";
        List<Carts> result = em.createQuery(jpql, Carts.class)
            .setParameter("user_id", user_id)
            .getResultList();
        
        if (result.isEmpty()) {
            return Optional.empty();
        }
        else {
            return Optional.of(result.get(0));
        }
    }
        
}
