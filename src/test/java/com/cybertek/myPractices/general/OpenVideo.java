package com.cybertek.myPractices.general;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenVideo {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://www.youtube.com");


        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));

       // WebDriverWait wait = new WebDriverWait(driver,10);

       // wait.until(ExpectedConditions.elementToBeClickable(searchBox));

        searchBox.sendKeys("kerkük zindanı");
        driver.findElement(By.cssSelector("yt-icon.style-scope.ytd-searchbox")).click();
        driver.findElement(By.xpath("//yt-formatted-string[contains(text(),'CEM KARACA - ')]")).click();
    }
}
