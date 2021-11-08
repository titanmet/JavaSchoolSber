package com.ratnikov.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserPogo {
//    @JsonIgnoreProperties(ignoreUnknown = true)

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("id")
    private int id;

    @JsonProperty("avatar")
    private String Avatar;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("email")
    private String email;
}
