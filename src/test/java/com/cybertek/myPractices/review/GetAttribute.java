package com.cybertek.myPractices.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GetAttribute {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://translate.google.com/");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        //driver.quit();
    }

    @Test
    public void test(){

        WebElement english = driver.findElement(By.id("sugg-item-en"));

        System.out.println(english.getText());
        System.out.println("english.getAttribute(\"class\") = " + english.getAttribute("class"));
        System.out.println(english.getAttribute("value"));
        System.out.println("english.getAttribute(\"innerHTML\") = " + english.getAttribute("innerHTML"));
        System.out.println("english.getAttribute(\"outerHTML\") = " + english.getAttribute("outerHTML"));
    }
}
