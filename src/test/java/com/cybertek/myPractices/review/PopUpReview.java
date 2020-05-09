package com.cybertek.myPractices.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PopUpReview {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        //driver.quit();
    }

    @Test
    public void test(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//span[.='Destroy the World']")).click();
        driver.findElement(By.xpath("//span[.='No']")).click();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        List<WebElement> elements = driver.findElements(By.cssSelector(".btn.btn-primary"));

        System.out.println(elements.size());

        //first button
        elements.get(0).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(7000);
        alert.accept();


        //second button
        elements.get(1).click();
        Thread.sleep(7000);
        alert.dismiss();


        //third button
        elements.get(2).click();

        alert.sendKeys("cihat");
        Thread.sleep(7000);
        alert.accept();


    }
}
