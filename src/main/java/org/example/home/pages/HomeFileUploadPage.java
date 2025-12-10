package org.example.home.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomeFileUploadPage extends HomeBasePage{

    By uploadFileInput = By.xpath("//input[@id='browse']");
    By uploadFilesInfo = By.xpath("//div[@class='file-item']");
    By uploadFilesResult = By.xpath("//div[@class ='success-file']");


    public void uploadFile(String path){
        driver.findElement(uploadFileInput).sendKeys(path);
        driver.findElement(uploadFileInput).clear();
    }

    public String getResultRow(){
        return driver.findElement(uploadFilesResult).getText();
    }

    public List <WebElement> getUploadedFilesInfo(){
        return driver.findElements(uploadFilesInfo);
    }

    public HomeFileUploadPage(WebDriver driver, Actions actions){
        super(driver, actions);
    }
}
