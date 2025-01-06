package com.testingacademy.example.testng.testngexamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG000 {

    @Test
    public void testcase1 (){
        Assert.assertEquals(true, true);

    }

    @Test
    public void testcase2 (){
        Assert.assertEquals(false, true);

    }
}
