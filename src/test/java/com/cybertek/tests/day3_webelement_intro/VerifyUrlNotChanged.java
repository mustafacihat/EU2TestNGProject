package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlNotChanged {

    public static void main(String[] args) {

       /* open chrome browser
        go to http://practice.cybertekschool.com/forgot_password to an external site.
        click on Retrieve password
        verify that url did not change*/

        //I opened chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // go to the this website
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save url before we click retrieve password button
        String expectedtUrl = driver.getCurrentUrl();

        //click on Retrieve password
        //WebElement --> Interface that represent elements on the webpage
        //findElement-->method used to find element on a webpage
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        //click()--> clicking web element
        retrievePasswordButton.click();


        //verify that url did not change

        //we save the url after we click button
        String actualUrl = driver.getCurrentUrl();

        String result = expectedtUrl.equalsIgnoreCase(actualUrl)?"PASS":"FAIL";

        System.out.println(result);

       /* if (expectedtUrl.equalsIgnoreCase(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }*/

       //close browser after everything
        driver.quit();

    }
}
