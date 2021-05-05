package com.seleniummaster.magento.utility;


import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;


public class TestUtility extends TestBasePage {



    private final int timeout=Integer.parseInt(ApplicationConfig
            .readConfigProperties("config.properties","timeout"));

   private final WebDriver driver;
    public TestUtility(WebDriver driver){
        this.driver=driver;
    }
    public void waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void sleep(int seconds){
        try {
            Thread.sleep(seconds* 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void waitForAlertPresent(){
        WebDriverWait wait=new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.alertIsPresent());

    }

    public void takeScreenShot(String FileName, WebDriver driver){
        DateTime date=new DateTime();
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyy-MM-dd-HH-mm-ss-SS");
        String timeStamp=date.toString(formatter);
        FileName=FileName+"."+timeStamp;

        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File screenShotFile=screenshot.getScreenshotAs(OutputType.FILE);
        String folder= ApplicationConfig.readConfigProperties("config.properties",
                "imagefolder");
        File finalFile=new File(folder+File.separator+FileName+".png");
        try {
            FileUtils.copyFile(screenShotFile,finalFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
