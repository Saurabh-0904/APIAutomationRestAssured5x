package com.testingacademy.example.tests.crud.GET;

import io.restassured.RestAssured;

public class BDDStyleGET {
    public static void main(String[] args) {

        // GET Request
        //URL = https://restful-booker.herokuapp.com/booking/639
        //Header = ?
        //GET Method =
        //base URI = https://restful-booker.herokuapp.com
        //base path = /booking/639
        //Payload = NO
        //Auth = not needed


        //What to validate ?
        //Status code
        // Response body
        //Time, Headers, Cookies


        //How to use RestAssured
        //Gherkin syntax -> Given, When, Then -> Style ->
        //example Given a Pen When writting Then it will write


        //RestAssured.given().when().then() - DSL (Java)

        //Given ->
        //URL =
        //Header = ? , Cookies
        //base URL =
        //base path =
        //Auth = not needed

        //When ->
        //Payload = ?
        //GET Method =


        //Then ->
        // Response Validation
            //Status Code
            //Response Body
            //Time, Headers, Cookies

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com").basePath("/booking/639")


                .when().log().all() // log().all() will show logs in output window
                .get()

                .then()
                .log().all() // log().all() will show logs in output window
                .statusCode(200);  // If we gove 201 here then it will give error as it becomes negative testcase

        // Here if you get 404 in output then it is deleted from server
    }
}
