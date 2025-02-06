package com.testingacademy.example.misc.gson.payloadPOJO;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DemoGson {

    //Here we are using a Pojo Class
    //Rules in Pojo class is
        //i) Variables should be Private
        // ii) May have getter or setter or both methods
        // iii) It should have a default public Constructor

    //How to create a Pojo Class -> there are 2 ways
    //i) difficult
    //ii) Easy

    //i) difficult :-
    /*{
    "bookingid": 1867,
    "booking": {
        "firstname": "Saurabh",
        "lastname": "Bhalerao",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Lunch"
    }*/

    // There are 2 curly braces are in Payload, so we need to create 2 classes
    //So we have created 2 classes Booking and Booking dates
    //we have created a variables as per the Keys

    //ii) Easy
    //  Copy Payload and open google type java to pojo maker (https://www.jsonschema2pojo.org/)
    // make appropriate settings
    // and your classes are created
    //refer classes Booking2 and BookingDates2

    RequestSpecification requestSpecification ;
    ValidatableResponse validatableResponse ;


    @Test
    public void testPost(){

        Booking2 booking2 = new Booking2();

        booking2.setFirstname("Saurabh");
        booking2.setLastname("Bhalerao");
        booking2.setTotalprice(1000);
        booking2.setDepositpaid(true);

        BookingDates2 bookingDates2 = new BookingDates2();
        bookingDates2.setCheckin("2024-02-01");
        bookingDates2.setCheckout("2024-10-01");
        booking2.setBookingdates(bookingDates2);
        booking2.setAdditionalneeds("Lunch");

        System.out.println(booking2);

        /*requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();

        //Calling PUT method on URI. After hitting, we get a response
        Response response = requestSpecification.when().post();

        //Get validatable response to perform validation

        Integer bookingID = response.then().extract().path("bookingid");


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your Booking ID is " + bookingID);*/


    }

}
