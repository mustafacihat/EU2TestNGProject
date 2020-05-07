package com.cybertek.tests.day4_basicLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInputBox = driver.findElement(By.name("full_name"));

        fullNameInputBox.sendKeys("Mike Smith");

        WebElement emailInputBox = driver.findElement(By.name("email"));

        emailInputBox.sendKeys("test@gmail");

        //proper way
        WebElement retrieveSubmitButton = driver.findElement(By.name("wooden_spoon"));
        retrieveSubmitButton.click();

        //lazy way
        //driver.findElement(By.name("wooden_spoon")).click();

        WebElement signUpMessage= driver.findElement(By.name("signup_message"));

        Thread.sleep(3000);
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage = signUpMessage.getText();

        //lazy way
        //String message = driver.findElement(By.name("signup_message")).getText();
        if (actualMessage.equals(actualMessage)){

            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("actualMessage = " + actualMessage);
        }


        driver.quit();




    }
}
