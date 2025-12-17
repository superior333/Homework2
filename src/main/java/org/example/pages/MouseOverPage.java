package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$x;

public class MouseOverPage extends BasePage{

    private SelenideElement clickMeButton = $x("//div/a[text()= 'Click me']");
    private SelenideElement clickButtonCounter = $x("//span[@id='clickCount']");


    @Step("Наводим мышь на элемент")
    public void hoverClickMeButton(){
        clickMeButton.hover();
    }

    @Step("Получаем значение счетчика нажатий")
    public String getClickCount(){
        return clickButtonCounter.getText();
    }

    @Step("Выполняем двойное нажатие")
    public void doubleClick(int clickCount){
        for(int i = 0; i < clickCount; i++) {
            clickMeButton.doubleClick();
        }
    }

    @Step("Получаем значение атрибута")
    public String getClickMeAttribute(String attributeName){
        return clickMeButton.getAttribute(attributeName);
    }
}
