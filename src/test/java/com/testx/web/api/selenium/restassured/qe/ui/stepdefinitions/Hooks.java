package com.testx.web.api.selenium.restassured.qe.ui.stepdefinitions;

import com.testx.web.api.selenium.restassured.qe.ui.context.TestContext;
//import com.testx.web.api.selenium.restassured.qe.ui.reporter.AllureManager;
import com.testx.web.api.selenium.restassured.qe.ui.webdriver.SelectWebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.testx.web.api.selenium.restassured.qe.ui.config.ConfigurationManager.getConfiguration;

public class Hooks extends BaseSetup {

    private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);
    WebDriver driver;
    TestContext testContext;

    public Hooks(TestContext testContext){
        super(testContext);
        this.testContext = testContext;
        driver = testContext.getDriverManager().getDriver();
    }
//
//    @Before("@ui and not @api")
//    public void preCondition() {
//        AllureManager.setAllureEnvironmentInformation();
//    }

    @Before()
    public void preConditionForUITests() {
        //AllureManager.setAllureEnvironmentInformation();
        driver = new SelectWebDriverFactory().createInstance(getConfiguration().browser());
        testContext.getDriverManager().addDriver(driver);
        testContext.getDriverManager().setDriver(driver);
        if(testContext.getDriverManager().getDriver() == null){
            System.out.println("Why this is null");
        }
        testContext.getDriverManager().getDriver().get(getConfiguration().url());
    }

    @After()
    public void postConditionForUITests(Scenario scenario) {
        //validate if scenario has failed then Screenshot
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot Failed");

            //Screenshot in Allure Report
            //AllureManager.saveScreenshotPNG(driver);
        }
        System.out.println("Stop Driver: " + driver);
        //driver.quit();
    }
}
