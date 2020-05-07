package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {
    public static void main(String[] args) {

        //we have to enter this line everytime we want to open chrome
        //hey webdrivemanager, can you make chrome ready for me for automation.
       // WebDriverManager.chromedriver().setup();

        //WebDriver represents the browser
        //We are creating driver for chrome browser
        //new ChromeDriver()--> this part will open chrome browser
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://www.amazon.com");
        //firefox navigation

        ChromeDriver ch = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.amazon.com");


    }
}
