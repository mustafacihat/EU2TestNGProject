package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class callWebDriverFactory {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Firefox");
        driver.get("http://www.google.com");
        driver.navigate().to("http://www.google.com");




    }
}
