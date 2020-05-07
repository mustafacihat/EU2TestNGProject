package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test() {

        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //locate and click Destroy the World button
        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();


        //locate and click No button

        driver.findElement(By.xpath("//button[.='No']")).click();

    }

    @Test
    public void Alerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //locate click the Click for JS alert button
        driver.findElement(By.xpath("//button[1]")).click();
        //switch to JS alert windows
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        //click OK button on the alert
        alert.accept();

        //Click on Click For JS Confirm
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[2]")).click();


        //Click the Cancel button
        alert.dismiss();

        //Click for JS prompt
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[3]")).click();
        //sendkeys to alert and click Ok
        alert.sendKeys("Mike Smith");
        alert.accept();


    }

}
