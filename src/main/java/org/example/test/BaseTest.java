package org.example.test;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.example.listeners.TestListener;
import org.example.pages.*;

import org.openqa.selenium.OutputType;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;


@Listeners(TestListener.class)
public abstract class BaseTest {

    protected Properties runProperties;
    protected HomePage homePage = new HomePage();
    protected MouseOverPage mouseOverPage = new MouseOverPage();
    protected AlertPage alertPage = new AlertPage();
    protected FileUploadPage fileUploadPage = new FileUploadPage();
    protected DynamicTablePage dynamicTablePage = new DynamicTablePage();
    protected AjaxPage ajaxPage = new AjaxPage();
    protected SampleAppPage sampleAppPage = new SampleAppPage();


    @BeforeClass
    public void openBasePage(){
        try{
            setProperties();
        }catch (IOException e){
            e.printStackTrace();
        }
        Selenide.open(runProperties.getProperty("baseUrl"));
    }

    public static void getScreenshot(){
        byte[] bytes =Selenide.screenshot(OutputType.BYTES);
        if(bytes!=null){
            Allure.addAttachment("Screen","image/png", new ByteArrayInputStream(bytes),".png");
        }else {
            System.out.println("Не удалось сделать скриншот");
        }
    }


    public void setProperties() throws IOException {
        runProperties = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/properties.properties");
        runProperties.load(fis);
        fis.close();
    }

}
