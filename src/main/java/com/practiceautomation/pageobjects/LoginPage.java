package com.practiceautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    private final By usernameFieldLocator = By.id("username");
    private final By passwordFieldLocator = By.id("password");
    private final By submitButtonLocator = By.id("submit");
    private final By errorMessageLocator = By.id("error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void visit(){
        super.visit("https://practicetestautomation.com/practice-test-login/");
    }

    public void enterUsername(String username){
        driver.findElement(usernameFieldLocator).sendKeys(username);

    }

    public void enterPassword(String password){
        driver.findElement(passwordFieldLocator).sendKeys(password);

    }

    public void clickSubmitButton(){
        driver.findElement(submitButtonLocator).click();

    }
    public SuccessfulLoginPage executeLogin(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickSubmitButton();
        return new SuccessfulLoginPage(driver);
    }

    public String getErrorMessage(){
        return waitForElement(errorMessageLocator).getText();
    }
}
