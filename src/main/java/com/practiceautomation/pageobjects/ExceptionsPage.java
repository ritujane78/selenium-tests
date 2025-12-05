package com.practiceautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExceptionsPage extends BasePage{
    private final By addButtonLocator = By.id("add_btn");
    By editButtonLocator = By.id("edit_btn");
    By confirmationLocator = By.id("confirmation");
    By instructionsLocator = By.id("instructions");
    By row1SaveLocator = By.xpath("//div[@id='row1']/button[@name='Save']");
    By row2SaveLocator = By.xpath("//div[@id='row2']/button[@name='Save']");
    private final By row1InputLocator = By.xpath("//div[@id='row1']/input");
    private final By row2InputLocator = By.xpath("//div[@id='row2']/input");

    public ExceptionsPage(WebDriver driver) {
        super(driver);
    }

    public void visit(){
        super.visit("https://practicetestautomation.com/practice-test-exceptions/");
    }

    public void clickButton(String button){
        WebElement givenButton = switch (button.toLowerCase()) {
            case "add" -> driver.findElement(addButtonLocator);
            case "edit" -> driver.findElement(editButtonLocator);
            default -> driver.findElement(addButtonLocator);
        };
        givenButton.click();


    }
    public boolean isRowOneDisplayedAfterWait(){
        return waitForIsDisplayed(row1InputLocator);
    }
    public boolean isRowTwoDisplayedAfterWait(){
        return waitForIsDisplayed(row2InputLocator);
    }
    public boolean isInstructionHiddenAfterWait(){
        return waitForIsInvisible(instructionsLocator);
    }

    public String getConfirmationText(){
        return waitForElement(confirmationLocator).getText();
    }
    public void enterFoodInRow1(String food){
        WebElement rowInput1 = driver.findElement(row1InputLocator);
        rowInput1.clear();
        rowInput1.sendKeys(food);
    }

    public void enterFoodInRow2(String food){
        driver.findElement(row2InputLocator).sendKeys(food);
    }

    public void row2Save(){
        driver.findElement(row2SaveLocator).click();
    }
    public void row1Save(){
        driver.findElement(row1SaveLocator).click();
    }
}
