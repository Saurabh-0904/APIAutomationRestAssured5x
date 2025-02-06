package com.testingacademy.example.misc.gson.pojoSampleTC;

import com.google.gson.Gson;
import com.testingacademy.example.misc.gson.example.BookingResponse;
import com.testingacademy.example.misc.gson.payloadPOJO.Booking2;
import com.testingacademy.example.misc.gson.payloadPOJO.BookingDates2;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import com.github.javafaker.Faker;

public class POSTReqTC {

    RequestSpecification requestSpecification ;
    ValidatableResponse validatableResponse ;

    @Test
    public void testPositive1(){
        //Step 1 - POST
        //URL
        //Header
        //Body

        //Step 2
        //Prepare the payload (Object -> JSON String)
        //Send the request

        //Step 3
        //Validate Response
        //First name
        //Status code
        //Response time


        //Prepare your Payload\
        Faker faker = new Faker();
        String expectFirstName = faker.name().firstName();
        Booking2 booking2 = new Booking2();

        booking2.setFirstname(expectFirstName);
        booking2.setLastname("Bhalerao");
        booking2.setTotalprice(1000);
        booking2.setDepositpaid(true);

        BookingDates2 bookingDates2 = new BookingDates2();
        bookingDates2.setCheckin("2024-02-01");
        bookingDates2.setCheckout("2024-10-01");
        booking2.setBookingdates(bookingDates2);
        booking2.setAdditionalneeds("Lunch");

        System.out.println(booking2);

        //Object -> Json

        Gson gson = new Gson();
        String jsonStgringBooking = gson.toJson(booking2);
        System.out.println(jsonStgringBooking);



        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStgringBooking).log().all();


        //Calling PUT method on URI. After hitting, we get a response
        Response response = requestSpecification.when().post();
        String jsonResponseString = response.asString();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);



        //Validate Response (Deserialization JSON String -> Object)

        BookingResponse bookingResponseObject = gson.fromJson(jsonResponseString,BookingResponse.class);
        assertThat(bookingResponseObject.getBookingid()).isNotNull();
        assertThat(bookingResponseObject.getBooking().getFirstname()).isEqualTo(expectFirstName);






        //Get Validatable Response to perform Validation






    }







}
