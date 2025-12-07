package org.example.test;

import com.google.errorprone.annotations.concurrent.LazyInit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.AlertPage;
import org.example.pages.HomePage;
import org.example.pages.MouseOverPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public abstract class BaseTest {

    protected Properties runProperties;
    protected HomePage homePage = new HomePage(getWebDriver(),getActions());
    protected MouseOverPage mouseOverPage = new MouseOverPage(getWebDriver(),getActions());
    protected AlertPage alertPage = new AlertPage(getWebDriver(), getActions());


    private static WebDriver driver;
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
