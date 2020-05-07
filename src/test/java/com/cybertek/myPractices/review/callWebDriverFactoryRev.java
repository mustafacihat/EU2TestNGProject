package com.cybertek.myPractices.review;

import org.openqa.selenium.WebDriver;

public class callWebDriverFactoryRev {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactoryRew.getDriver("edge");

        driver.navigate().to("http://www.google.com");

        Thread.sleep(5000);
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}
