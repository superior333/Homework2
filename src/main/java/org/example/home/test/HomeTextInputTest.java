package org.example.home.test;


import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTextInputTest extends HomeBaseTest{

    @Test
    public void textInputTest() {

        homeHomePage.redirectToSectionHome("Text Input");

        homeTextInputPage.getAttribute();

        homeTextInputPage.clearField();

        String newText = "Test 322";

        homeTextInputPage.setText(newText);

        homeTextInputPage.clickMainButton();

        String attributeAfterClick = homeTextInputPage.getAttribute();

        Assert.assertEquals(attributeAfterClick, newText);

        closeBrowser();
    }
}
