package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;

public class DynamicIDPage extends BasePage{


    @FindBy(xpath = "//button[@class = 'btn btn-primary']")
    private SelenideElement dynamicIdButton = $x("//button[@class = 'btn btn-primary']");


}
