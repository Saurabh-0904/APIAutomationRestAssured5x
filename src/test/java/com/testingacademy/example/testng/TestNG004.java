package com.testingacademy.example.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestNG004 {

    // Data Driven Testing
    //You can run a Testcase with multiple inputs
    //Login test -> 100 of user
    //Registration -> DDT

    //For this we need a DataProvider - where is my testdata?

    @DataProvider
    public Object [][]getData(){
        return new Object[][]{
                new Object[]{"admin","admin"},
                new Object[]{"admin","password"},
                new Object[]{"admin","password123"},
                new Object[]{"admin","admin"},
                new Object[]{"admin","password"},
                new Object[]{"admin","password123"}
        };
    }


@Test(dataProvider = "getData")
    public void loginTest(String username, String password){
        System.out.println(username);
        System.out.println(password);
    }

}