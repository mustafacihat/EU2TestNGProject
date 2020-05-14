package com.cybertek.myPractices.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TablesReview {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");

    }


    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }


    @Test
    public void printTable() throws InterruptedException {


        WebElement table = driver.findElement(By.id("table2"));
        Thread.sleep(4000);
        System.out.println(table.getText());
    }

    @Test
    public void getAllHeaders(){
        List<WebElement> headers = driver.findElements(By.xpath("//table[2]//tr/th"));

        System.out.println(headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

    }

    @Test
    public void printTableSize(){

        List<WebElement> headers = driver.findElements(By.xpath("//table[2]//tr/th"));

        System.out.println(headers.size());

        //the number of rows with head

        List<WebElement> rowsWithHead = driver.findElements(By.xpath("//table[2]//tr"));
        System.out.println("rowsWithHead.size() = " + rowsWithHead.size());


        //the number of rows without head

        List<WebElement> rowsWithoutHead = driver.findElements(By.xpath("//table[2]//tbody/tr"));
        System.out.println("rowsWithoutHead.size() = " + rowsWithoutHead.size());


    }

    @Test
    public void getRow(){
        WebElement row2 = driver.findElement(By.xpath("//table[2]//tbody/tr[2]"));
        System.out.println(row2.getText());
        List<WebElement> allRows = driver.findElements(By.xpath("//table[2]//tbody/tr"));

        for (int i = 1; i <= allRows.size(); i++) {
            System.out.println(driver.findElement(By.xpath("//table[2]//tbody/tr["+i+"]")).getText());
        }

    }

    @Test
    public void getAllCellInOneRow(){
        List<WebElement> allRows = driver.findElements(By.xpath("//table[2]//tbody/tr[3]/td"));

        for (WebElement allRow : allRows) {
            System.out.println(allRow.getText());

        }

    }
    @Test
    public void getASingleCellByIndex(){
        List<WebElement> allRows = driver.findElements(By.xpath("//table[2]//tbody/tr[3]/td[4]"));

        for (WebElement allRow : allRows) {
            System.out.println(allRow.getText());
        }

        WebElement singleWeb = driver.findElement(By.xpath("//table[2]//tbody/tr[3]/td[4]"));
        System.out.println(singleWeb.getText());

    }

    @Test
    public void printAllCellsByIndex(){
        int columnNumber = getColumnNumber();
        int rowNumber = getRowNumber();

        for (int i = 1; i <=rowNumber ; i++) {
            for (int j = 1; j <=columnNumber ; j++) {
                WebElement single = driver.findElement(By.xpath("//table[2]//tbody/tr["+i+"]/td["+j+"]"));
                System.out.println(single.getText());

            }
            System.out.println("============================================================================");
        }
    }

    private int getRowNumber() {

        return  driver.findElements(By.xpath("//table[2]//tbody/tr")).size();

    }

    private int getColumnNumber() {
        return driver.findElements(By.xpath("//table[2]//th")).size();
    }

    @DataProvider
    public Object [] namesData(){
        return new Object[]{"John","Frank","Jason","Tim"};
    }
    @Test(dataProvider = "namesData")
    public void test10(String name){


        String path = "//table[@id='table1']//td[.='"+name+"']/../td[3]";

        WebElement element = driver.findElement(By.xpath(path));
        System.out.println(element.getText());
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//td[.='"+name+"']/../td"));


        for (int i = 1; i <= row.size(); i++) {

            System.out.println(driver.findElement(By.xpath("//table[@id='table1']//td[.='"+name+"']/../td["+i+"]")).getText());



        }
    }


}
