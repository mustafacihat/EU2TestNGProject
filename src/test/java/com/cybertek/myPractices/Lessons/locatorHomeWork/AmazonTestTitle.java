package com.cybertek.myPractices.Lessons.locatorHomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTestTitle {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https:www.amazon.com");
        Thread.sleep(3000);
        String amazonSearchWord = "computers".toLowerCase();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(amazonSearchWord);

        WebElement searchSubmit = driver.findElement(By.xpath("//input[@value='Go']"));
        searchSubmit.click();
        String amazonTitle = driver.getTitle();

        System.out.print("The result of Amazon test for title : ");
        if (amazonTitle.toLowerCase().contains(amazonSearchWord)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("amazonTitle = " + amazonTitle);
            System.out.println("amazonSearchWord = " + amazonSearchWord);
        }
        driver.quit();

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com");

        Thread.sleep(3000);
        String ebaySearchWord = "medicine".toLowerCase();
        driver.findElement(By.id("gh-ac")).sendKeys(ebaySearchWord);
        WebElement searchSubmit1 = driver.findElement(By.id("gh-btn"));
        searchSubmit1.click();
        String ebayTitle = driver.getTitle();

        System.out.print("The result of Ebay test for title : ");
        if (ebayTitle.toLowerCase().contains(ebaySearchWord)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("amazonTitle = " + ebayTitle);
            System.out.println("amazonSearchWord = " + ebaySearchWord);
        }
        driver.quit();



    }
}
