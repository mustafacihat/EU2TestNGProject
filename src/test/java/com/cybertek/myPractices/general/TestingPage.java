package com.cybertek.myPractices.general;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestingPage {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");
        driver.findElement(By.id("cookieChoiceDismiss")).click();

        WebElement dropDownList = driver.findElement(By.xpath("(//select)[2]"));

        Select elements = new Select(dropDownList);

        List<WebElement> options = elements.getOptions();


        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        elements.selectByVisibleText("USA");
        WebElement firstSelectedOption = elements.getFirstSelectedOption();
        System.out.println(firstSelectedOption.getText());

        List<WebElement> allSelectedOptions = elements.getAllSelectedOptions();
        for (int i = 0; i < allSelectedOptions.size(); i++) {
            System.out.println("allSelectedOptions = " + allSelectedOptions.get(i).getText());
        }

        WebElement element = driver.findElement(By.xpath("//input[@type='button']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();


    }

    @Test
    public void test2() {
        driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");
        driver.findElement(By.id("cookieChoiceDismiss")).click();


        WebElement nameBox = driver.findElement(By.id("text1"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        String str = "cihat";
        jse.executeScript("arguments[0].setAttribute('value', '" + str + "')", nameBox);

        WebElement lastNameBox = driver.findElement(By.id("text2"));

        str = "yapıcı";
        jse.executeScript("arguments[0].setAttribute('value', '" + str + "')", lastNameBox);


        WebElement hiddenBox = driver.findElement(By.id("text3"));

        str = "hidden";
        jse.executeScript("arguments[0].setAttribute('value', '" + str + "')", hiddenBox);
    }


}
