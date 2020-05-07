package com.cybertek.tests.day7_tyeps_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioButton = driver.findElement(By.id("green"));
        System.out.println("Is element enabled= " + greenRadioButton.isEnabled());

        Assert.assertFalse(greenRadioButton.isEnabled(),"Verify Green is not enabled");
    }

    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
    Assert.assertFalse(inputBox.isEnabled(),"verify the insertBox is not enabled");

        //inputBox.sendKeys("mike");


    }
}
