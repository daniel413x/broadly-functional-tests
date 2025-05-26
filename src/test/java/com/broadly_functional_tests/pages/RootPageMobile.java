package com.broadly_functional_tests.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.broadly_functional_tests.utils.HeadlessChromeDriver;

public class RootPageMobile {

    WebDriver driver = HeadlessChromeDriver.getDriver();
    private static final String url = System.getProperty("clientUrl", "http://localhost:3000");

    @FindBy(css = "[data-testid='navbar-menu-button']")
    private WebElement menuButton;

    @FindBy(css = "[data-testid='navbar-sidebar-content']")
    private WebElement navbarSidebarContent;

    public RootPageMobile(WebDriver driver) {
        this.driver = HeadlessChromeDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void get() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.driver.get(url);
    }

    public void iClickTheMenuButton() {
        menuButton.click();
    }

    public void iShouldSeeAMobileSidebar() {
        assertTrue(navbarSidebarContent.isDisplayed());
    }
}
