package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class GoogleTest {

    WebDriver driver;

    @BeforeClass
    public WebDriver prepare(){
        System.setProperty("webdriver.chrome.driver","D:\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        return driver;
    }

    @AfterMethod
    public void shutDown(){
        driver.quit();
    }

    @Test
    public void googleSearchTest(){
        String expectedHeader = "Уточки";
        driver.get("https://google.com/");

        By searchInput = By.xpath("//div[@class='a4bIc']/textarea");
        By searchButtonLoc = By.xpath("//div[@class='lJ9FBc']/center/input[@value = 'Поиск в Google']");

        WebElement search = driver.findElement(searchInput);

        search.sendKeys("уточки");

        driver.findElement(searchButtonLoc)
                .click();

        System.out.println("");

        By resultSet = By.xpath("//a/h3");

        List<WebElement> searchList = driver.findElements(resultSet);

        WebElement target = searchList.stream().filter(el -> el.getText().equals(expectedHeader)).findAny().orElseThrow();

        Assert.assertEquals(target.getText(),expectedHeader);

        target.findElement(By.xpath("./..")).click();

        System.out.println("");

    }
}
