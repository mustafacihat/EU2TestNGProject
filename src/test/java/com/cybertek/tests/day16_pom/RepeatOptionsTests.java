package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {

    /*VERIFY RADIO BUTTONS
    Open browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked
    verify that repeat weekday is not checked
    * */

    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage  = new CalendarEventsPage();
        BrowserUtils.waitFor(5);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"verify  days rb is checked");
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"verify weekday is NOT checked");

    }
    /*
VERIFY REPEAT OPTIONS
   Open browser
   Login as driver
   Go to Activities->Calendar
   Click on create calendar events
   Click on repeat checkbox
   Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
*/
    @Test
    public void test(){

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage  = new CalendarEventsPage();
        BrowserUtils.waitFor(5);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        Select repeatDropDown = createCalendarEventsPage.repeatOptionsList();

        List<WebElement> actualOptions = repeatDropDown.getOptions();

        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");

        List<String> actualList = new ArrayList<>();

        /*for (WebElement options : actualOptions) {
            actualList.add(options.getText());
        }*/

        actualList= BrowserUtils.getElementsText(actualOptions);

        Assert.assertEquals(actualList,expectedList,"verify dropdown options");


    }
}