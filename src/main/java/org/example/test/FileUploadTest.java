package org.example.test;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest{


    @Test
    public void uploadTest(){
        homePage.redirectToSection("File Upload");

        Selenide.switchTo().frame(0);

        File file = new File("src/main/resources/FileToUpload.txt");
        fileUploadPage.uploadFile(file);

    }

}
