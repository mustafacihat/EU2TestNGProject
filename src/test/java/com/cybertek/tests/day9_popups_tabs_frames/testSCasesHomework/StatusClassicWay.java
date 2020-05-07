package com.cybertek.tests.day9_popups_tabs_frames.testSCasesHomework;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StatusClassicWay {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    @DataProvider
    public Object[] testData() {

        return new Object[]{"200", "301", "404", "500"};

    }


    @Test(dataProvider = "testData")
    public void test(String text) {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText(text)).click();
        String actualMessage = driver.findElement(By.tagName("p")).getText();
        String expectedMessage = "This page returned a " + text + " status code.";

        Assert.assertTrue(actualMessage.contains(expectedMessage), "Verify that following message is displayed:\n" +
                "This page returned a " + text + " status code.");

    }


}