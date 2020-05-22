package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarEventsInfoPage extends BasePage {


    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    public WebElement title;

    @FindBy(xpath = "//div[@class='control-label html-property']/p")
    public WebElement description;

    @FindBy(xpath = "(//div[@class='control-label'])[2]")
    public WebElement start;

    @FindBy(xpath = "(//div[@class='control-label'])[3]")
    public WebElement end;

    @FindBy(xpath = "(//div[@class='control-label'])[4]")
    public WebElement allDayEvent;

    @FindBy(xpath = "(//div[@class='control-label'])[5]//a")
    public WebElement organizer;

    @FindBy(xpath = "(//div[@class='control-label'])[6]//a")
    public WebElement guest;

    @FindBy(xpath = "(//div[@class='control-label'])[7]")
    public WebElement recurrence;

    @FindBy(xpath = "(//div[@class='control-label'])[8]")
    public WebElement callViaHangout;




}
