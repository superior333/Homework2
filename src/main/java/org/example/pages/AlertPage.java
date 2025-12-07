package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertPage extends BasePage {

    By promptButton = By.xpath("//button[@id ='promptButton']");

    public void clickPromptButton(){
        driver.findElement(promptButton).click();
    }

    public void confirmAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public String getTextFromAlert(){
        return driver.switchTo().alert().getText();
    }

    public void inputText(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public AlertPage(WebDriver driver, Actions actions){
        super(driver, actions);
    }

}
