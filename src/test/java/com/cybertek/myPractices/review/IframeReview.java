package com.cybertek.myPractices.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeReview {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        //driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/iframe");
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame("mce_0_ifr");
        WebElement inputBox = driver.findElement(By.cssSelector("#tinymce"));
        inputBox.clear();
        inputBox.sendKeys("selenium");

        driver.switchTo().parentFrame();
        driver.switchTo().frame(0);
        inputBox.clear();
        inputBox.sendKeys("java");

        driver.switchTo().defaultContent();

        driver.switchTo().frame(iframe);

        inputBox.clear();
        inputBox.sendKeys("pyton");

    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");

        String body = driver.findElement(By.tagName("body")).getText();
        System.out.println(body);

        driver.switchTo().parentFrame();
        driver.switchTo().frame(1);
        String content = driver.findElement(By.id("content")).getText();
        System.out.println(content);

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");

        System.out.println("driver.findElement(By.tagName(\"body\")) = " + driver.findElement(By.tagName("body")).getText());


    }



}
