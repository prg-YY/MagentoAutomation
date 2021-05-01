package com.unitedcoder.magento;

import com.seleniummaster.magento.ApplicationConfig;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class TestUtility {

    private int timeout = Integer.parseInt(ApplicationConfig
            .readConfigProperties("config.properties", "timeout"));
    private WebDriver driver;

    public TestUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenShot(String fileName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenShotFile = screenshot.getScreenshotAs(OutputType.FILE);
        String folder = ApplicationConfig.readConfigProperties("config.properties",
                "imagefolder");
        File finalFile = new File(folder + File.separator + fileName);
        try {
            FileUtils.copyFile(screenShotFile, finalFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void waitForAlertPresent(){
        WebDriverWait wait=new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public TestUtility() {
    }
}
