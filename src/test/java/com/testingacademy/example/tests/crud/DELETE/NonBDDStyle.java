package com.testingacademy.example.tests.crud.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStyle {

    RequestSpecification requestSpecification ;
    ValidatableResponse validatableResponse ;
    String token = "a6adf8874ea931b" ;

    @Test
    public void positive1(){
        //ID = 21613
        //URL = https://restful-booker.herokuapp.com/booking/21613
        //Headers = cookies = token = a6adf8874ea931b
        //Payload =

        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com/booking");
        requestSpecification.basePath("/booking/21613");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        Response response = requestSpecification.when().delete();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);

    }
}
