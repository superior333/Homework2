package org.example.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$x;

public class AlertPage extends BasePage {

    SelenideElement promptButton = $x("//button[@id ='promptButton']");

    @Step("Нажать на кнопку Prompt")
    public void clickPromptButton(){
        promptButton.click();
    }

    @Step("Принять алерт")
    public void confirmAlert(){
        Selenide.switchTo().alert().accept();
    }

    public void dismissAlert(){
        Selenide.switchTo().alert().dismiss();
    }

    @Step("Получить текст из алерта")
    public String getTextFromAlert(){
        return Selenide.switchTo().alert().getText();
    }

    @Step("Ввести текст алерта")
    public void inputText(String text){
        Selenide.switchTo().alert().sendKeys(text);
    }


}
