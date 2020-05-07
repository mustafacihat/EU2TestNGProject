package com.cybertek.myPractices.general;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// id    name tagName  className  linkText   partialLinkText
public class GeneralBasicLocators {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("computer");
        driver.findElement(By.className("nav-input")).click();

        driver.quit();

        driver = WebDriverFactory.getDriver("firefox");

        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        driver.findElement(By.linkText("Cybertek School")).click();

        driver.quit();

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.cybertekschool.com");

        Thread.sleep(5000);
        driver.findElement(By.partialLinkText("Log")).click();
        driver.findElement(By.id("okta-signin-username")).sendKeys("cyapicii@gmail.com");
        driver.findElement(By.id("okta-signin-password")).sendKeys("Fb9810541167");
        driver.findElement(By.id("okta-signin-submit")).click();


    }
}
