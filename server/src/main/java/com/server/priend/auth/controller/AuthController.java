package com.server.priend.auth.controller;

import com.server.priend.auth.payload.request.UserLoginRequest;
import com.server.priend.auth.payload.request.UserRegisterRequest;
import com.server.priend.auth.payload.response.UserLoginResponse;
import com.server.priend.auth.service.AuthService;
import com.server.priend.common.payload.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/user/")
public class AuthController {
    private final AuthService authService;
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("register")
    public ResponseEntity<Response> register(@RequestBody UserRegisterRequest userRegisterRequest){
        authService.register(userRegisterRequest);
        Response response = Response.builder()
                .message("회원가입 성공")
                .build();
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
    @PostMapping("login")
    public ResponseEntity<Response> login(@RequestBody UserLoginRequest userLoginRequest){
        UserLoginResponse userLoginResponse = authService.login(userLoginRequest);
        Response response = Response.builder()
                .message("")
                .data(userLoginResponse)
                .build();
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
}
