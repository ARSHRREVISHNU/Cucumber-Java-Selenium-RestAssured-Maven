package com.testx.web.api.selenium.restassured.qe.ui.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm","pretty", "html:target/cucumber-report/report.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        ,"json:target/cucumber-report/cucumber.json","pretty","html:target/cucumber-report/cucumber-pretty",
        "json:target/cucumber-report/CucumberTestReport.json"},
        //monochrome = true,
        features = "src/test/resources/api/features/get_users.feature",
        glue = {"com.testx.web.api.selenium.restassured.qe.api.stepdefs"}
        //tags = "@parallel111"
        )
public class RunAPITests extends AbstractTestNGCucumberTests {


}
