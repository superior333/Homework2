package org.example.test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AjaxTest extends BaseTest{

    @Test
    @Description("Проверка отработки AJAX запросов")
    @Epic("AUTOTEST")
    public void ajaxTest(){

        homePage.redirectToSection("AJAX Data");

        ajaxPage.startAjaxJob();

        Selenide
                .Wait().withTimeout(Duration.ofSeconds(16))
                .until(ExpectedConditions.invisibilityOf(ajaxPage.getSpinner()));

        ElementsCollection actualData = ajaxPage.getLoadedData();

        Assert.assertFalse(actualData.isEmpty());

        ajaxPage.startAjaxJob();

        Selenide
                .Wait().withTimeout(Duration.ofSeconds(16))
                .until(ExpectedConditions.invisibilityOf(ajaxPage.getSpinner()));

        ElementsCollection actualData2 = ajaxPage.getLoadedData();

        Assert.assertEquals(actualData2.size(),2);

    }
}
