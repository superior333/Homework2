package org.example.test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowsTest extends BaseTest{



    @Test
    public void multipleWindowTest(){

        WebDriver driver = WebDriverRunner.getWebDriver();

        String playGrHandle = driver.getWindowHandle();

        Selenide.switchTo().newWindow(WindowType.TAB);

       Selenide.open("https://www.google.com/");

        String googleHandle = driver.getWindowHandle();

        Set<String> browserTabs = driver.getWindowHandles();

        Selenide.switchTo().window(playGrHandle);

        Selenide.closeWindow();

//        getWebDriver().switchTo().window("File Upload") ненадежно

        System.out.println(browserTabs);
        System.out.println("Test");
    }

}
