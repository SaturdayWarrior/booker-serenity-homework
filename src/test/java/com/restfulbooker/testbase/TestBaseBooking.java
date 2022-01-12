package com.restfulbooker.testbase;

import com.restfulbooker.constants.Path;
import com.restfulbooker.model.AuthPojo;
import com.restfulbooker.utils.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import org.junit.BeforeClass;

public class TestBaseBooking {

    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.basePath = Path.BOOKING;
    }
}
