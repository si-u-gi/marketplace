package com.siugi.marketplace.service;

import java.util.List;
import java.util.Optional;

import com.siugi.marketplace.controller.LoginForm;
import com.siugi.marketplace.domain.Users;
import com.siugi.marketplace.repository.UserRepository;

import jakarta.transaction.Transactional;

@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long join(Users user) {
        checkUserDuplication(user.getUsername());

        userRepository.save(user);
        return user.getId();
    }

    private void checkUserDuplication(String username) {
        userRepository.findByUsername(username).ifPresent(u -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public String checkUser(LoginForm loginForm) {
        Optional<Users> user = userRepository.findByUsernameAndPassword(loginForm);
        if (user.isEmpty()) {
            return "empty";
        }
        else {
            return user.get().getRole().toString();
        }
    }

    public List<Users> findAllUser() {
        return userRepository.findAll();
    }

    public void Order() { // 장바구니 시스템 만든 후 만들기, 장바구니 라는 도메인 먼저 만들기
        
    }
}
