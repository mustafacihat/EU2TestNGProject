package com.cybertek.myPractices.Lessons.locatorHomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.wikipedia.org");

        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver");
        driver.findElement(By.xpath("//i[@class='sprite svg-search-icon']")).click();
        driver.findElement(By.id("ooui-php-1")).clear();
        driver.findElement(By.id("ooui-php-1")).sendKeys("selenium (software)");
        driver.findElement(By.xpath("//button/span[2]")).click();
        driver.findElement(By.xpath("//a[@title='Selenium (software)']")).click();
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.substring(actualUrl.length()-"Selenium_(software)".length()).equals("Selenium_(software)")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualUrl = " + actualUrl);
        }


    }
}
