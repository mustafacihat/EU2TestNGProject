package com.cybertek.tests.day9_popups_tabs_frames.testSCasesHomework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFile7 {

    @Test
    public void test() {
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. And click on “File Upload".
        driver.findElement(By.linkText("File Upload")).click();
        //Step 3. Upload any file with .txt extension from your computer.
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Mugetsu\\cihat.txt");
        //Step 4. Click “Upload” button.
        driver.findElement(By.id("file-submit")).click();
        //Step 5. Verify that subject is: “File Uploaded!”
        String actualText = driver.findElement(By.xpath("//h3[.='File Uploaded!']")).getText();
        String expectedText= "File Uploaded!";
        Assert.assertEquals(actualText,expectedText,"verify that the subject is: “File Uploaded! ");

        //Step 6. Verify that uploaded file name is displayed.
        Boolean isFileDisplayed = driver.findElement(By.id("uploaded-files")).isDisplayed();

        Assert.assertTrue(isFileDisplayed,"verify that uplooaded file name is displayed");
        //Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading. Run this method against “Choose File” button.

        driver.quit();
    }


}
