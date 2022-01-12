package com.restfulbooker.bookinginfo;

import com.restfulbooker.constants.EndPoints;
import com.restfulbooker.testbase.TestBaseBooking;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

//@RunWith(SerenityRunner.class)
public class BookingDeleteRequest extends TestBaseBooking {

    @Title("Deletes a booking with ID")
    @Test
    public void deleteBooking(){
        SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=7f5c7565637e73b")
                .pathParam("bookingId", 10)
                .when()
                .delete(EndPoints.DELETE_SINGLE_BOOKING_WITH_ID)
                .then()
                .statusCode(201)
                .log().all();
    }
}
