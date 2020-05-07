package com.cybertek.myPractices.Lessons;

import com.cybertek.utilities.WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessageP {

    public static void main(String[] args) {
        /*  Verify confirmation message
        open browser
        go to http://practice.cybertekschool.com/forgot_password to an external site.
        enter any email
        verify that email is displayed in the input box
        click on Retrieve password
        verify that confirmation message says 'Your e-mail's been sent!'*/

        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedEmail= "test@gmail.com";
        WebElement emailInputBox= driver.findElement(By.name("email"));
        emailInputBox.sendKeys(expectedEmail);
        String actualEmail = emailInputBox.getAttribute("value");

        if (actualEmail.equals(expectedEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("expectedEmail = " + expectedEmail);
        }



        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));
        String actualMessage = actualConfirmationMessage.getText();
        String expectedMessage = "Your e-mail's been sent!";
        
        if (actualMessage.equals(expectedMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        }
        


    }
}
