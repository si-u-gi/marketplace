package com.siugi.marketplace.repository;

import java.util.List;
import java.util.Optional;

import com.siugi.marketplace.domain.CartItems;
import com.siugi.marketplace.domain.Carts;
import com.siugi.marketplace.domain.Products;

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
    public void delete(CartItems cartItem) {
        em.remove(cartItem);
    }

    @Override
    public Optional<CartItems> findById(Long id) {
        CartItems cartItem = em.find(CartItems.class, id);
        return Optional.ofNullable(cartItem);
    }

    @Override
    public List<CartItems> findByCart(Carts cart) {
        String jpql = "select ci from CartItems ci where ci.cart = :cart";
        return em.createQuery(jpql, CartItems.class)
                .setParameter("cart", cart)
                .getResultList();
    }

    @Override
    public Optional<CartItems> findByCartAndProduct(Carts cart, Products product) {
        String jpql = "select ci from CartItems ci where ci.cart = :cart and ci.product = :product";
        return em.createQuery(jpql, CartItems.class)
            .setParameter("cart", cart)
            .setParameter("product", product)
            .getResultList()
            .stream()
            .findFirst();
    }
}
