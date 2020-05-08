package com.cybertek.myPractices.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownReview {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        //driver.quit();
    }

    @Test
    public void test() {



        WebElement dropdown1 = driver.findElement(By.id("dropdown"));

        Select options = new Select(dropdown1);

        System.out.println("options.getFirstSelectedOption() = " + options.getFirstSelectedOption().getText());

        List<WebElement> allOptions = options.getOptions();
        for (WebElement allOption : allOptions) {
            System.out.println(allOption.getText());
        }

        allOptions.get(2).click();


        options.selectByIndex(2);
        options.selectByVisibleText("Option 1");
        options.selectByValue("2");

    }

    @Test
    public void birthDay() {

        //select year
        WebElement dropDown1 = driver.findElement(By.id("year"));
        Select yearDD = new Select(dropDown1);
        yearDD.selectByVisibleText("1980");
        //select month
        WebElement dropDown2 = driver.findElement(By.id("month"));
        Select monthDD = new Select(dropDown2);

        monthDD.selectByIndex(1);
        //select day
        WebElement dropDown3 = driver.findElement(By.id("day"));
        Select dayDD = new Select(dropDown3);

        dayDD.selectByValue("4");

        //select Kentucky
        WebElement state = driver.findElement(By.id("state"));
        Select stateDD = new Select(state);

        stateDD.selectByValue("KY");

        System.out.println("stateDD.getFirstSelectedOption() = " + stateDD.getFirstSelectedOption().getText());

        WebElement languages = driver.findElement(By.name("Languages"));
        Select languagesDD = new Select(languages);

        List<WebElement> options = languagesDD.getOptions();

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        languagesDD.selectByIndex(3);

        System.out.println("=====================================================================");
        WebElement dropdownMenuLink = driver.findElement(By.id("dropdownMenuLink"));

        dropdownMenuLink.click();

        List<WebElement> links = driver.findElements(By.cssSelector(".dropdown-item"));
        for (WebElement link : links) {
            System.out.println(link.getText());
        }
        links.get(3).click();

    }
}
