package org.example.home.test;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeAlertTest extends HomeBaseTest {

    @Test
    public void touchTest() {

        boolean result;

        homeHomePage.redirectToSectionHome("Alerts");

        homeAlertPage.clickConfirmButton();

        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());


        final String exportText = homeAlertPage.getTextFromAlert();
        String dayToday = homeAlertPage.dayToday();
        String testDay = "Friday";

        if (exportText.contains(dayToday)){
            homeAlertPage.confirmAlert();
            System.out.printf(("Today is %s"), dayToday);
            result = true;
        }else {
            homeAlertPage.dismissAlert();
            System.out.println("Wrong day of the week in alert");
            result = false;
        }

        Assert.assertTrue(result);

        closeBrowser();
    }
}
