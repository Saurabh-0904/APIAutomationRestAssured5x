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

public class TestNG002 {

    //PUT Request

    //Before- Token, ID,

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token;

    @BeforeTest
    public void getToken(){
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

        //AssertJ
        assertThat(token).isNotNull().isNotBlank().isNotEmpty();

        System.out.println(token);
    }

    @Test
    public void testNonBDDStylePUT(){
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

    //Setting Content type to specify format in which request payload will be sent.//ContentType is an ENUM
    requestSpecification.contentType(ContentType.JSON);

    //Setting a cookie for authentication as per API Documentation
    requestSpecification.cookie("token", token);

    //Adding URI
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/4465");
        //Adding Body as a String
        requestSpecification.body(jsonString);

        //Calling PUT method on URI. After hitting we're getting Response
        Response response = requestSpecification.put();

        //Printing response as String
        System.out.println(response.asString());

        //Get Validatable response to perform validation
        validatableResponse = response.then().log().all();

        //Validate Status code = 200
        validatableResponse.statusCode(200);


    }
}
