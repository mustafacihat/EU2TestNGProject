package com.cybertek.tests.day14_properties_driver_tests;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {

    @Test
    public void test1(){
        driver.get(ConfigurationReader.get("url"));

        String userName = "driver_username";
        String passWord = "driver_password";
        driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.get(userName));
        driver.findElement(By.id("prependedInput2")).sendKeys(passWord+ Keys.ENTER);

    }
}
