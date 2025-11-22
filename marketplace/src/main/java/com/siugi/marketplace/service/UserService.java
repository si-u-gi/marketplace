package com.siugi.marketplace.service;

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
        checkUserDuplication(user);

        userRepository.save(user);
        return user.getId();
    }

    private void checkUserDuplication(Users user) {
        userRepository.findByUser(user.getId()).ifPresent(u -> {
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
}
