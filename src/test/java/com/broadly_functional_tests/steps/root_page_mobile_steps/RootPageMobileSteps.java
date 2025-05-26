package com.broadly_functional_tests.steps.root_page_mobile_steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.broadly_functional_tests.pages.RootPageMobile;
import com.broadly_functional_tests.utils.HeadlessChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RootPageMobileSteps {

    // pass in isMobile only in the steps file
    WebDriver driver = HeadlessChromeDriver.getDriver(true);
    public Actions actions = new Actions(driver);
    private RootPageMobile rootPageMobile;

    @Before
    public void before() {
        this.rootPageMobile = new RootPageMobile(driver);
    }

    @After
    public void after() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Given("I am on the root page")
    public void iAmOnTheRootPage() {
        rootPageMobile.get();
    }

    @When("I click the menu button")
    public void iClickTheMenuButton() {
        rootPageMobile.iClickTheMenuButton();
    }

    @Then("I should see the mobile sidebar")
    public void IShouldSeeTheMobileSidebar() {
        rootPageMobile.iShouldSeeAMobileSidebar();;
    }
}
