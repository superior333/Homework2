package org.example.home.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomeTextInputPage extends HomeBasePage{



    By mainButton = By.xpath("//button[@id ='updatingButton']");
    By textField = By.xpath("//input[@id ='newButtonName']");

    public void clickMainButton (){
        driver.findElement(mainButton).click();
    }

    public void clearField (){
        driver.findElement(textField).clear();
    }

    public String setText (String text){
        driver.findElement(textField).sendKeys(text);
        return text;
    }

    public String getAttribute(){
        return driver.findElement(mainButton).getText();
    }

    public HomeTextInputPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }
}
