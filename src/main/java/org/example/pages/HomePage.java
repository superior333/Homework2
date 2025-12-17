package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage {

    private static final String LINK_LOCATOR_PATTERN = "//h3/a[text()= '%s']";

    @Step("Переход на страницу {sectionName}")
    public void redirectToSection(String sectionName){
        $x(LINK_LOCATOR_PATTERN.formatted(sectionName)).click();
    }


}
