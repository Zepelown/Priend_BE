package com.server.priend.auth.service;

import com.server.priend.auth.payload.request.UserRegisterRequest;
import com.server.priend.auth.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    private AuthRepository authRepository;

    @Transactional
    public void register(UserRegisterRequest userRegisterRequest){
        authRepository.save(userRegisterRequest.toUser());
    }
}
