package com.testx.web.api.selenium.restassured.qe.ui.stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.testx.web.api.selenium.restassured.qe.ui.context.TestContext;
import org.testng.Assert;

public class GoogleStepDefinitions extends BaseSetup{

    TestContext testContext;
    WebDriver driver;
    //public WebDriver driver;
    public ChromeOptions options;
    public String value;


    public GoogleStepDefinitions(TestContext testContext){
        super(testContext);
        this.testContext = testContext;
        this.driver = testContext.getDriverManager().getDriver();

//        options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-win64/chromedriver.exe");
//        driver = new ChromeDriver(options);

    }
    @Given("Browser open")
    public void browser_open(){
        driverManagerUtils.navigateTo("https://www.google.com/");
    }

    @When("Read the value")
    public void read_the_value(){
        value = driverManagerUtils.getElementText(driver, driver.findElement(By.xpath("//a[@class='gb_y']")));
        System.out.println(value);
    }

    @Then("Validate the text")
    public void validate_the_text(){
    Assert.assertEquals(value,"Gmail","both are not same");
    }
}
