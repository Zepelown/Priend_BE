package com.server.priend.auth.payload.request;

import com.server.priend.auth.entity.User;
import lombok.Data;

@Data
public class UserRegisterRequest {
    private String email;
    private String password;

    public User toUser(){
        return User.builder()
                .email(this.email)
                .password(this.password)
                .build();
    }
}
