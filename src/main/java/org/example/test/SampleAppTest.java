package org.example.test;

import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleAppTest extends BaseTest{

    @Test
    @Description("Проверка авторизации пользователя в Sample App")
    @Epic("AUTOTEST")
    public void sampleAppTest(){
        String login = "TestLogin";
        String password = "pwd";

        homePage.redirectToSection("Sample App");

        sampleAppPage.pressLogIn();

        String expectedText = "Invalid username/password";
        String textNull = sampleAppPage.getTextLabel();

        Assert.assertEquals(textNull,expectedText);

        sampleAppPage.setInputLoginField(login);

        sampleAppPage.pressLogIn();

        Assert.assertEquals(textNull,expectedText);

        sampleAppPage.setInputLoginField(login);

        sampleAppPage.setInputPasswordField(password);

        sampleAppPage.pressLogIn();

        String expectedTextSuccess = String.format("Welcome, %s!",login);
        String textLabel = sampleAppPage.getTextLabel();

        Assert.assertEquals(textLabel,expectedTextSuccess);

        String colorText = sampleAppPage.getColor();
        String expectedColor = "#28a745";
        Assert.assertEquals(colorText,expectedColor);

    }

}
