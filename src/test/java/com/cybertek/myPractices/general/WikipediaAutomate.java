package com.cybertek.myPractices.general;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaAutomate {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://www.wikipedia.com");

        driver.findElement(By.id("searchInput")).sendKeys("cem karaca");
        driver.findElement(By.xpath("//i[contains(text(),'Search')]")).click();
        driver.findElement(By.className("fn")).getText();
        driver.findElement(By.xpath("//a[@title='Robert College']")).click();

        //Robert_College bu ifadeyle bitip bitmediği
        //System.out.println(driver.getCurrentUrl());



    }
}
