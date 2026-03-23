package com.siugi.marketplace.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.siugi.marketplace.domain.LoginForm;
import com.siugi.marketplace.domain.Users;

@Repository
public interface UserRepository {
    Users save(Users user);
    Optional<Users> findByUser(Long id);
    Optional<Users> findByUsername(String username);
    Optional<Users> findByUsernameAndPassword(LoginForm loginForm);
    List<Users> findAll();
}
