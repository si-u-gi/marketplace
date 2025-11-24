package com.siugi.marketplace.repository;

import java.util.List;
import java.util.Optional;

import com.siugi.marketplace.controller.LoginForm;
import com.siugi.marketplace.domain.Users;

import jakarta.persistence.EntityManager;

public class JpaUserRepository implements UserRepository {

    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Users save(Users user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<Users> findByUsername(String username) {
        String jpql = "select u from Users u where u.username = :username";
        List<Users> result = em.createQuery(jpql, Users.class)
            .setParameter("username", username)
            .getResultList();
        
        if (result.isEmpty()) {
            return Optional.empty();
        }
        else {
            return Optional.of(result.get(0));
        }
    }

    @Override
    public Optional<Users> findByUsernameAndPassword(LoginForm loginForm) {
        String jpql = "select u from Users u where u.username = :username and u.password = :password";
        List<Users> result = em.createQuery(jpql, Users.class)
            .setParameter("username", loginForm.getUsername())
            .setParameter("password", loginForm.getPassword())
            .getResultList();
        
        if (result.isEmpty()) {
            return Optional.empty();
        }
        else {
            return Optional.of(result.get(0));
        }
    }

    @Override
    public Optional<Users> findByUser(Long id) {
        return Optional.ofNullable(em.find(Users.class, id));
    }

    @Override
    public List<Users> findAll() {
        String jpql = "select u from Users u";
        return em.createQuery(jpql, Users.class).getResultList();
    }
}