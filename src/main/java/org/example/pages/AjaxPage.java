package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AjaxPage extends BasePage{

    private final SelenideElement ajaxButton = $x("//button[@id ='ajaxButton']");
    private final SelenideElement spinner = $x("//i[@class ='fa fa-spinner fa-spin']");
    private final ElementsCollection loadedData = $$x("//div[@id='content']/p[@class='bg-success']");

    @Step("Нажать на кнопку AJAX")
    public void startAjaxJob(){
        ajaxButton.click();
    }

    @Step("Получить элемент спиннера")
    public SelenideElement getSpinner(){
        return spinner;
    }

    @Step("Получить список загруженных данных")
    public ElementsCollection getLoadedData(){
        return loadedData;
    }


}
