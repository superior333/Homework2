package org.example.home.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class HomeAlertPage extends HomeBasePage {

    By confirmButton = By.xpath("//button[@id ='confirmButton']");

    public void clickConfirmButton(){
        driver.findElement(confirmButton).click();
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

    public HomeAlertPage(WebDriver driver, Actions actions){
        super(driver, actions);
    }

    public String dayToday() {
        LocalDate today = LocalDate.now();
        return today.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

}
