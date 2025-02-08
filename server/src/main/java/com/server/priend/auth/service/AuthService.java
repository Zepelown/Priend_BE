package com.server.priend.auth.service;

import com.server.priend.auth.entity.User;
import com.server.priend.auth.payload.request.UserLoginRequest;
import com.server.priend.auth.payload.request.UserRegisterRequest;
import com.server.priend.auth.payload.response.UserLoginResponse;
import com.server.priend.auth.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    private final AuthRepository authRepository;

    @Autowired
    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Transactional
    public void register(UserRegisterRequest userRegisterRequest) {
        authRepository.save(userRegisterRequest.toUser());
    }

    @Transactional
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        User user = authRepository.findByEmail(userLoginRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        return new UserLoginResponse("test");
    }
}
