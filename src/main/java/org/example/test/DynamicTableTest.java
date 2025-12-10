package org.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicTableTest extends BaseTest{


    @Test
    public void tableTest(){

        homePage.redirectToSection("Dynamic Table");

        String expectedValue = dynamicTablePage.getCpuValue();

        List<WebElement> actualHeaders = dynamicTablePage.getHeaders();

        int cpuIndex = 0;

        for (int  i = 0; i<actualHeaders.size(); i++){
            String header = actualHeaders.get(i).getText();
            if(header.equals("CPU")){
                cpuIndex = i;
                break;
            }
        }

        String tableValue = dynamicTablePage.getChromeRow()
                .findElements(By.xpath("./span"))
                .get(cpuIndex)
                .getText();

        Assert.assertEquals(expectedValue,"Chrome CPU: %s".formatted(tableValue));
    }

}
