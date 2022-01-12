package com.restfulbooker.model;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;

public class AuthPojo {

    static String token;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getAuthToken(){
        AuthPojo authPojo = new AuthPojo();
        authPojo.setUsername("admin");
        authPojo.setPassword("password123");
        token = SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(authPojo)
                .when()
                .post("https://restful-booker.herokuapp.com/auth")
                .then()
                .extract()
                .path("token");
        System.out.println(token);
        return token;
    }
}
