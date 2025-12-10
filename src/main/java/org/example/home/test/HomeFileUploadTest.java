package org.example.home.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class HomeFileUploadTest extends HomeBaseTest {

    @Test
    public void uploadTest(){
        homeHomePage.redirectToSectionHome("File Upload");

        getWebDriver().switchTo().frame(0);

        File file1 = new File("src/main/resources/HomeFileUpload1.txt");

        File file2 = new File("src/main/resources/HomeFileUpload2.txt");

        homeFileUploadPage.uploadFile(file1.getAbsolutePath());

        homeFileUploadPage.uploadFile(file2.getAbsolutePath());

        List<WebElement> uploadedFiles = homeFileUploadPage.getUploadedFilesInfo();

        int uploadedRows = uploadedFiles.size();

        System.out.println(uploadedRows);

        String resultInfo = homeFileUploadPage.getResultRow();




        System.out.println("test");
    }
}
