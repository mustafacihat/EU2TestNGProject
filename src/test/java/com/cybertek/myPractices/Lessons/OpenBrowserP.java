package com.cybertek.myPractices.Lessons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowserP {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);
        driver.quit();
        driver = new ChromeDriver();
        driver.navigate().to("http://www.google.com");
        driver.close();

        driver = new ChromeDriver();
        driver.navigate().to("http://www.facebook.com");
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        String title = driver.getTitle();
        System.out.println("title = " + title);

        driver.navigate().back();
        driver.navigate().refresh();
    }
}
