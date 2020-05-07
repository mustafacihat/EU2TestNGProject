package com.cybertek.myPractices.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PopUpAlertsRev {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test1(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        driver.findElement(By.xpath("//span[.='Destroy the World']")).click();

        driver.findElement(By.xpath("//button[.='Yes']")).click();

        String ActualResult = driver.findElement(By.cssSelector(".ui-growl-message")).getText();
        String expected = "Please try again later.";

        Assert.assertTrue(ActualResult.contains(expected),"verify the System Error message displayed.");


    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        driver.findElement(By.tagName("button")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();


        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);
        alert.dismiss();

        driver.findElement(By.xpath("//button[3]")).click();
        Thread.sleep(2000);
        alert.sendKeys("mike smith");
        alert.accept();

    }
    @Test
    public void test3(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        Actions actions = new Actions(driver);

        actions.moveToElement( driver.findElement(By.tagName("button"))).click().perform();

        Alert alert = driver.switchTo().alert();

        alert.accept();

        actions.moveToElement( driver.findElement(By.xpath("//button[2]"))).click().perform();
        alert.dismiss();

        actions.moveToElement( driver.findElement(By.xpath("//button[3]"))).click().perform();
        alert.sendKeys("cihat");
        alert.accept();

    }

}
