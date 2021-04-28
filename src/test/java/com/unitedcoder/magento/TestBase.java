package com.unitedcoder.magento;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    public static WebDriver driver;
    //set up driver to open browser
    public static void setUpBrowser() {
        String systemName = System.getProperty("os.name");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (systemName.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "/Users/user/webdriver/chromedriver");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        } else if (systemName.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");

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
    }
        //close the browser
        public static void closeBrowser() {
            driver.close();
            driver.quit();
        }
    }

