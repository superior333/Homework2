package org.example.home.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.home.pages.HomeAlertPage;
import org.example.home.pages.HomeBasePage;
import org.example.home.pages.HomeHomePage;
import org.example.home.pages.HomeTextInputPage;
import org.example.pages.AlertPage;
import org.example.pages.HomePage;
import org.example.pages.MouseOverPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HomeBaseTest {

    protected Properties runProperties;
    protected HomeHomePage homeHomePage = new HomeHomePage(getWebDriver(),getActions());
    protected MouseOverPage mouseOverPage = new MouseOverPage(getWebDriver(),getActions());
    protected HomeAlertPage homeAlertPage = new HomeAlertPage(getWebDriver(), getActions());
    protected HomeTextInputPage homeTextInputPage = new HomeTextInputPage(getWebDriver(),getActions());


    public static WebDriver driver;
    private static Actions actions;

    @BeforeClass
    public void openBasePage(){
        driver.get(runProperties.getProperty("baseUrl"));
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


    public static WebDriver getWebDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        }else {
            return driver;
        }

    }


    public static Actions getActions(){
        if(actions == null){
            return new Actions(getWebDriver());
        }else {
            return actions;
        }
    }

    @BeforeSuite
    public void setProperties() throws IOException {
        runProperties = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/properties.properties");
        runProperties.load(fis);
        fis.close();
    }
}
