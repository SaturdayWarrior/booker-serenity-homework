package com.restfulbooker.authinfo;

import com.restfulbooker.model.AuthPojo;
import com.restfulbooker.testbase.TestBaseAuth;
import com.restfulbooker.testbase.TestBaseBooking;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

//@RunWith(SerenityRunner.class)
public class CreatingAuthenticationToken extends TestBaseAuth {

    @Title("Creating a new token to use for access to PUT and DELETE booking requests")
    @Test
    public void creatingNewToken(){
        AuthPojo authPojo = new AuthPojo();
        authPojo.setUsername("admin");
        authPojo.setPassword("password123");
        String token = SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(authPojo)
                .when()
                .post()
                .then()
                .extract()
                .path("token");
        System.out.println(token);

    }






}
