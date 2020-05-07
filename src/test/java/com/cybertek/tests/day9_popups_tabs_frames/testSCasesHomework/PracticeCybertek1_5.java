package com.cybertek.tests.day9_popups_tabs_frames.testSCasesHomework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeCybertek1_5 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {

        Thread.sleep(10000);
        driver.quit();

    }

    @Test
    public void testCase1() {

        //step 1 go to this web site
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //step 2 click on registration form
        driver.findElement(By.linkText("Registration Form")).click();

        //step 3 enter “wrong_dob” into date of birth input box.

        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");

        //step 4 verify that warning message is displayed:

        String actualMessage = driver.findElement(By.xpath("//small[.='The date of birth is not valid']")).getText();
        String expectedMessage = "The date of birth is not valid";

        Assert.assertEquals(expectedMessage, actualMessage, "Verify that warning message is displayed");

    }

    @Test
    public void testCase2() {

        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//a[contains(text(),'Registration')]")).click();
        //Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript

        List<WebElement> programmingLanguages = driver.findElements(By.cssSelector(".form-check.form-check-inline"));
        for (WebElement programmingLanguage : programmingLanguages) {
            Assert.assertTrue(programmingLanguage.isDisplayed(), "verify this options is displayed");
            System.out.println("text is " + programmingLanguage.getText());
        }


    }

    @Test
    public void testCase3() {

        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        //Step 3. Enter only one alphabetic character into firstname input box.
        driver.findElement(By.name("firstname")).sendKeys("C");
        //Step 4. Verify that warning message is displayed:“first name must be more than 2 and less than 64 characters long”
        String actualMessage = driver.findElement(By.xpath("//small[contains(text(),'first name m')]")).getText();
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(expectedMessage, actualMessage, "verify that the warning message is \"first name must be more than 2 and less than 64 characters long\"");
    }

    @Test
    public void testCase4(){
        //Step 1. Go to https://practice-cybertekschool.herokuapp.com
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on “Registration Form”
        driver.findElement(By.linkText("Registration Form")).click();
        //Step 3. Enter only one alphabetic character into lastname input box.
        driver.findElement(By.name("lastname")).sendKeys("Y");
        //Step 4. Verify that warning message is displayed:“The last name must be more than 2 and less than 64 characters long”
        String actualMessage = driver.findElement(By.xpath("//small[.='The last name must be more than 2 and less than 64 characters long']")).getText();
        String expectedMessage ="The last name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(expectedMessage,actualMessage,"verify that warning message is displayed");


    }

    @Test
    public void testCase5() {

        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on “Registration Form”
        driver.findElement(By.linkText("Registration Form")).click();
        //Step 3. Enter any valid first name.
        driver.findElement(By.name("firstname")).sendKeys("Michael");
        // Step 4. Enter any valid last name.
        driver.findElement(By.name("lastname")).sendKeys("JORDAN");
        //Step 5. Enter any valid user name.
        driver.findElement(By.name("username")).sendKeys("superstar");
        //Step 6.Enter any valid email address
        driver.findElement(By.name("email")).sendKeys("testtt@gmail.com");
        //Step 7. Enter any valid password.
        driver.findElement(By.name("password")).sendKeys("123456789");
        //Step 8. Enter any valid phone number.
        driver.findElement(By.name("phone")).sendKeys("123-000-1254");
        //Step 9. Select gender.
        driver.findElement(By.cssSelector("input[value='male']")).click();
        //Step 10. Enter any valid date of birth.
        driver.findElement(By.name("birthday")).sendKeys("05/05/1949");
        //Step 11. Select any department.
        WebElement departmentDropDown = driver.findElement(By.name("department"));
        Select department = new Select(departmentDropDown);
        department.selectByVisibleText("MCR");

        //Step 12. Enter any job title.
        WebElement jobTitleDropDown = driver.findElement(By.name("job_title"));
        Select jobTitle = new Select(jobTitleDropDown);
        jobTitle.selectByIndex(3);
        //Step 13. Select java as a programming language.
        driver.findElement(By.id("inlineCheckbox2")).click();
        //Step 14. Click Sign up.
        driver.findElement(By.id("wooden_spoon")).click();
        //Step 15. Verify that following success message is displayed: “You've successfully completed registration!”
        String actualMessage = driver.findElement(By.tagName("p")).getText();
        String expectedMessage = "You've successfully completed registration!";
        Assert.assertEquals(expectedMessage,actualMessage,"Verify that success message is displayed");


    }
}
