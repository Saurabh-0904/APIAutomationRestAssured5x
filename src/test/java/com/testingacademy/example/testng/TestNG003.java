package com.testingacademy.example.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestNG003 {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;

    @BeforeTest
    public void getToken(){
        System.out.println("-- Get Token --");
        requestSpecification = RestAssured.given();
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        Response response = requestSpecification.post();
        validatableResponse = response.then();

        //Rest Assured -> Matchers (Hamcrest) - 1-2% Times you will be using it
        validatableResponse.body("token", Matchers.notNullValue());

        //TetsNG Assertion
        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);

    }

    @BeforeTest
    public void getBookingID(){
        System.out.println("-- Get Booking ID --");
        requestSpecification = RestAssured.given();
        String payload = "{\n" +
                "    \"firstname\" : \"Saurabh\",\n" +
                "    \"lastname\" : \"Bhalerao\",\n" +
                "    \"totalprice\" : 800,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-07-15\",\n" +
                "        \"checkout\" : \"2024-07-18\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast,lunch\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        //Making a Request

        Response response = requestSpecification.when().post();

        //Validation Part

        validatableResponse = response.then();

        String responseString = response.asString(); // To print a response body stored in String variable

        System.out.println(responseString); //printed a response body

        validatableResponse.statusCode(200);

        //TetsNG Assertion
        bookingID = response.then().log().all().extract().path("bookingid");
        System.out.println(bookingID);

    }

    @Test
    public void testPutRequest(){
        // Token and BookingID
        System.out.println("-- Test case PUT request --");
        String jsonString = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(jsonString).log().all();

        Response response = requestSpecification.when().put();

        //Get Validatable response to perform validation
        validatableResponse = response.then().log().all();

        //Validate Status code = 200
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("James"));
        validatableResponse.body("lastname", Matchers.equalTo("Brown"));


    }@Test
    public void testPutRequest2(){
        // Token and BookingID
        System.out.println("-- Test case PUT request 2 Only Assertions changed  --");
        String jsonString = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(jsonString).log().all();

        Response response = requestSpecification.when().put();

        //Get Validatable response to perform validation
        validatableResponse = response.then().log().all();

        //Validate Status code = 200
        validatableResponse.statusCode(200);

        String firstName = response.then().log().all().extract().path("firstname");
        assertThat(firstName).isNotEmpty().isNotBlank().isNotNull();



    }
}
