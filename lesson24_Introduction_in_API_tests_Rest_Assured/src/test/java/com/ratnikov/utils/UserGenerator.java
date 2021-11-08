package com.ratnikov.utils;

import com.ratnikov.model.CreateUserRequest;

public class UserGenerator {
    public static CreateUserRequest getSimpleUser() {
        return CreateUserRequest.builder()
                .name("simple")
                .job("automation")
                .build();
    }
}
