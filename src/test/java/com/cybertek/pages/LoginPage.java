package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

   /* @FindAll({
            @FindBy(id = "prependedInput"),
            @FindBy(name = "_username")
    })*/
    //driver.findElement(By.id("prependedInput"));
    @FindBy(id = "prependedInput")
    public WebElement userNameInput;
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;
    @FindBy(id = "_submit")
    public WebElement loginBtn;

    public void login(String usernameStr, String passwordStr){
        userNameInput.sendKeys(usernameStr);
        passwordInput.sendKeys(passwordStr);
        loginBtn.click();
    }
}
