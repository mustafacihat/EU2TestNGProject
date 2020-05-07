package com.cybertek.tests.day9_popups_tabs_frames.testSCasesHomework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutoComplete8 {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. And click on “Autocomplete”.
        driver.findElement(By.linkText("Autocomplete")).click();
        //Step 3. Enter “United States of America” into country input box.
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div#myCountryautocomplete-list")).click();
        //Step 4. Verify that following message is displayed:“You selected: United States of America”
        driver.findElement(By.cssSelector("input[type='button']")).click();
        String actualMessage = driver.findElement(By.id("result")).getText();
        String expectedMessage = "You selected: United States of America";
        Assert.assertEquals(expectedMessage,actualMessage,"verify that following message is displayed: You selected: United States of America");
    }
}
