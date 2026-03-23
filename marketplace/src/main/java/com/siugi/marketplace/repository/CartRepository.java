package com.siugi.marketplace.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.siugi.marketplace.domain.Carts;

@Repository
public interface CartRepository {
    Carts save(Carts cart);
    Optional<Carts> findByUser_id(Long user_id);
}
