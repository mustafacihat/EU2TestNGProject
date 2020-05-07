package com.cybertek.tests.day9_popups_tabs_frames.testSCasesHomework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TempMailAddress6 {

    @Test
    public void test() throws InterruptedException {


        //Step 1. Go to "https://www.tempmailaddress.com/"
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");
        //Step 2. Copy and save email as a string.
        driver.findElement(By.linkText("Copy")).click();
        String email = driver.findElement(By.id("email")).getText();
        // Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 4. And click on “Sign Up For Mailing List".
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        //Step 5. Enter any valid name.
        driver.findElement(By.name("full_name")).sendKeys("Michael");
        //Step 6. Enter email from the Step 2.
        driver.findElement(By.name("email")).sendKeys(email);
        //Step 7. Click Sign Up
        driver.findElement(By.xpath("//button[.='Sign Up']")).click();
        //Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
        String actualMessage = driver.findElement(By.name("signup_message")).getText();
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(expectedMessage,actualMessage,"Verify that message is displayed");
        //Step 9. Navigate back to the “https://www.tempmailaddress.com/”
        driver.get("https://www.tempmailaddress.com/");
        Thread.sleep(4000);
        //Step 10. Verify that you’ve received an email from“do-not-reply@practice.cybertekschool.com”
        String actualText = driver.findElement(By.xpath("//div[@id='home']/div/table/tbody/tr[1]")).getText();
        System.out.println(actualText);
        String expectedText ="do-not-reply@practice.cybertekschool.com";
        Assert.assertTrue(actualText.contains(expectedText),"verifying that an email has been received from do-not-reply@practice.cybertekschool.com");
        //Step 11. Click on that email to open it.
        driver.findElement(By.xpath("//div[@id='home']/div/table/tbody/tr[1]")).click();
        //Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
        String actualFrom = driver.findElement(By.id("odesilatel")).getText();
        String expectedFrom = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(expectedFrom,actualFrom,"verify that email is from : do-not-reply@practice.cybertekschool.com");
        //Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
        String actualSubject = driver.findElement(By.id("predmet")).getText();
        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(expectedSubject,actualSubject,"verify that subject is : Thanks for subscribing to practice.cybertekschool.com!");

        driver.quit();
    }
}
