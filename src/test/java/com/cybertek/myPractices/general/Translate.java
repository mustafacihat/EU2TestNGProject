package com.cybertek.myPractices.general;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Translate {

    WebDriver driver;

    @Test
    public void test1() {

    }

    @BeforeMethod
    public void setUpClass() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://translate.google.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("sugg-item-en")).click();
        driver.findElement(By.cssSelector("#input-wrap>textarea")).sendKeys("regression");
        driver.findElement(By.xpath("//div[contains(@class,'src-tts left-positio')]")).click();
        driver.findElement(By.cssSelector("#input-wrap>textarea")).clear();
        driver.findElement(By.cssSelector("#input-wrap>textarea")).sendKeys("upcoming");
        driver.findElement(By.cssSelector("#input-wrap>textarea")).clear();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }


}
