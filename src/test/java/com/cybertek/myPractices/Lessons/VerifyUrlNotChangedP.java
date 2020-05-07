package com.cybertek.myPractices.Lessons;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyUrlNotChangedP {

    public static void main(String[] args) {

        /* open chrome browser
        go to http://practice.cybertekschool.com/forgot_password to an external site.
        click on Retrieve password
        verify that url did not change*/

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedUrl = driver.getCurrentUrl();

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        String actualtUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualtUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualtUrl = " + actualtUrl);
            System.out.println("expectedUrl = " + expectedUrl);
        }

        driver.quit();
    }

}
