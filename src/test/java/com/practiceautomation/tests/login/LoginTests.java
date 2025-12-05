package com.practiceautomation.tests.login;

import com.practiceautomation.pageobjects.LoginPage;
import com.practiceautomation.pageobjects.SuccessfulLoginPage;
import com.practiceautomation.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends BaseTest {

    @Test(groups = {"positive","regression", "smoke"})
    public void positiveLoginTeat() {
        logger.info("Starting testLogin functionality");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.visit();

        SuccessfulLoginPage successfulLoginPage = loginPage.executeLogin("student", "Password123");

        successfulLoginPage.load();

        logger.info("Verify login functionality");

        Assert.assertEquals(successfulLoginPage.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");
        Assert.assertTrue(successfulLoginPage.getPageSource().contains("Congratulations student. You successfully logged in!"));
        Assert.assertTrue(successfulLoginPage.isLogoutButtonDisplayed());

    }

    @Test(groups = {"negative","regression"})
    @Parameters({"username", "password", "expectedErrorMessage"})
    public void negativeLoginTest(String username, String password, String expectedErrorMessage) {
        logger.info("Starting negativeLoginTest functionality");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.visit();
        loginPage.executeLogin(username,password);

        Assert.assertEquals(loginPage.getErrorMessage(), expectedErrorMessage);
    }

}
