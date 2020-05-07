package com.cybertek.myPractices.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframesRev {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");
        //switch by using id or name
        driver.switchTo().frame("mce_0_ifr");
        WebElement textInputBox = driver.findElement(By.tagName("p"));
        textInputBox.clear();
        textInputBox.sendKeys("using id");

        //go back main frame
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //switch by using index number
        driver.switchTo().frame(0);
        WebElement textInputBox2 = driver.findElement(By.tagName("p"));
        textInputBox2.clear();
        textInputBox2.sendKeys("using index number");

        //go back parent frame

        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //switch by using webelement
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement textInputBox3 = driver.findElement(By.id("tinymce"));
        Thread.sleep(3000);
        textInputBox3.clear();
        textInputBox3.sendKeys("using webelement");


    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println("driver.findElement(By.id(\"content\")) = " + driver.findElement(By.id("content")).getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println("driver.findElement(By.name(frame-bottom)).getText() = " + driver.findElement(By.tagName("body")).getText());


        driver.switchTo().parentFrame();
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame(1);
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.id("content")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());
    }
}
