package com.saucedemo.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Checkout.feature",   
        glue = {"com.saucedemo.stepdefinitions","com.saucedemo.hooks"},                
        plugin = {
                "pretty", "html:target/checkout-reports.html", 
        },
        monochrome = true,
        publish = true
)
public class CheckoutRunner extends AbstractTestNGCucumberTests
{

}
