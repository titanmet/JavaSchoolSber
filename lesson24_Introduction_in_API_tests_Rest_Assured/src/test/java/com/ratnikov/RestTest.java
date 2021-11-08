package com.ratnikov;

import com.ratnikov.model.CreateUserRequest;
import com.ratnikov.model.CreateUserResponse;
import com.ratnikov.model.UserPogo;
import com.ratnikov.steps.UserSteps;
import com.ratnikov.utils.UserGenerator;
import com.ratnikov.utils.UserPatch;
import com.ratnikov.utils.UserUpdate;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RestTest {
    private static final RequestSpecification REQUEST_SPECIFICATION =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in/api")
                    .setBasePath("/users")
                    .setContentType(ContentType.JSON)
                    .build();

    @Test
    public void getUsers() {
        List<UserPogo> emails = UserSteps.getUsers();
        assertThat(emails).extracting(UserPogo::getEmail).contains("george.bluth@reqres.in");
    }

//    @Test
//    public void getUsers() {
//        given()
//                .spec(REQUEST_SPECIFICATION)
//                .when().get()
//                .then()
//                .log().all()
//                .statusCode(200)
////                .body("data[1].email", equalTo("janet.weaver@reqres.in"));
//                .body("data.find{it.email=='janet.weaver@reqres.in' }.first_name",equalTo("Janet"));
//    }

    @Test
    public void getListEmailUsers() {
        List<String> emails = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .log().all()
                .statusCode(200)
                .extract().jsonPath().getList("data.email");
    }

    @Test
    public void getUserPojoListEmailUsers() {
        List<UserPogo> emails = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .log().all()
                .statusCode(200)
                .extract().jsonPath().getList("data",UserPogo.class);
        assertThat(emails).extracting(UserPogo::getEmail).contains("george.bluth@reqres.in");
    }

    @Test
    public void createUser() {
//        CreateUserRequest rq = new CreateUserRequest();
//        rq.setName("simple");
//        rq.setJob("automation");

//        CreateUserRequest rq = CreateUserRequest.builder()
//            .name("simple")
//                .job("automation")
//                .build();

        CreateUserRequest rq = UserGenerator.getSimpleUser();


        CreateUserResponse rs = given()
//                .log().all()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .body(rq)
                .when().post()
                .then()
                .log().all()
                .extract().as(CreateUserResponse.class);

        assertThat(rs)
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(rq.getName());
    }

    @Test
    public void putUsers() {
        CreateUserRequest rq = UserUpdate.putSimpleUser();
        CreateUserResponse rs = given()
                .spec(REQUEST_SPECIFICATION)
                .body(rq)
                .when().put()
                .then()
                .log().all()
                .extract().as(CreateUserResponse.class);

        assertThat(rs)
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(rq.getName());
    }

    @Test
    public void patchUsers() {
        CreateUserRequest rq = UserPatch.patchSimpleUser();
        CreateUserResponse rs = given()
                .spec(REQUEST_SPECIFICATION)
                .body(rq)
                .when().patch()
                .then()
                .log().all()
                .extract().as(CreateUserResponse.class);

        assertThat(rs)
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(rq.getName());
    }
}
