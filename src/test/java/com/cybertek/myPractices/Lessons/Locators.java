package com.cybertek.myPractices.Lessons;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(5000);

        searchBox.sendKeys("computer");

        WebElement searchBoxSubmit = driver.findElement(By.className("nav-input"));
        searchBoxSubmit.click();




       driver.quit();

       driver = WebDriverFactory.getDriver("firefox");

       driver.get("http://practice.cybertekschool.com/dynamic_loading");

       driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger")).click();
       driver.navigate().back();

       WebElement partial =driver.findElement(By.partialLinkText("Example 1:"));
       partial.click();


    }
}
