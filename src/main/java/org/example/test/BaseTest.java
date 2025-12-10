package org.example.test;

import com.google.errorprone.annotations.concurrent.LazyInit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Properties;
import java.util.Set;


public abstract class BaseTest {

    protected Properties runProperties;
    protected HomePage homePage = new HomePage(getWebDriver(),getActions());
    protected MouseOverPage mouseOverPage = new MouseOverPage(getWebDriver(),getActions());
    protected AlertPage alertPage = new AlertPage(getWebDriver(), getActions());
    protected FileUploadPage fileUploadPage = new FileUploadPage(getWebDriver(), getActions());
    protected DynamicTablePage dynamicTablePage = new DynamicTablePage(getWebDriver(), getActions());


    private static WebDriver driver;
    private static Actions actions;

    @BeforeClass
    public void openBasePage(){
        try{
            setProperties();
        }catch (IOException e){
            e.printStackTrace();
        }
        driver.get(runProperties.getProperty("baseUrl"));
    }

    @AfterSuite(alwaysRun = true)
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

    public void switchToLastOpenTab(){
        List <String> handles = driver.getWindowHandles().stream().toList();
        driver.switchTo().window(handles.get(handles.size() -1));
    }

}
