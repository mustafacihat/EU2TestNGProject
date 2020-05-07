package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        //WebElement simpleDropDown = driver.findElement(By.id("dropdown"));


        //1,locate your dropdown just like any other webelement with unique locator
        WebElement dropDownElement = driver.findElement(By.id("state"));
        //2.create Select object by passing that element as a constructor.
        Select stateDropDown = new Select(dropDownElement);
       //getOptions --> returns all the avaliable options from the dropdownlist

        List<WebElement> options = stateDropDown.getOptions();
        System.out.println("size of the options " + options.size());
        for (WebElement option : options) {
            System.out.println(option.getText());

        }
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        //WebElement simpleDropDown = driver.findElement(By.id("dropdown"));


        //1,locate your dropdown just like any other webelement with unique locator
        WebElement dropDownElement = driver.findElement(By.id("state"));
        //2.create Select object by passing that element as a constructor.
        Select stateDropDown = new Select(dropDownElement);

        //verify that first selection is Select a state
        String expectedoption= "Select a State";
        String actualOption = stateDropDown.getFirstSelectedOption().getText();


        Assert.assertEquals(expectedoption,actualOption, "verify first selection");

        //HOW TO SELECT OPTIONS FROM DROPDOWN?
        //1.SELECT USING VISIBLE TEXT
        Thread.sleep(2000);
        stateDropDown.selectByVisibleText("Texas");
        expectedoption="Texas";
        actualOption = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(stateDropDown.getFirstSelectedOption().getText(), expectedoption);

        Thread.sleep(2000);


        //2.SELECT USING INDEX
        Thread.sleep(2000);
        stateDropDown.selectByIndex(51);


        expectedoption="Wyoming";
        actualOption = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(stateDropDown.getFirstSelectedOption().getText(), expectedoption);

        //3.SELECT BY VALUE
        Thread.sleep(2000);
        stateDropDown.selectByValue("DC");

        expectedoption="District Of Columbia";
        actualOption = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(stateDropDown.getFirstSelectedOption().getText(), expectedoption);


        driver.quit();
    }
}
