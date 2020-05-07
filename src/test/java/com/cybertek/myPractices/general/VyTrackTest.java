package com.cybertek.myPractices.general;

import com.cybertek.tests.day12_actions_jsexecutor.ActionsTest;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VyTrackTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }


    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }


    @Test
    public void test1() throws InterruptedException {
        driver.get("https://qa1.vytrack.com/");

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager71");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(5000);

        WebElement systemButton = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[8]"));
        WebElement userManagement = driver.findElement(By.xpath("//span[.='User Management']"));
        WebElement businessUnit = driver.findElement(By.xpath("//span[.='Business Units']"));
        Actions actions = new Actions(driver);

        actions.moveToElement(systemButton);
        actions.moveToElement(userManagement).perform();
        actions.moveToElement(businessUnit).click().perform();
        //businessUnit.click();






    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://qa1.vytrack.com/");

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager71");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(5000);

        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        WebElement vehiclesModel = driver.findElement(By.xpath("//span[.='Vehicles Model']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(fleet).perform();
        actions.moveToElement(vehiclesModel).click().perform();
        WebElement createVehiclesModelButton = driver.findElement(By.xpath("//a[@title='Create Vehicles Model']"));
        Thread.sleep(2000);
        actions.moveToElement(createVehiclesModelButton).click().perform();

        WebElement dropDownElement = driver.findElement(By.cssSelector("select[id^='custom_entity_type_Canbereque']"));

        Select firstDropDown = new Select(dropDownElement);

        firstDropDown.selectByVisibleText("Yes");

        System.out.println(firstDropDown.getFirstSelectedOption().getText());

        WebElement dropDownElement2 = driver.findElement(By.cssSelector("select[id^='custom_entity_type_FuelType']"));

        Select fuelTypeDropDown = new Select(dropDownElement2);

        fuelTypeDropDown.selectByIndex(2);
        System.out.println(fuelTypeDropDown.getFirstSelectedOption().getText());



    }
}