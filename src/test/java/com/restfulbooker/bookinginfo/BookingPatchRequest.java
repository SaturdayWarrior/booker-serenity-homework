package com.restfulbooker.bookinginfo;

import com.restfulbooker.constants.EndPoints;
import com.restfulbooker.model.BookingPojo;
import com.restfulbooker.testbase.TestBaseBooking;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

//@RunWith(SerenityRunner.class)
public class BookingPatchRequest extends TestBaseBooking {

    @Title("Updating a current booking with partial payload")
    @Test
    public void updatePartialDetails(){

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Name After");
        bookingPojo.setLastname("Patch");


        SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .header("cookie", "token=2b60f78007a66ac")
                .body(bookingPojo)
                .pathParam("bookingId", 2)
                .when()
                .patch(EndPoints.UPDATE_SINGLE_BOOKING_WITH_ID)
                .then()
                .statusCode(200)
                .log().all();

    }




}
