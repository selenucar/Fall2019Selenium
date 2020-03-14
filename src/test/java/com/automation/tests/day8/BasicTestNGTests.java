package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;


public class BasicTestNGTests {
    @Test
    public void test1(){
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual, expected);
    }
}
