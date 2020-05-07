package com.cybertek.tests.day5_xPath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("selenium");
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit'][@value='Go']"));
        submitButton.click();
        WebElement info = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        String text = info.getText();
        System.out.println(text);

        driver.quit();


    }
}
