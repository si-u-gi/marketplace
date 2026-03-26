package com.siugi.marketplace.repository;

import java.util.List;
import java.util.Optional;

import com.siugi.marketplace.domain.CartItems;
import jakarta.persistence.EntityManager;

public class JpaCartItemRepository implements CartItemRepository {
    private final EntityManager em;

    public JpaCartItemRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public CartItems save(CartItems cartItem) {
        em.persist(cartItem);
        return cartItem;
    }

    @Override
    public List<CartItems> findByCart_id(Long cart_id) {
        String jpql = "select ci from CartItems ci where ci.cart_id = :cart_id";
        return em.createQuery(jpql, CartItems.class)
            .setParameter("cart_id", cart_id)
            .getResultList();
    }

    @Override
    public Optional<CartItems> findByCart_idAndProduct_id(Long cart_id, Long product_id) {
        String jpql = "select ci from CartItems ci where ci.cart_id = :cart_id and ci.product_id = :product_id";
        return em.createQuery(jpql, CartItems.class)
            .setParameter("cart_id", cart_id)
            .setParameter("product_id", product_id)
            .getResultList()
            .stream()
            .findFirst();
    }
}
