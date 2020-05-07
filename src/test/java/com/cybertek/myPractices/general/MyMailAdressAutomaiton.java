package com.cybertek.myPractices.general;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyMailAdressAutomaiton {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

        WebElement emailInput = driver.findElement(By.name("identifier"));
        emailInput.sendKeys("hizarcifaik.1906@gmail.com");



        String value = emailInput.getAttribute("value");
        System.out.println("value = " + value);

        WebElement submitButton = driver.findElement(By.id("identifierNext"));
        submitButton.click();
        WebElement text = driver.findElement(By.id("headingText"));
        String text1 = text.getText();
        System.out.println(text1);



    }
}
