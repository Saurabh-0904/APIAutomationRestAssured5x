package com.testingacademy.example.misc.PayloadMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PayloadUsingMap {

    //String is not a good way to manage a payload
    //It is not a useful coz issue with Reusability, maintainability

    //So there is a way called HashMap
    //JSON Payload convert to -> Map -> this Map can contain further Map also


    RequestSpecification requestSpecification ;
    ValidatableResponse validatableResponse ;

    @Test
    public void testPOSTreq(){

        //Below is a payload using String we are not going to use
        /*String payload = "{\n" +
                "    \"firstname\": \"S\",\n" +
                "    \"lastname\": \"B\",\n" +
                "    \"totalprice\": 999,\n" +
                "    \"depositpaid\": false,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2024-12-01\",\n" +
                "        \"checkout\": \"2022-12-03\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Lunch\"\n" +
                "}";*/

        //We will use a HashMap
        //As our Payload containg String keys and mixed values (String, Integer, Boolean)

        //Below converted JSON payload to Map
        //Parent Map
        Map<String, Object> jsonBodyUsingMap = new HashMap<>();

        jsonBodyUsingMap.put("firstname","Saurabh");
        jsonBodyUsingMap.put("lastname","Bhalerao");
        jsonBodyUsingMap.put("totalprice",111);
        jsonBodyUsingMap.put("depositpaid",true);

        //Child Map
        //Map<String, Object> bookingDatesMap = new HashMap<>(); // Here Hashmap used, and it will keep Keys in random order
        Map<String, Object> bookingDatesMap = new LinkedHashMap<>(); // LikedHashMap to keep the order
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        //Assigned Child Map to parent
        jsonBodyUsingMap.put("bookingdates",bookingDatesMap);

        jsonBodyUsingMap.put("additionalneeds", "Lunch");

        System.out.println(jsonBodyUsingMap);




        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        //Calling PUT method on URI. After hitting, we get a response
        Response response = requestSpecification.when().post();

        //Get validatable response to perform validation

        Integer bookingID = response.then().extract().path("bookingid");


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your Booking ID is " + bookingID);

    }
}
