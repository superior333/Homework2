package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class FileUploadPage extends BasePage{

    SelenideElement uploadFileInput = $x("//input[@id='browse']");

    @Step("Загружаем файл")
    public void uploadFile(File file){
        uploadFileInput.uploadFile(file);
    }

}
