package com.siugi.marketplace.repository;

import java.util.List;
import java.util.Optional;

import com.siugi.marketplace.controller.LoginForm;
import com.siugi.marketplace.domain.Users;

public interface UserRepository {
    Users save(Users user);
    Optional<Users> findByUser(Long id);
    Optional<Users> findByUsernameAndPassword(LoginForm loginForm);
    List<Users> findAll();
}
