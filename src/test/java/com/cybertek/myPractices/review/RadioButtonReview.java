package com.cybertek.myPractices.review;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RadioButtonReview {
    WebDriver driver;

    @BeforeMethod
    public void setUP() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
    }

    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(4000);
        //driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Radio Buttons")).click();

        WebElement blueButton = driver.findElement(By.id("blue"));
        Assert.assertTrue(blueButton.isSelected(), "verify blue button is selected");


        WebElement yellowButton = driver.findElement(By.id("yellow"));
        Assert.assertFalse(yellowButton.isSelected(), "verify yellow button is NOT selected");

        WebElement greenButton = driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled(), "verify green button is NOT enabled");

        WebElement hockeyButton = driver.findElement(By.id("hockey"));
        Assert.assertFalse(hockeyButton.isSelected(), "verify hockey button is NOT selected");

        hockeyButton.click();

        Assert.assertTrue(hockeyButton.isSelected(), "verify hockey button is selected");

        Assert.assertTrue(greenButton.isDisplayed(), "verify green button is displayed");
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[.='Add']")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("checkbox")).click();


        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));

        System.out.println(inputBox.isEnabled());
        System.out.println("inputBox.isDisplayed() = " + inputBox.isDisplayed());

       /* driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.sendKeys("cihat");*/

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        String text = "cihat";
        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')",inputBox);


    }


}




// jse.executeScript("arguments[0].value='"+text+"';", inputBox);
//jse.executeScript("arguments[0].setAttribute('value', '" + text +"')",inputBox);