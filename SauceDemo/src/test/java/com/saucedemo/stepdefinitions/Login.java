package com.saucedemo.stepdefinitions;

import com.saucedemo.base.DriverFactory;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.ConfigReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login {

    WebDriver driver;
    LoginPage loginPage;

    @Given("User is on the login page")
    public void user_is_on_the_login_page_with_browser() {
        driver = DriverFactory.getDriver();        // fresh driver each scenario
        loginPage = new LoginPage(driver);         // reinitialize page object
        String loginUrl = ConfigReader.getProperty("login_url");
        driver.get(loginUrl);
    }

    @When("User enters username {string}")
    public void user_enters_username(String username) throws InterruptedException {
        loginPage.enterUsername(username);
    }

    @When("User enters password {string}")
    public void user_enters_password(String passwordKey) throws InterruptedException {
        String password = ConfigReader.getProperty(passwordKey);
        loginPage.enterPassword(password);
    }

    @When("click on login button")
    public void click_on_login_button() throws InterruptedException {
        loginPage.clickLoginButton();
    }

    @Then("user navigated to home page")
    public void user_navigated_to_the_home_page() {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("✅ Successfully navigated to Home page.");
        }
    }

    @Then("user verify the login result")
    public void user_verify_the_login_result() {
        String currentUrl = driver.getCurrentUrl();

        // Case 1: Successful login → Must land on home page
        if (currentUrl.contains("inventory.html"))
        {
            System.out.println("✅ Successfully logged in and navigated to home page.");
            Assert.assertTrue(true);  // Pass
            return;
        }

        // Case 2: Invalid login → Must show valid error message
        String actualError = loginPage.getErrorMessage().trim();

        if (actualError.isEmpty())
        {
            Assert.fail("❌ Expected error message but none displayed!");
        }

        System.out.println("⚠️ Error shown: " + actualError);

        if (
            actualError.equals("Epic sadface: Username is required") ||
            actualError.equals("Epic sadface: Password is required") ||
            actualError.equals("Epic sadface: Username and password do not match any user in this service")
        ) 
        
        {
            Assert.assertTrue(true, "✅ Correct error message displayed");
        } 
        else 
        {
            Assert.fail("❌ Unexpected error message: " + actualError);
        }
    }


}
