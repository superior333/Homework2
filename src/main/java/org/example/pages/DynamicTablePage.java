package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;


import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DynamicTablePage extends BasePage{

    private SelenideElement cpuValue = $x("//p[@class='bg-warning']");
    private ElementsCollection columnHeaders = $$x("//span[@role='columnheader']");
    private SelenideElement chromeRow = $x("//span[text()='Chrome']/..");

    @Step("Получаем значение CPU")
    public String getCpuValue(){
        return cpuValue.getText();
    }

    @Step("Получаем заголовки элементов")
    public ElementsCollection getHeaders(){
        return columnHeaders;
    }

    @Step("Получаем строку с Chrome")
    public WebElement getChromeRow(){
        return chromeRow;
    }
}
