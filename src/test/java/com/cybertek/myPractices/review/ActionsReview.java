package com.cybertek.myPractices.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsReview {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/hovers");

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        Actions actions = new Actions(driver);

        WebElement firstImage = driver.findElement(By.cssSelector("img[alt='User Avatar']:nth-of-type(1)"));

        actions.moveToElement(firstImage).perform();

        Thread.sleep(4000);
        WebElement message = driver.findElement(By.xpath("(//h5)[1]"));

        Assert.assertTrue(message.isDisplayed(),"verify the user message is displayed");





    }
    @Test
    public void test2() throws InterruptedException {

        for (int i = 1; i <=3; i++) {
            WebElement element = driver.findElement(By.xpath("(//img)[" + i + "]"));

            Actions actions = new Actions(driver);
            Thread.sleep(2000);
            actions.moveToElement(element).perform();

            WebElement text = driver.findElement(By.xpath("(//h5)[" + i + "]"));

            System.out.println(text.getText());
            Assert.assertTrue(text.isDisplayed(),"verify the user message is displayed");
        }

    }
}
