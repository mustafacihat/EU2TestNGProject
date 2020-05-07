package com.cybertek.myPractices.Lessons.locatorHomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EbayTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com");

        driver.findElement(By.id("gh-ac")).sendKeys("book");
        driver.findElement(By.id("gh-btn")).click();
        String text = driver.findElement(By.xpath("//h1[contains(text(),' results for ')]")).getText();
        System.out.println(text);


    }
}
