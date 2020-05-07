package com.cybertek.myPractices.Lessons;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlChangedP {
    public static void main(String[] args) {
         /*Verify URL changed
        open browser
        go to http://practice.cybertekschool.com/forgot_password to an external site.
        enter any email
        click on Retrieve password
        verify that url changed to http://practice.cybertekschool.com/email_sent */


        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        Faker faker = new Faker();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(faker.internet().emailAddress());
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl= "http://practice.cybertekschool.com/email_sent";

        if (actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualUrl = " + actualUrl);
            System.out.println("expectedUrl = " + expectedUrl);
        }


        driver.quit();


    }


}
