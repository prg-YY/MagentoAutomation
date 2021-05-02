package com.seleniummaster.magento.utility;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBasePage {
    public static WebDriver driver;
    public static Properties prop =new Properties();

    static {
        String workingDir= System.getProperty("user.dir");
        try {
            FileInputStream fileInputStream = new FileInputStream(workingDir + File.separator
                    + "config.properties");
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TestBasePage() {

    }




    //set up driver to open browser
    public static void setUpBrowser() {
        String systemName = System.getProperty("os.name");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (systemName.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "/Users/prg/Documents/chromedriver/chromedriver");
            /*
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("window-size=1920,1080");
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--allow-insecure-localhost");
             */
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        } else if (systemName.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
            /*
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("window-size=1920,1080");
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--allow-insecure-localhost");
*/

            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        } else {
            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            chromeOptions.addArguments("window-size=1920,1080");
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--allow-insecure-localhost");
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            driver = new ChromeDriver(chromeOptions);
        }
        Log.info("Browser has been setup");
    }




    //close the browser
    public static void closeBrowser() {
        driver.close();
        Log.info("Driver closed");
        driver.quit();
    }
}
