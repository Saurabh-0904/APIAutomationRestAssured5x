package com.testingacademy.example.tests.crud.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStyle {

    RequestSpecification requestSpecification ;
    ValidatableResponse validatableResponse ;
    String token = "731a67adffc7243" ;


    @Test
    public void Positive1()
    {
        //ID - 1227
        //URL - https://restful-booker.herokuapp.com/booking/1227
        //Authentication - token
        //Payload - "3c50e0942812c51" - temporarily taken by manually
        // Headers = Content Type - application/json, Cookie - token

        String payload = "{\n" +
                "    \"firstname\": \"S\",\n" +
                "    \"lastname\": \"B\",\n" +
                "    \"totalprice\": 999,\n" +
                "    \"depositpaid\": false,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2024-12-01\",\n" +
                "        \"checkout\": \"2022-12-03\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Lunch\"\n" +
                "}";
        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/870");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        requestSpecification.body(payload).log().all();

        //Calling PUT method on URI. After hitting we get response
        Response response = requestSpecification.when().put();

        //Get validatable response to perform validation

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        validatableResponse.body("firstname", Matchers.equalTo("S"));
        validatableResponse.body("lastname", Matchers.equalTo("B"));






    }
}
