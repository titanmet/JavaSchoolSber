package com.ratnikov.steps;

import com.ratnikov.model.UserPogo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserSteps {
    private static final RequestSpecification REQUEST_SPECIFICATION =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in/api")
                    .setBasePath("/users")
                    .setContentType(ContentType.JSON)
                    .build();

    public static List<UserPogo> getUsers() {
        return  given()
                .spec(REQUEST_SPECIFICATION)
                .get()
                .jsonPath().getList("data", UserPogo.class);
    }
}
