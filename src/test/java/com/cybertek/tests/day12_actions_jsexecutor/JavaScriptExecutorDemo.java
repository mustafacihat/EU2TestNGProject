package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
       // driver.quit();
    }


    @Test
    public void clickWithJS() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/");

        WebElement dropDownLink = driver.findElement(By.linkText("Dropdown"));
        //clicking with JavaScriptExecutor
        //create js executor object

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //use executeScript
        jse.executeScript("arguments[0].click();",dropDownLink);



    }

    @Test
    public void type(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        //inputBox.sendKeys("Some text");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String str = "Hello disable input";
        jse.executeScript("arguments[0].value='"+str+"';", inputBox);
        //jse.executeScript("arguments[0].setAttribute('value', '" + str +"')",inputBox);


    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        Thread.sleep(2000);

        for (int i = 0; i <10 ; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scroll(0, 250);");
        }

        for (int i = 0; i <10 ; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scroll(0, -250);");
        }




    }
}
