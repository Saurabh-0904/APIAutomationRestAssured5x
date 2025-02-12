package com.testingacademy.example.tests.crud.PATCH;

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
    String token = "1d9a7be8145aa54" ;


    @Test
    public void Positive1()
    {
        //ID - 23668
        //URL - https://restful-booker.herokuapp.com/booking/7609
        //Authentication - token
        //Payload - "1d9a7be8145aa54" - temporarily taken by manually
        // Headers = Content Type - application/json, Cookie - token

        String payload = "{\n" +
                "    \"firstname\" : \"Mr.Saurabh\"\n" +
                "}";
        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/23668");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        requestSpecification.body(payload).log().all();

        //Calling PUT method on URI. After hitting, we get a response
        Response response = requestSpecification.when().patch();

        //Get validatable response to perform validation

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //validatableResponse.body("firstname", Matchers.equalTo("S"));
        //validatableResponse.body("lastname", Matchers.equalTo("B"));






    }
}
