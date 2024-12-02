package com.testingacademy.example.tests.crud.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class BDDStyle {

    @Test
    public void positiveTest1(){
        //POST Request
        //URL - https://restful-booker.herokuapp.com/auth
        //Payload - JSON
        //HEADER - Content Type

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";


        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON).log().all()

                .body(payload).when().post()

                .then().log().all().statusCode(200);








    }
}
