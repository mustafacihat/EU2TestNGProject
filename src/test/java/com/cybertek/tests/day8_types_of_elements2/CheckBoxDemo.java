package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {

    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.cssSelector("input[type='checkbox']"));

        WebElement checkBox2 = driver.findElement(By.xpath("//input[2]"));

        //now to verify checkbox is selected or not?

        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());

        //verify checkbox 2 is not selected 2 is selected
        Assert.assertFalse(checkBox1.isSelected(), "verify checkbox1 is NOT selected");
        Assert.assertTrue(checkBox2.isSelected(), "verify checkbox2 is selected");
        //how to click check box?

        checkBox1.click();

        //verify checkboxes again

        Assert.assertTrue(checkBox1.isSelected(), "verify checkbox1 is selected");
        Assert.assertTrue(checkBox2.isSelected(), "verify checkbox2 is selected");

        checkBox2.click();

        Assert.assertTrue(checkBox1.isSelected(), "verify checkbox1 is selected");
        Assert.assertFalse(checkBox2.isSelected(), "verify checkbox2 is NOT selected");

        driver.quit();
    }
}
