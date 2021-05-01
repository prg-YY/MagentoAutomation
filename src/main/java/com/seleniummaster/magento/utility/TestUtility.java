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

    public TestUtility(WebDriver driver) {
        super(driver);
    }

    //method for explicit wait visible elements
    public static void waitForElementPresent(WebElement element) {
        int timeout = Integer.parseInt(prop.getProperty("timeout"));
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //screen shot
    public void captureImage(String filename) {
        DateTime dateTime = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd-HH-mm-ss-SSS");
        String timeStamp = dateTime.toString(formatter);

        File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String imageFolder = prop.getProperty("imageFolder");
            FileUtils.copyFile(imageFile, new File(imageFolder + File.separator + filename
                    + "-" + timeStamp + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitForAlertPresent(WebElement firstNameField) {
        int timeout = 0;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.alertIsPresent());
    }

}
