package com.saucedemo.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",   
    glue = {"com.saucedemo.stepdefinitions", "com.saucedemo.hooks"},                
    tags = "@Login or @Products or @Cart or @Checkout",  // Run all feature tags
    plugin = {
        "pretty", 
        "html:target/final-reports.html",
        "json:target/cucumber.json",
        "junit:target/cucumber.xml"
    }, 
    monochrome = true
)	
public class TestRunner extends AbstractTestNGCucumberTests {
}
