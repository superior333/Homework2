package org.example.test;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowsTest extends BaseTest{


    @Test
    public void multipleWindowTest(){

        String playGrHandle = getWebDriver().getWindowHandle();

        getWebDriver().switchTo().newWindow(WindowType.TAB);

        getWebDriver().get("https://www.google.com/");

        String googleHandle = getWebDriver().getWindowHandle();

        Set<String> browserTabs = getWebDriver().getWindowHandles();

        getWebDriver().switchTo().window(playGrHandle);

        getWebDriver().close();

//        getWebDriver().switchTo().window("File Upload") ненадежно

        System.out.println(browserTabs);
        System.out.println("Test");
    }

}
