package com.restfulbooker.bookinginfo;

import com.restfulbooker.constants.EndPoints;
import com.restfulbooker.model.BookingPojo;
import com.restfulbooker.testbase.TestBaseBooking;
import com.restfulbooker.utils.TestUtils;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

//RunWith(SerenityRunner.class)
public class BookingPutRequest extends TestBaseBooking {

    @Title("Updating a current booking")
    @Test
    public void updateBooking() {

        HashMap<String, Object> booking = new HashMap<>();
        booking.put("checkin", "2022-01-01");
        booking.put("checkout", "2022-02-01");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Name after");
        bookingPojo.setLastname("put request");
        bookingPojo.setTotalprice(300);
        bookingPojo.setDepositpaid(false);
        bookingPojo.setBookingdates(booking);
        bookingPojo.setAdditionalneeds("Vegetarian food");

        SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .header("cookie", "token=2b60f78007a66ac")
                .pathParam("bookingId", "1")
                .body(bookingPojo)
                .when()
                .put(EndPoints.UPDATE_SINGLE_BOOKING_WITH_ID)
                .then()
                .statusCode(200)
                .log().all();
    }

}
