package com.cybertek.myPractices.Lessons;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForReview {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("firefox");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        driver.findElement(By.xpath("//button[ends-with(@id,'_button')]")).click();

    }
}
