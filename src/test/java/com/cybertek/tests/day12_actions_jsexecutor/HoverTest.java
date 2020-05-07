package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class HoverTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    //hover over each image in the website
    //verify each name: user text is displayed

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        List<WebElement> names = driver.findElements(By.className("figure"));


        Actions actions = new Actions(driver);
        //first way with for loop iteration
        for (int i = 0; i < names.size(); i++) {

            actions.moveToElement(names.get(i)).perform();
            Thread.sleep(2000);
            String userText = names.get(i).getText();
            Assert.assertTrue(userText.contains("name: user" + (i + 1)), "verify user text is displayed");
            System.out.println(userText);


        }


    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        List<WebElement> names = driver.findElements(By.className("figure"));


        Actions actions = new Actions(driver);


        //second way foreach loop
        int n = 1;
        for (WebElement name : names) {
            actions.moveToElement(name).perform();
            Thread.sleep(2000);
            String userText = name.getText();
            System.out.println(userText);
            Assert.assertTrue(userText.contains("name: user" + n), "verify user text is displayed");

            n++;
        }
    }
}



