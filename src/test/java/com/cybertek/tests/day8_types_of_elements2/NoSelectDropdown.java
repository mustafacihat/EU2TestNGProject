package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");


        WebElement dropDownElement = driver.findElement(By.id("dropdownMenuLink"));

        dropDownElement.click();

        List<WebElement> dropDownOptions = driver.findElements(By.className("dropdown-item"));




        for (WebElement dropDownOption : dropDownOptions) {
            System.out.println(dropDownOption.getText());
        }

        Thread.sleep(3000);
        //click facebook
        dropDownOptions.get(3).click();


    }
}