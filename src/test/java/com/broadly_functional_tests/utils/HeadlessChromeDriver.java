package com.broadly_functional_tests.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeDriver {
    public static WebDriver driver;

    private static ChromeOptions getOptions() {
        String headlessEnv = System.getProperty("headless", "false");
        boolean headless = Boolean.parseBoolean(headlessEnv);
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--remote-debugging-pipe");
        }
        return options;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = getOptions();
            driver = new ChromeDriver(options);
        }
        return driver;
    }
    
    public static WebDriver getDriver(Boolean isMobile) {
        if (driver == null) {
            ChromeOptions options = getOptions();
            if (isMobile) {
                options.addArguments("--window-size=375,1080");
            }
            driver = new ChromeDriver(options);
        }
        return driver;
    }
    
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}