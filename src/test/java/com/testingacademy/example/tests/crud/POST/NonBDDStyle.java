package com.testingacademy.example.tests.crud.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStyle {

    @Test
    public void positiveTest1() {

        //POST Request
        //URL - https://restful-booker.herokuapp.com/auth
        //Payload - JSON
        //HEADER - Content Type

        //Preparation

        RequestSpecification r = RestAssured.given();

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload);

        // Making Req

        Response response = r.when().post();

        //Validation Part

        ValidatableResponse validatableResponse = response.then();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse.statusCode(200);

    }
}
