package org.example.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Calendar;

public class AlertTest extends BaseTest{


    @Test
    public void confirmTest() throws InterruptedException {

        homePage.redirectToSection("Alerts");

        alertPage.clickPromptButton();

        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());

        final String inputText = "Sosal?";
        String expectedText = "User value: %s".formatted(inputText);

        alertPage.inputText(inputText);
        alertPage.confirmAlert();

        wait.until(ExpectedConditions.alertIsPresent());

        String actualText = alertPage.getTextFromAlert();
        alertPage.confirmAlert();

        Assert.assertEquals(actualText, expectedText);

//        Calendar.getAvailableLocales().g
    }
}
