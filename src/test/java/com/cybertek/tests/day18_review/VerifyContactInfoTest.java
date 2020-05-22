package com.cybertek.tests.day18_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContactInfoTest extends TestBase {

    @Test
    public void contactDetailsTest() {
        extentLogger = report.createTest("Contact Info Verification");
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        extentLogger.info("Login as a Sales Manager");
        loginPage.login(username, password);

        ContactsPage contactsPage = new ContactsPage();
        extentLogger.info("Navigate to Customers -- Contacts");
        contactsPage.navigateToModule("Customers", "Contacts");
        extentLogger.info("Click on mbrackstone9@example.com email");
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactInfoPage.fullName.getText();

        extentLogger.info("Verify fullname is " + expectedFullName);
        Assert.assertEquals(actualFullName,expectedFullName,"Verify fullname");

        extentLogger.info("Verify email is " + "mbrackstone9@example.com ");
        Assert.assertEquals(contactInfoPage.email.getText(), "mbrackstone9@example.com","Verify email");

        extentLogger.info("Verify phone number is " + "+18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","Verify phone number");

        extentLogger.pass("PASS: Contact Info Test");


    }
}

