package com.cybertek.myPractices.general;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTestWithRamazanAbi {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        List<WebElement> names = driver.findElements(By.className("figure"));

        Actions actions = new Actions(driver);
        //hover over each image in the website
        //verify each name: user text is displayed

        int n = 1;
        for (WebElement name : names) {
            actions.moveToElement(name).perform();
            Thread.sleep(2000);
            String userText = name.getText();

            Assert.assertTrue(userText.contains("name: user" + n), "verify user text is displayed");
            n++;

        }


    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");

        List<WebElement> names = driver.findElements(By.cssSelector("div.figure"));

        Actions actions = new Actions(driver);

        for (int i = 0; i < names.size(); i++) {
            actions.moveToElement(names.get(i)).perform();
            Thread.sleep(2000);
            String userText = names.get(i).getText();
            Assert.assertTrue(userText.contains("name: user" + (i + 1)), "verify user text is displayed");
        }


    }


@Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/hovers");
        List<WebElement> users = driver.findElements(By.tagName("img"));
        String expectedResult = "name: user";
        String actualResult;
        Actions actions = new Actions(driver);

        for (int i=0; i<users.size(); i++) {
            actions.moveToElement(users.get(i)).perform();
            driver.findElement(By.xpath("(//h5)["+(i+1)+"]"));
            Assert.assertTrue(driver.findElement(By.xpath("(//h5)["+(i+1)+"]")).isDisplayed());
        }

    }
}
