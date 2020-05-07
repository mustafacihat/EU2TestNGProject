package com.cybertek.myPractices.review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GetAttributeRev {

    @Test
    public void test(){
        WebDriver driver = WebDriverFactoryRew.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement element = driver.findElement(By.xpath("//*[text()='Button 2']"));

        System.out.println(element.getAttribute("outerHTML"));
        System.out.println(element.getAttribute("innerHTML"));
        System.out.println(element.getAttribute("class"));


    }
}
