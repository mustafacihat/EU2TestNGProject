package com.cybertek.myPractices.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MultipleWindowsReview {


    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        //driver.quit();
    }

    @Test
    public void forTwoTabTest() {
        driver.findElement(By.linkText("Click Here")).click();


        String windowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles.size());

        for (String handle : windowHandles) {
            if(!windowHandle.equals(handle)){
                driver.switchTo().window(handle);
            }
        }

        String title = driver.getTitle();
        System.out.println(title);


    }
    @Test
    public void forMultipleTabTest(){
        driver.findElement(By.linkText("Click Here")).click();

        String title ="New Window";

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(title)){
                break;
            }
        }

        System.out.println(driver.getTitle());


    }
}
