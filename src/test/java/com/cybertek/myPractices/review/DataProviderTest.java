package com.cybertek.myPractices.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @DataProvider
    public Object[][] testData() {

        Object[][] obj = new Object[2][2];

        obj[0][0] = "Cihat";
        obj[0][1] = 1;
        obj[1][0] = "Yapıcı";
        obj[1][1] = 2;

        return obj;
    }
    @Test(dataProvider = "testData")
    public void test1(String s1, int i1){
        System.out.println(s1+ "/" + i1);
    }

    @DataProvider
    public Object [] testData2(){

        return new Object [] {1101,247,3,404,5,6,7};

    }
    @Test(dataProvider = "testData2")
    public void test2(int number){
        System.out.println(number);
    }

}
