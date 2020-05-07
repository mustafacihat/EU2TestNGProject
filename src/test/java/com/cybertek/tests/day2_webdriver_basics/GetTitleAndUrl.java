package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");



        //getting title with selenium
        //first short cut to introduce local variable
        //option or ALT + ENTER + ENTER
        String title = driver.getTitle();

        //soutv + enter to print variable
        System.out.println("title = " + title);

        //gets current url of the page
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //getPageSource
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

    }
}
