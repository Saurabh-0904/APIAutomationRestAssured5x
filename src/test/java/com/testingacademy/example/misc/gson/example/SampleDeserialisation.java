package com.testingacademy.example.misc.gson.example;

import com.google.gson.Gson;
import org.testng.Assert;

public class SampleDeserialisation {

    //Deserialization is use to validate our response

    public void deserializationTest(){

        String jsonString = "{\"firstname\":\"Saurabh\"," +
                            "\"lastname\":\"Bhalerao\"," +
                            "\"gender\":\"M\"," +
                            "\"age\":30," +
                            "\"salary\":50916.5," +
                            "\"married\":true}";

        Gson gson = new Gson();

        Employee emp = gson.fromJson(jsonString,Employee.class);
        String firstname = emp.getFirstname();
        String lastname = emp.getLastname();

        Assert.assertEquals(firstname, "Saurabh");
    }

}
