package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Iframes {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

      //how to switch frames

        //1.Swicth by using name or id attribute or iframe

        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith");

        //goes back to first frame(main html)
        //goes back to first frame, useful when we have swicthed multiple frames
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        //2.Using index
        driver.switchTo().frame(0);
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith with index");

        //second way to switch parent
        driver.switchTo().parentFrame();

        //3.Using Webelement
        //locating iframe with any valid locator
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);

        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith with webelement");



    }
    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/nested_frames");

        //switching to frame top
        driver.switchTo().frame("frame-top");
        //top has 3 children left middle right
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        //switch to parent --frame top
        driver.switchTo().parentFrame();

        //switch to right frame
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());


        //to switch main html we can use default content
        driver.switchTo().defaultContent();

        //switch to bottom
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }


}

