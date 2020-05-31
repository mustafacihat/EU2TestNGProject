package com.cybertek.tests.day15_staleTest.homeWork;

import com.cybertek.pages.CalendarEventsInfoPage;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class CalendarEventTest extends TestBase {

    @Test
    public void optionsIsDisplayed(){
        extentLogger = report.createTest("Options Is Displayed Test");
        LoginPage loginPage = new LoginPage();

        String userName = "storemanager85";
        String password = "UserUser123";


        extentLogger.info("username : " + userName);
        extentLogger.info("password : " + password);
        extentLogger.info("login as a store manager");
        loginPage.login(userName, password);

        extentLogger.info("navigate to Activities --> Calendar Events");
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        extentLogger.info("Verify Options Is Displayed");
        Assert.assertTrue(calendarEventsPage.options.isDisplayed(),"verify Options is displayed");

        extentLogger.pass("PASS: Options Is Displayed Test");


    }

    @Test
    public void pageNumberTest(){
        extentLogger = report.createTest("Page Number is equals to 1 Test");
        LoginPage loginPage = new LoginPage();

        String userName = "storemanager85";
        String password = "UserUser123";


        extentLogger.info("username : " + userName);
        extentLogger.info("password : " + password);
        extentLogger.info("login is a store manager");
        loginPage.login(userName, password);

        extentLogger.info("navigate to Activities --> Calendar Events");
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        BrowserUtils.waitForPageToLoad(10);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        String actualResult = calendarEventsPage.pageNumber.getAttribute("value");
        String expectedResult="1";
        extentLogger.info("Verify the page number is : "  +expectedResult);
        Assert.assertEquals(actualResult,expectedResult,"Verify the page number is " + expectedResult);

        extentLogger.pass("PASS: Page Number is equals to 1 Test");
    }

    @Test
    public void viewPerPageTest(){
        extentLogger = report.createTest("View Per Page equals to 25 Test");
        LoginPage loginPage = new LoginPage();

        String userName = "storemanager85";
        String password = "UserUser123";


        extentLogger.info("username : " + userName);
        extentLogger.info("password : " + password);
        extentLogger.info("login is a store manager");
        loginPage.login(userName, password);

        extentLogger.info("navigate to Activities --> Calendar Events");
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        BrowserUtils.waitForPageToLoad(10);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        String expectedViewPerPage= "25";
        String actualViewPerPage = calendarEventsPage.viewPerPage.getText();
        extentLogger.info("Verify view per page is " + expectedViewPerPage);
        Assert.assertEquals(actualViewPerPage,expectedViewPerPage,"Verify view per page is " + expectedViewPerPage);

        extentLogger.pass("PASS: View Per Page equals to 25 Test");

    }
    @Test
    public void equalsToRecordsTest(){

        extentLogger = report.createTest("Number of calendar events equal to number of records test");
        LoginPage loginPage = new LoginPage();

        String userName = "storemanager85";
        String password = "UserUser123";
        extentLogger.info("username : " + userName);
        extentLogger.info("password : " + password);
        extentLogger.info("login is a store manager");
        loginPage.login(userName, password);

        extentLogger.info("navigate to Activities --> Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        new DashboardPage().navigateToModule("Activities","Calendar Events");



        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("find the number of the total rows on grid page by page");
        String totalRowNumber = calendarEventsPage.totalRow();
        System.out.println(totalRowNumber);
        extentLogger.info("verify the total row numbers equal to record number");
        Assert.assertTrue(calendarEventsPage.record.getText().contains(totalRowNumber),"Verify the number of calendar events equal to record number");

        extentLogger.pass("PASS: Number of calendar events equal to number of records test");

    }

    @Test
    public void calendarEventsSelectedTest(){
        extentLogger = report.createTest("All calendar events were selected test");
        LoginPage loginPage = new LoginPage();

        String userName = "storemanager85";
        String password = "UserUser123";


        extentLogger.info("username : " + userName);
        extentLogger.info("password : " + password);
        extentLogger.info("login is a store manager");
        loginPage.login(userName, password);

        extentLogger.info("navigate to Activities --> Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        new DashboardPage().navigateToModule("Activities","Calendar Events");



        BrowserUtils.waitForPageToLoad(10);


        extentLogger.info("create a list to hold all grid checkbox");
        List<WebElement> checkBoxList = calendarEventsPage.allGridCheckBox();
        extentLogger.info("click on the all check box button to select all grid check boxes");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.allCheckBox.click();


        extentLogger.info("Verify that all calendar events were selected");
        for (WebElement checkBox : checkBoxList) {
            Assert.assertTrue(checkBox.isSelected(),"verify all the calendar events are selected");
        }
        extentLogger.pass("PASS: All calendar events were selected test");

    }

    @Test
    public void calendarEventInfoTest(){
        extentLogger= report.createTest("Calendar Event Information verifying test");

        LoginPage loginPage = new LoginPage();
        String userName = "storemanager85";
        String password = "UserUser123";


        extentLogger.info("username : " + userName);
        extentLogger.info("password : " + password);
        extentLogger.info("login is a store manager");
        loginPage.login(userName, password);

        extentLogger.info("navigate to Activities --> Calendar Events");
        BrowserUtils.waitForPageToLoad(10);
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        //BrowserUtils.waitForPageToLoad(10);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("click on Testers meeting title");
        calendarEventsPage.getCalendarEventTitle("Testers meeting").click();

        CalendarEventsInfoPage calendarEventsInfoPage = new CalendarEventsInfoPage();

        extentLogger.info("Verify title is " + "Testers meeting");
        Assert.assertEquals(calendarEventsInfoPage.title.getText(),"Testers meeting","Verify title is Testers meeting");

        extentLogger.info("Verify description is " + "This is a a weekly testers meeting");
        Assert.assertEquals(calendarEventsInfoPage.description.getText(),"This is a a weekly testers meeting","Verify description is This is a a weekly testers meeting");

        extentLogger.info("Verify start is " + "Nov 27, 2019, 9:30 AM");
        Assert.assertEquals(calendarEventsInfoPage.start.getText(),"Nov 27, 2019, 9:30 AM","Verify start is Nov 27, 2019, 9:30 AM");

        extentLogger.info("Verify end is " + "Nov 27, 2019, 10:30 AM");
        Assert.assertEquals(calendarEventsInfoPage.end.getText(),"Nov 27, 2019, 10:30 AM","Verify end is Nov 27, 2019, 10:30 AM");

        extentLogger.info("Verify allDayEvent is " + "No");
        Assert.assertEquals(calendarEventsInfoPage.allDayEvent.getText(),"No","Verify allDayEvent is No");

        extentLogger.info("Verify organizer is " + "Stephan Haley");
        Assert.assertEquals(calendarEventsInfoPage.organizer.getText(),"Stephan Haley","Verify organizer is Stephan Haley");

        extentLogger.info("Verify guests is " + "Tom Smith");
        Assert.assertEquals(calendarEventsInfoPage.guest.getText(),"Tom Smith","Verify guests is Testers Tom Smith");

        extentLogger.info("Verify recurrence is " + "Weekly every 1 week on Wednesday");
        Assert.assertEquals(calendarEventsInfoPage.recurrence.getText(),"Weekly every 1 week on Wednesday","Verify recurrence is Weekly every 1 week on Wednesday");

        extentLogger.info("Verify callViaHangout is " + "No");
        Assert.assertEquals(calendarEventsInfoPage.callViaHangout.getText(),"No","Verify callViaHangout is No");

        extentLogger.pass("PASS: Calendar Event Information verifying test");





    }

}
