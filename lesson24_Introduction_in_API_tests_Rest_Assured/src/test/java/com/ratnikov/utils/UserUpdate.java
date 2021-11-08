package com.ratnikov.utils;

import com.ratnikov.model.CreateUserRequest;
public class UserUpdate {
    public static CreateUserRequest putSimpleUser() {
        return CreateUserRequest.builder()
                .name("simple 2")
                .job("zion resident")
                .build();
    }
}
