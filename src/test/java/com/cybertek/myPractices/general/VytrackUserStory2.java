package com.cybertek.myPractices.general;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VytrackUserStory2 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com/user/login");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testCase83() throws InterruptedException {


        driver.findElement(By.id("prependedInput")).sendKeys("storemanager71");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(5000);
        WebElement fleet = driver.findElement(By.xpath("(//*[@class='title title-level-1'])[2]"));
        WebElement vehicles = driver.findElement(By.xpath("//span[.='Vehicles']"));
        Actions actions = new Actions(driver);


        actions.moveToElement(fleet).perform();
        actions.moveToElement(vehicles).click().perform();

        Thread.sleep(5000);


        driver.findElement(By.xpath("(//li[.='Convertible'])[1]")).click();

    }

    @Test(priority = 1)
    public void testCase84() {
        driver.findElement(By.id("prependedInput")).sendKeys("johnd@gmail.com");
        driver.findElement(By.id("prependedInput2")).sendKeys("jd123");
        driver.findElement(By.id("_submit")).click();

        String actualText = driver.findElement(By.cssSelector(".alert.alert-error")).getText();
        String expected = "Invalid user name or password.";

        Assert.assertEquals(actualText, expected, "verify system should show \"Invalid user name or password.\"");
    }

    @Test(priority = 2)
    public void testCase85() throws InterruptedException {


        driver.findElement(By.id("prependedInput")).sendKeys("storemanager71");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(5000);
        WebElement fleet = driver.findElement(By.xpath("(//*[@class='title title-level-1'])[2]"));
        WebElement vehicles = driver.findElement(By.xpath("//span[.='Vehicles']"));
        Actions actions = new Actions(driver);


        actions.moveToElement(fleet).perform();
        actions.moveToElement(vehicles).click().perform();

        Thread.sleep(5000);

        driver.findElement(By.cssSelector("a[title='Create Car']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[title='Cancel']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[title='Create Car']")).click();
        Thread.sleep(5000);
        WebElement licensePlate = driver.findElement(By.cssSelector("input[id^='custom_entity_type_LicensePlate']"));
        licensePlate.sendKeys("981055");
        driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();
        driver.findElement(By.cssSelector("input[id^='custom_entity_type_Driver']")).sendKeys("anne lane");
        driver.findElement(By.xpath("//input[@data-name='field__location']")).sendKeys("Ankara");
        driver.findElement(By.xpath("//input[@data-name='field__chassis-number']")).sendKeys("12345685");
        driver.findElement(By.xpath("//input[@data-name='field__model-year']")).sendKeys("2016");
        driver.findElement(By.xpath("//input[@data-name='field__last-odometer']")).sendKeys("2019");

        //immatriculation Date
        driver.findElement(By.cssSelector("input[id^='date_selector_custom_entity_type_ImmatriculationDate']")).click();

        WebElement monthDropDown = driver.findElement(By.cssSelector(".ui-datepicker-month"));

        Select monthDropDownSelect = new Select(monthDropDown);

        monthDropDownSelect.selectByVisibleText("Jul");

        Select yearDropDownSelect = new Select(driver.findElement(By.cssSelector(".ui-datepicker-year")));

        yearDropDownSelect.selectByValue("2021");
        driver.findElement(By.xpath("//table/tbody//tr[2]/td[5]")).click();

        //FirstContract date
        driver.findElement(By.cssSelector("input[id^='date_selector_custom_entity_type_FirstContractDate']")).click();
        Select firstContractDateDropDownSelectMonth = new Select(driver.findElement(By.cssSelector(".ui-datepicker-month")));
        firstContractDateDropDownSelectMonth.selectByIndex(7);
        Select firstContractDateYear = new Select(driver.findElement(By.cssSelector(".ui-datepicker-year")));
        firstContractDateYear.selectByVisibleText("2021");
        driver.findElement(By.xpath("//table/tbody//tr[4]/td[3]")).click();

        //other boxes

        driver.findElement(By.xpath("//input[@data-name='field__catalog-value']")).sendKeys("14741");
        driver.findElement(By.xpath("//input[@data-name='field__seats-number']")).sendKeys("28");
        driver.findElement(By.xpath("//input[@data-name='field__doors-number']")).sendKeys("5");
        driver.findElement(By.xpath("//input[@data-name='field__color']")).sendKeys("yellow");

        //Transmission

        driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
        Select transmission = new Select(driver.findElement(By.xpath("(//select)[1]")));
        transmission.selectByVisibleText("Manual");

        driver.findElement(By.xpath("(//span[@class='select2-chosen'])[2]")).click();
        Select fuel = new Select(driver.findElement(By.xpath("(//select)[2]")));
        fuel.selectByIndex(3);

        driver.findElement(By.xpath("//input[@data-name='field__c-o2-emissions']")).sendKeys("175");
        driver.findElement(By.xpath("//input[@data-name='field__horsepower']")).sendKeys("1000");
        driver.findElement(By.xpath("//input[@data-name='field__horsepower-taxation']")).sendKeys("27");
        driver.findElement(By.xpath("//input[@data-name='field__power']")).sendKeys("1600");

        WebElement fileElement = driver.findElement(By.xpath("//input[@data-name='field__file']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //jse.executeScript("arguments[0].click();", fileElement);


        System.out.println("fileElement.isEnabled() = " + fileElement.isEnabled());
        fileElement.sendKeys("C:\\Users\\Mugetsu\\9850_sd.jpg");

        jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//button[@type='submit'])[1]")));


    }

    @Test(priority = 3)
    public void testCase86() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys("user30");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(5000);
        WebElement fleet = driver.findElement(By.cssSelector(".title.title-level-1"));
        WebElement vehicles = driver.findElement(By.xpath("//span[.='Vehicles']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(fleet).perform();
        actions.moveToElement(vehicles).click().perform();

    }

    @Test(priority = 4)
    public void testCase87() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager71");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(5000);
        WebElement fleet = driver.findElement(By.xpath("(//*[@class='title title-level-1'])[2]"));
        WebElement vehicles = driver.findElement(By.xpath("//span[.='Vehicles']"));
        Actions actions = new Actions(driver);


        actions.moveToElement(fleet).perform();
        actions.moveToElement(vehicles).click().perform();

        Thread.sleep(5000);

        driver.findElement(By.partialLinkText("Create Car")).click();
        driver.findElement(By.linkText("VehiclesModel")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//table//tr[14]/td[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[.='Select']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebElement make = driver.findElement(By.xpath("//table//tr[14]/td[2]"));
        Thread.sleep(3000);
        make.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[.='Select']")).click();
        WebElement submitButton = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        submitButton.click();

        WebElement lastMessage = driver.findElement(By.cssSelector("div[class='message']"));

        WebDriverWait wait = new WebDriverWait(driver, 3);

        wait.until(ExpectedConditions.visibilityOf(lastMessage));

        String actualMessage = lastMessage.getText();

        String expectedMessage = "Entity saved";

        Assert.assertEquals(actualMessage, expectedMessage, "verify this message displayed \"Entity saved\"");


    }

    @Test(priority = 5)
    public void test88() throws InterruptedException {

        driver.findElement(By.id("prependedInput")).sendKeys("user30");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(5000);
        WebElement fleet = driver.findElement(By.cssSelector(".title.title-level-1"));
        WebElement vehicles = driver.findElement(By.xpath("//span[.='Vehicles']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(fleet).perform();
        actions.moveToElement(vehicles).click().perform();


    }

    @Test(priority = 6)
    public void test89() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager71");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(5000);
        WebElement fleet = driver.findElement(By.xpath("(//*[@class='title title-level-1'])[2]"));
        WebElement vehicles = driver.findElement(By.xpath("//span[.='Vehicles']"));
        Actions actions = new Actions(driver);


        actions.moveToElement(fleet).perform();
        actions.moveToElement(vehicles).click().perform();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//table//tbody//tr[3]/td[4]")).click();
        driver.findElement(By.cssSelector("a[title='Edit Car']")).click();

        WebElement licensePlateBox = driver.findElement(By.xpath("//*[@data-name='field__license-plate']"));
        licensePlateBox.clear();
        licensePlateBox.sendKeys("100d107");


        WebElement chassisNumberBox = driver.findElement(By.xpath("//*[contains(@id,'custom_entity_type_ChassisNumber')]"));
        chassisNumberBox.clear();
        chassisNumberBox.sendKeys("789258");

        driver.findElement(By.cssSelector("a.btn-success.btn.dropdown-toggle")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//ul[@class='dropdown-menu'])[3]/li[3]"))));
        actions.moveToElement(driver.findElement(By.xpath("(//ul[@class='dropdown-menu'])[3]/li[3]"))).click().perform();

        String actualMessage = driver.findElement(By.cssSelector("div[class='message']")).getText();
        String expectedMessage = "Entity saved";

        Assert.assertEquals(actualMessage, expectedMessage, "verify the \"Entity saved\" message is displayed");

        Thread.sleep(5000);
        driver.findElement(By.cssSelector("div.pull-left.btn-group.icons-holder")).click();
        driver.findElement(By.linkText("Yes, Delete")).click();


        String actualMessage1 = driver.findElement(By.cssSelector("div[class='message']")).getText();
        String expectedMessage1 = "Car deleted";

        Assert.assertEquals(actualMessage1, expectedMessage1, "verify the \"Car deleted\" message is displayed");

    }

    @Test(priority = 7)
    public void testCase90() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys("user30");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(5000);
        WebElement fleet = driver.findElement(By.cssSelector(".title.title-level-1"));
        WebElement vehicles = driver.findElement(By.xpath("//span[.='Vehicles']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(fleet).perform();
        actions.moveToElement(vehicles).click().perform();

    }

    @Test(priority = 8)
    public void testCase91() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager71");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(5000);
        WebElement fleet = driver.findElement(By.xpath("(//*[@class='title title-level-1'])[2]"));
        WebElement vehicles = driver.findElement(By.xpath("//span[.='Vehicles']"));
        Actions actions = new Actions(driver);


        actions.moveToElement(fleet).perform();
        actions.moveToElement(vehicles).click().perform();

        Thread.sleep(10000);

        driver.findElement(By.xpath("//table//tbody//tr[3]/td[4]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='pull-right title-buttons-container']/div[3]")).click();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("input[data-name='field__title']")).sendKeys("break problem");
        WebElement frameElement = driver.findElement(By.xpath("//iframe[contains(@id,'oro_calendar_event_form_description-uid-')]"));
        driver.switchTo().frame(frameElement);

        driver.findElement(By.id("tinymce")).sendKeys("front of the car");

        driver.switchTo().parentFrame();

        driver.findElement(By.xpath("//button[.='Save']")).click();


        Thread.sleep(3000);

        String actualMessage = driver.findElement(By.cssSelector("div[class='message']")).getText();
        System.out.println(actualMessage);

        String expectedMessage = "Calendar event saved";

        Assert.assertEquals(expectedMessage, actualMessage, "verify the success message is displayed");


    }

    @Test(priority = 9)
    public void testCase92() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager71");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(10000);
        WebElement fleet = driver.findElement(By.xpath("(//*[@class='title title-level-1'])[2]"));
        WebElement vehicles = driver.findElement(By.xpath("//span[.='Vehicles']"));
        Actions actions = new Actions(driver);


        actions.moveToElement(fleet).perform();
        actions.moveToElement(vehicles).click().perform();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[.='Chassis Number']")).click();

        WebDriverWait wait = new WebDriverWait(driver,5);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//i[@class='fa-refresh'])[2]"))));
        driver.findElement(By.xpath("(//i[@class='fa-refresh'])[2]")).click();

    }

}
