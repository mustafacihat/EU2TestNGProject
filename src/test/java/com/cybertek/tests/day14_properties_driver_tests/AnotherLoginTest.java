package com.cybertek.tests.day14_properties_driver_tests;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {

    @Test
    public void test(){
        driver.get(ConfigurationReader.get("url"));
        String userName = "driver_username";
        String passWord = "driver_password";
        driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.get(userName));
        driver.findElement(By.id("prependedInput2")).sendKeys(passWord+ Keys.ENTER);
    }
}
