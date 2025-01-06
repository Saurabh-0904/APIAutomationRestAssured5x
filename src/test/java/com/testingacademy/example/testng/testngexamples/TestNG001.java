package com.testingacademy.example.testng.testngexamples;

import org.testng.annotations.*;

public class TestNG001 {


    @BeforeSuite
    void demo1(){
        System.out.println("Before Suite");

    }


    @BeforeTest
    void demo2(){
        System.out.println("Before Test");
    }


    @BeforeClass
    void demo3(){
        System.out.println("Before Class");
    }



    @BeforeMethod
    //Why -> Read of Excel file
    // File text, JSON, CSV, Database
    //Configuration Load extra
    void demo4(){
        System.out.println("Before Method");
    }


    @Test
    void test1(){
        System.out.println("Test 1");
    }


/*    @Test
    void test2(){
        System.out.println("Test 2");
    }*/


    @AfterMethod
    //Why -To Close the files - here write the code
    void demo5(){
        System.out.println("After Method");
    }


    @AfterClass
    void demo6() {
        System.out.println("After Class");
    }


    @AfterTest
    void demo7(){
        System.out.println("After Test");
    }


    @AfterSuite
    void demo8(){
        System.out.println("After Suite");

    }



}
