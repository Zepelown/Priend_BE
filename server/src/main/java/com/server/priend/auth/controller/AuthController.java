package com.server.priend.auth.controller;

import com.server.priend.auth.payload.request.UserRegisterRequest;
import com.server.priend.common.payload.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/user/")
public class AuthController {
    @PostMapping("register")
    public ResponseEntity register(@RequestBody UserRegisterRequest userRegisterRequest){
        Response response = Response.builder()
                .message("회원가입 성공")
                .build();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
