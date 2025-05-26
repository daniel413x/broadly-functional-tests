package com.broadly_functional_tests.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessFirefoxDriver {
    public static WebDriver driver;

    private static FirefoxOptions getOptions() {
        String headlessEnv = System.getProperty("headless", "false");
        boolean headless = Boolean.parseBoolean(headlessEnv);
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
        }
        return options;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
            FirefoxOptions options = getOptions();
            driver = new FirefoxDriver(options);
        }
        return driver;
    }

    public static WebDriver getDriver(Boolean isMobile) {
        if (driver == null) {
            System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
            FirefoxOptions options = getOptions();
            if (isMobile) {
                options.addArguments("--window-size=375,812");
            }
            driver = new FirefoxDriver(options);
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
