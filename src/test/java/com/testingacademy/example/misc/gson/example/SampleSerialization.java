package com.testingacademy.example.misc.gson.example;

import com.google.gson.Gson;
import org.testng.annotations.Test;

public class SampleSerialization {

    /*{
        "firstname" : "Saurabh",
        "lastname" : "Bhalerao",
        "gender" : "Male",
        "age" : 30,
        "salary" : 500.00,
        "married" : false
    }*/

    @Test
    public void test1(){

        //Converting 'Object' to 'JSON String'

        Employee emp = new Employee();

        emp.setFirstname("Saurabh");
        emp.setLastname("Bhalerao");
        emp.setAge(30);
        emp.setSalary(50916.50);
        emp.setMarried(true);
        emp.setGender("M");

        //Now we want to Serialised so we will use a GSON lib

        Gson gson = new Gson();
        String jsonemployee = gson.toJson(emp);
        System.out.println(jsonemployee);





    }
}
