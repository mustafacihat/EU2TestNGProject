package com.cybertek.myPractices.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ListOFElements {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        //driver.quit();
    }

    @Test
    public void test() {

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println(buttons.size());

        for (WebElement button : buttons) {
            System.out.println(button.getText());
        }
        System.out.println("==============================================");
        for (int i = 0; i < buttons.size(); i++) {
            System.out.println(buttons.get(i).getText());
        }
        System.out.println("===========================================");


        buttons.forEach(b -> System.out.println(b.getText()));

        //driver.findElement(By.tagName("button858")); error

    }
}
