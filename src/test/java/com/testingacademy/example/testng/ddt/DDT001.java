package com.testingacademy.example.testng.ddt;

import org.testng.annotations.Test;

public class DDT001 {

    //Test data -> From the excel file - DataProvider
    //Testcase login where we can inject the username and password

    //To Read the Excel file :-
    //1) Apache POI - 60-70% - little difficult to understand first time
    //2) Fillow library - 30% - Super Easy

    //Excel - There is not support directly in JAVA to read the excel file
    //Apache POI Library
    //Excel format - xls, xlsx, csv


    @Test (dataProvider = "getData", dataProviderClass = UtilExcel.class)
    public void testLogin (String username, String password){
        System.out.println(username);
        System.out.println(password);
    }
}
