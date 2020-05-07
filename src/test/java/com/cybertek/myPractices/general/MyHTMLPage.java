package com.cybertek.myPractices.general;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class MyHTMLPage {

    @Test
    public void test(){

        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.get("file:///C:/Users/Mugetsu/Desktop/MyPage.html");
        driver.findElement(By.name("Comments")).sendKeys("ne güzel olurdu di mi");
        driver.findElement(By.name("Comments")).clear();
        driver.quit();

    }

}
