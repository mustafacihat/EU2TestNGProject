package com.cybertek.myPractices.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void tes1(){

        String browser = ConfigurationReader.get("browser");

        System.out.println(browser);

        WebDriver driver = WebDriverFactory.getDriver(browser);

    }

}
