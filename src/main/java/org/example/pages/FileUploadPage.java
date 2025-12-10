package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploadPage extends BasePage{

    By uploadFileInput = By.xpath("//input[@id='browse']");


    public void uploadFile(String path){
        driver.findElement(uploadFileInput).sendKeys(path);
    }

    public FileUploadPage(WebDriver driver, Actions actions){
        super(driver, actions);
    }
}
