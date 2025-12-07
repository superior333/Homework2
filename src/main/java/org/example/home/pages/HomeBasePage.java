package org.example.home.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomeBasePage {

    protected WebDriver driver;
    protected Actions actions;

    HomeBasePage(WebDriver driver, Actions actions){
        this.driver = driver;
        this.actions = actions;
    }
}
