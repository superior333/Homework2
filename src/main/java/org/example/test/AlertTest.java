package org.example.test;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AlertTest extends BaseTest{
//    private static final Logger log = LogManager.getLogger(AlertTest.class);

//    Logger loggerAlert = LogManager.getLogger(AlertTest.class);

    @Test
    public void confirmTest()  {

        homePage.redirectToSection("Alerts");

        alertPage.clickPromptButton();

        Selenide.sleep(3000);
        Selenide.Wait().until(ExpectedConditions.alertIsPresent());

        final String inputText = "Sosal?";
//        log.info("test");
//        loggerAlert.info("Test words is:{}",inputText);
        String expectedText = "User value: %s".formatted(inputText);

        alertPage.inputText(inputText);
        alertPage.confirmAlert();

        Selenide.Wait().until(ExpectedConditions.alertIsPresent());

        String actualText = alertPage.getTextFromAlert();
        alertPage.confirmAlert();


        Assert.assertEquals(actualText, expectedText);


    }
}
