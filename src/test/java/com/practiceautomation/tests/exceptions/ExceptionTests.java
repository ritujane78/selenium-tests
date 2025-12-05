package com.practiceautomation.tests.exceptions;

import com.practiceautomation.pageobjects.ExceptionsPage;
import com.practiceautomation.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;



public class ExceptionTests extends BaseTest {

    @Test
    public void noSuchElementExceptionTest(){
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);

        exceptionsPage.visit();

        exceptionsPage.clickButton("add");

        Assert.assertTrue(exceptionsPage.isRowTwoDisplayedAfterWait(), "Row2 input field is not displayed");
        Assert.assertEquals(exceptionsPage.getConfirmationText(), "Row 2 was added");
    }

    @Test
    public void timeoutExceptionTest(){
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);

        exceptionsPage.visit();

        exceptionsPage.clickButton("add");

        Assert.assertTrue(exceptionsPage.isRowTwoDisplayedAfterWait(), "Row2 input field is not displayed");
        Assert.assertEquals(exceptionsPage.getConfirmationText(), "Row 2 was added");

    }
    @Test
        public void elementNotInteractableExceptionTest(){
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);

        exceptionsPage.visit();

        exceptionsPage.clickButton("add");

        Assert.assertTrue(exceptionsPage.isRowTwoDisplayedAfterWait(), "Row2 input field is not displayed");

        exceptionsPage.enterFoodInRow2("Sushi");

        exceptionsPage.row2Save();

        Assert.assertEquals(exceptionsPage.getConfirmationText(), "Row 2 was saved", "Message is not expected.");

    }
    @Test
    public void invalidElementStateExceptionTest(){
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);

        exceptionsPage.visit();

        exceptionsPage.clickButton("edit");
        exceptionsPage.enterFoodInRow1("Burger");
        exceptionsPage.row1Save();

        Assert.assertTrue(exceptionsPage.isRowOneDisplayedAfterWait(), "Row1 input field is not displayed");



    }
    @Test
    public void staleElementReferenceExceptionTest(){
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);

        exceptionsPage.visit();

        exceptionsPage.clickButton("add");
        Assert.assertTrue(exceptionsPage.isInstructionHiddenAfterWait());
    }
}
