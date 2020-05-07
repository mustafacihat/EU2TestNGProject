package com.cybertek.tests.day7_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {


    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title","title","verify title");

        System.out.println("Second Assertion");
        Assert.assertEquals(1,1);

        //close browser
    }

    @Test
    public void test2(){
        System.out.println("Second test case");
        Assert.assertEquals("url","url");
    }

    @Test
    public void test3(){
        String expectedTitle="Cyb";
        String actualTitle="Cybertek";
        //verify that your title is starting with Cyb
       Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify title start with Cyb");
       Assert.assertTrue(2>1,"verify the numbers");

    }

    @Test
    public void test4(){
        //verify that email contains @
        String email = "mikesmith.com";
        Assert.assertTrue(email.contains("@"),"verify  email has @ sign");
    }
    @Test
    public void test5(){
        //verify something is false
        Assert.assertFalse(0>1,"verify that 0 is NOT greater than 1");//it will pass because checking the reverse logic
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("one","two");//it will pass because checking the reverse logic
    }
}
