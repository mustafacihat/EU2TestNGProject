package com.cybertek.myPractices.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptReview {


    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        //driver.quit();
    }

    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/");
        WebElement dropdown = driver.findElement(By.linkText("Dropdown"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", dropdown);




    }

    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String text= "cihat";
        jse.executeScript("arguments[0].value='"+text+"';", inputBox);
        //jse.executeScript("arguments[0].setAttribute('value', '" + text +"')",inputBox);
    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        Thread.sleep(2000);

        for (int i = 0; i <10 ; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scroll(0, 10000);");
        }

        for (int i = 0; i <10 ; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scroll(0, -250);");

/*            <button onclick="scrollWin(0, 50)">Scroll down</button>
<button onclick="scrollWin(0, -50)">Scroll up</button>
<button onclick="scrollWin(100, 0)">Scroll right</button>
<button onclick="scrollWin(-100, 0)">Scroll left</button>

<script>
                    function scrollWin(x, y) {
                window.scrollBy(x, y);
            }
</script>*/
        }



    }


}
