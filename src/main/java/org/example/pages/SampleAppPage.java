package org.example.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.awt.*;

import static com.codeborne.selenide.Selenide.$x;

public class SampleAppPage extends BasePage{

    private final SelenideElement resultLogin = $x("//label");
    private final SelenideElement inputLoginField = $x("//input[@name = 'UserName']");
    private final SelenideElement inputPasswordField = $x("//input[@name = 'Password']");
    private final SelenideElement logInButton = $x("//button[@id = 'login']");



    @Step("Получаем текст поля результатов авторизации пользователя")
    public String getTextLabel(){
        return resultLogin.getText();
    }

    @Step("Ввод текста в поле логина")
    public void setInputLoginField(String login){
        inputLoginField.sendKeys(login);
    }

    @Step("Ввод текста в поле пароля")
    public void setInputPasswordField(String password){
        inputPasswordField.sendKeys(password);
    }

    @Step("Нажимаем на кнопку \"Log In\"")
    public void pressLogIn(){
        logInButton.click();
    }

    @Step("Получаем цвет текста label")
    public String getColor(){
        String colorValue = resultLogin.getCssValue("color");
        Color colorValueHex = Color.fromString(colorValue);
        return colorValueHex.asHex();
    }
}
