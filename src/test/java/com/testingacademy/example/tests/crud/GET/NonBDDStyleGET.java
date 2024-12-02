package com.testingacademy.example.tests.crud.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyleGET {
    //GET Request
    //BDD style and Non BDD Style

    //given, when, then ---> Builder pattern

    public static void main(String[] args) {
        // URL -> https://restful-booker.herokuapp.com/booking/1

        RequestSpecification r = RestAssured.given();

        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/1").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);

    }


}
