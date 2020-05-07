package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestIsDisplayed {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

               driver.findElement(By.xpath("//button[text()='Start']")).click();

        Thread.sleep(5000);

        WebElement userNameBox = driver.findElement(By.cssSelector("#username"));
        System.out.println(userNameBox.isDisplayed());

        userNameBox.sendKeys(" tomsmith");
        WebElement passwordBox = driver.findElement(By.id("pwd"));
        passwordBox.sendKeys("SuperSecretPassword");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}
