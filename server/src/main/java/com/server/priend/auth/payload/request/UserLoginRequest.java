package com.server.priend.auth.payload.request;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String email;
    private String password;
}
