package com.cybertek.tests.day7_testNG;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BeforeAfterTests {



    @Test
    public void test1(){

        System.out.println("This is my test 1");

        //close browser, quit
    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("This is my test 2");
    }

    @Test
    public void test3(){
        System.out.println("This is my test 3");
    }

    @BeforeMethod
    public void setUp(){
        //WebDriver part
        System.out.println("BEFORE METHOD HERE");
        System.out.println("WebDriver part");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("AFTER METHOD HERE");
        System.out.println("Driver quit");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("--BEFORE CLASS--");
        System.out.println("RUNS ONLY ONE IN THE CLASS");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("--AFTER CLASS--");
        System.out.println("GENERATE REPORT");
        System.out.println("RUNS ONLY ONE IN THE CLASS");
    }


}
