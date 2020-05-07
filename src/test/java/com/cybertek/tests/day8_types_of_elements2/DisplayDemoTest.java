package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DisplayDemoTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement userNameInput = driver.findElement(By.id("username"));
        System.out.println("result " + userNameInput.isDisplayed());

        //verify that username not displayed in the screen

        Assert.assertFalse(userNameInput.isDisplayed(), "verify that username NOT displayed in the screen");

        driver.findElement(By.xpath("//button[text()='Start']")).click();


        Thread.sleep(5000);

        Assert.assertTrue(userNameInput.isDisplayed(), "verify that username displayed in the screen");

    }
}
