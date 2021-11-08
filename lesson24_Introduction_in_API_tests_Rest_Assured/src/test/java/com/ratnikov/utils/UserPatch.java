package com.ratnikov.utils;

import com.ratnikov.model.CreateUserRequest;

public class UserPatch {
    public static CreateUserRequest patchSimpleUser() {
        return CreateUserRequest.builder()
                .name("morpheus")
                .build();
    }
}
