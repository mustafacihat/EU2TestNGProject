package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {


   /* Test case
    Open browser
    Login as a Driver
    Verify that page subtitle is Quick Launchpad
    Go to Activities -> Calendar Events
    verify that page subtitle is Calendar Events*/


    @Test
    public void test1() {
        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();
        //Same thing with thread.sleep(3000)
        BrowserUtils.waitFor(3);

        DashboardPage dashboardPage = new DashboardPage();

        String expectedSubtitle = "Quick Launchpad";
        String actualSubtitle = dashboardPage.getPageSubTitle();
        Assert.assertEquals(actualSubtitle, expectedSubtitle,"verify the subtitle is Quick Launchpad");

    }

    @Test
    public void test2(){
        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();
        //Same thing with thread.sleep(3000)
        BrowserUtils.waitFor(3);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitFor(3);
        String expectedSubtitle = "Calendar Events";
        String actualSubtitle = dashboardPage.getPageSubTitle();
        Assert.assertEquals(actualSubtitle, expectedSubtitle,"verify the subtitle is Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(3);
        Assert.assertEquals(actualSubtitle, expectedSubtitle,"verify the subtitle is Calendar Events");

    }

    @Test
    public void test3(){
        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();
        //Same thing with thread.sleep(3000)
        BrowserUtils.waitFor(3);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(5);
        String expectedSubtitle = "Calendar Events";
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(), expectedSubtitle,"verify the subtitle is Calendar Events");
    }

    @Test
    public void test4(){
        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();
        //Same thing with thread.sleep(3000)
        //BrowserUtils.waitFor(2);
        DashboardPage dashboardPage = new DashboardPage();

        String expectedSubtitle = "Quick Launchpad";

        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle,"verify subtitles");

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(2);

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","verify subtitles");



    }



}
