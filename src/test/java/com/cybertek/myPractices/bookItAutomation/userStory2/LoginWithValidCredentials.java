package com.cybertek.myPractices.bookItAutomation.userStory2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginWithValidCredentials {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://cybertek-reservation-qa4.herokuapp.com/sign-in");

        driver.findElement(By.xpath("//p/input")).sendKeys("gwilloway8t@nih.gov");
        driver.findElement((By.xpath("(//p/input)[2]"))).sendKeys("morrievondrach");
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'sign')]"));
        submitButton.click();
        Thread.sleep(5000);

        String currentUrl = driver.getCurrentUrl();

        String expectedUrl = "https://cybertek-reservation-qa4.herokuapp.com/map";

        if (currentUrl.equals(expectedUrl)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expectedUrl = " + expectedUrl);
            System.out.println("currentUrl = " + currentUrl);
        }


        driver.quit();

        driver = WebDriverFactory.getDriver("Chrome");


        driver.get("https://cybertek-reservation-qa4.herokuapp.com/sign-in");

        driver.findElement(By.xpath("//p/input")).sendKeys("bmurkus8q@psu.edu");
        driver.findElement((By.xpath("(//p/input)[2]"))).sendKeys("alicasanbroke");
        WebElement submitButton1 = driver.findElement(By.xpath("//button[contains(text(),'sign')]"));
        submitButton1.click();
        Thread.sleep(5000);

        String currentUrl1 = driver.getCurrentUrl();

        String expectedUrl1 = "https://cybertek-reservation-qa4.herokuapp.com/map";

        if (currentUrl1.equals(expectedUrl1)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expectedUrl1 = " + expectedUrl1);
            System.out.println("currentUrl1 = " + currentUrl1);
        }


        driver.quit();


        driver = WebDriverFactory.getDriver("Chrome");


        driver.get("https://cybertek-reservation-qa4.herokuapp.com/sign-in");

        driver.findElement(By.xpath("//p/input")).sendKeys("teachervamikemarcus@gmail.com");
        driver.findElement((By.xpath("(//p/input)[2]"))).sendKeys("mikemarcus");
        WebElement submitButton2 = driver.findElement(By.xpath("//button[contains(text(),'sign')]"));
        submitButton2.click();
        Thread.sleep(5000);

        String currentUrl2 = driver.getCurrentUrl();

        String expectedUrl2 = "https://cybertek-reservation-qa4.herokuapp.com/map";

        if (currentUrl2.equals(expectedUrl2)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expectedUrl2 = " + expectedUrl2);
            System.out.println("currentUrl2 = " + currentUrl2);
        }


        driver.quit();


    }
}
