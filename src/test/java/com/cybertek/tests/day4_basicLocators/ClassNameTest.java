package com.cybertek.tests.day4_basicLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassNameTest {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/sign_up");


        WebElement homeLink = driver.findElement(By.className("nav-link"));
        homeLink.click();

       driver.get("http://practice.cybertekschool.com/multiple_buttons");

        System.out.println(driver.findElement(By.className("h3")).getText());



    }
}
