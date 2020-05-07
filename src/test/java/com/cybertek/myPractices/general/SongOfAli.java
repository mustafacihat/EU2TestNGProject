package com.cybertek.myPractices.general;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SongOfAli {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https:www.youtube.com");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("ay gitsin sen kal bu gece");
        driver.findElement(By.cssSelector("yt-icon[class='style-scope ytd-searchbox']")).click();
        driver.findElement(By.xpath("(//yt-formatted-string[contains(text(),'Ahmet kaya - bırak ay gitsin sen kal bu gece')])[1]")).click();
    }
}
