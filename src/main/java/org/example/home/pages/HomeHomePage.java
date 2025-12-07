package org.example.home.pages;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class HomeHomePage extends BasePage {

    private static final String LINK_LOCATOR_PATTERN = "//h3/a[text()= '%s']";

    public void redirectToSectionHome(String sectionName){
        //     driver.findElement(By.xpath(String.format(LINK_LOCATOR_PATTERN, sectionName)));
        driver.findElement(By.xpath(LINK_LOCATOR_PATTERN.formatted(sectionName))).click();
    }

    public HomeHomePage(WebDriver driver, Actions actions){
        super(driver, actions);
    }
}
