package com.cybertek.myPractices.general;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaTestAli {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("selenium webdriver");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button/i"));
        searchButton.click();
        driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/ul/li[1]/div[1]/a/span")).click();

        Thread.sleep(5000);
        String expected = "Selenium_(software)";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expected))

        {
            System.out.println("PASS");
        }else

        {
            System.out.println("FAIL");
        }
    }

}