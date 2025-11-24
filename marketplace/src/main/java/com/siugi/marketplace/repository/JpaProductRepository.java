package com.siugi.marketplace.repository;

import java.util.List;
import java.util.Optional;

import com.siugi.marketplace.domain.Products;

import jakarta.persistence.EntityManager;

public class JpaProductRepository implements ProductRepository {

    private final EntityManager em;
    
    public JpaProductRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Products save(Products product) {
        em.persist(product);
        return product;
    }

    @Override
    public Optional<Products> findByProductName(String productName) {
        String jpql = "select p from Products p where p.productName = :productName";
        List<Products> result = em.createQuery(jpql, Products.class)
            .setParameter("productName", productName)
            .getResultList();
        
        if (result.isEmpty()) {
            return Optional.empty();
        }
        else {
            return Optional.of(result.get(0));
        }
    }

    @Override
    public List<Products> findAll() {
        String jpql = "select p from Products p";
        return em.createQuery(jpql, Products.class).getResultList();
    }

    @Override
    public List<Products> findBySellerName(String seller_name) {
        String jqpl = "select p from Products p where p.seller_name = :seller_name";
        return em.createQuery(jqpl, Products.class)
            .setParameter("seller_name", seller_name)
            .getResultList();
    }
}
