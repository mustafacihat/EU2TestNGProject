package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void switchWindowsTest() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/windows");

        //get title
        String currentTitle = driver.getTitle();
        System.out.println("Title before new window = " + currentTitle);
        //click click here link
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(2000);
        //driver.findElement(By.linkText("Cybertek School")).click();
        //get title again
        String titleLast = driver.getTitle();
        System.out.println("Title after window = " + titleLast);

        String currentWindowHandle = driver.getWindowHandle();
        System.out.println(currentWindowHandle);

        //we will switch to new window
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("windowHandles.size() = " + windowHandles.size());

        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);


            }
        }

        System.out.println("Title after switching window = " + driver.getTitle());


    }
    @Test
    public void moreThanTwoWindow(){
        driver.get("http://practice.cybertekschool.com/windows");

        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals("New Window")){
                break;
            }

        }
        System.out.println("after switch " + driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());

    }

}
