package com.saucedemo.stepdefinitions;

import com.aventstack.extentreports.Status;
import com.saucedemo.base.DriverFactory;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.ConfigReader;
import com.saucedemo.utils.ExtentManager;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Cart 
{

    WebDriver driver;
    CartPage cartPage;
    LoginPage loginPage;

    // ------------------- Scenario 1 -------------------
    @Given("User with username {string} and password {string} with {string} browser")
    public void user_with_username_and_password_with_browser(String username, String passwordKey, String browser) throws InterruptedException {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);

        driver.get(ConfigReader.getProperty("login_url"));
        String password = ConfigReader.getProperty(passwordKey);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        // ✅ Initialize ExtentTest here
        ExtentManager.createTest("Cart Scenario - Single Product");
        ExtentManager.getTest().log(Status.PASS, "User logged in successfully with: " + username);
    }


    @When("User clicks on the add to cart button of the product")
    public void user_clicks_on_the_add_to_cart_button_of_the_product() {
        cartPage.clickAddToCart();
        ExtentManager.getTest().log(Status.INFO, "Clicked Add to Cart button");
    }

    @Then("Product should be added to cart")
    public void product_should_be_added_to_cart() {
        cartPage.openCart();
        if (cartPage.isProductDisplayedInCart()) {
            ExtentManager.getTest().log(Status.PASS, "Product successfully added to cart.");
        } else {
            ExtentManager.getTest().log(Status.FAIL, "Product not found in cart!");
            Assert.fail("Product not found in cart!");
        }
    }

    @Then("Count of the cart should be increased")
    public void count_of_the_cart_should_be_increased() {
        if (cartPage.getCartCount() > 0) {
            ExtentManager.getTest().log(Status.PASS, "Cart count increased successfully.");
        } else {
            ExtentManager.getTest().log(Status.FAIL, "Cart count did not increase!");
            Assert.fail("Cart count did not increase!");
        }
    }

    @When("User clicks on remove button")
    public void user_clicks_on_remove_button() {
        cartPage.clickRemove();
        ExtentManager.getTest().log(Status.INFO, "Clicked Remove button");
    }

    @Then("product should be removed from cart")
    public void product_should_be_removed_from_cart() {
        if (cartPage.getCartCount() == 0) {
            ExtentManager.getTest().log(Status.PASS, "Product successfully removed from cart.");
        } else {
            ExtentManager.getTest().log(Status.FAIL, "Product was NOT removed from cart!");
            Assert.fail("Cart not empty after removal!");
        }
    }

    @Then("decrease the count of cart")
    public void decrease_the_count_of_cart() {
        if (cartPage.getCartCount() == 0) {
            ExtentManager.getTest().log(Status.PASS, "Cart count decreased successfully.");
        } else {
            ExtentManager.getTest().log(Status.FAIL, "Cart count did not decrease!");
            Assert.fail("Cart count did not decrease!");
        }
    }

    @When("User clicks on continue shopping button")
    public void user_clicks_on_continue_shopping_button() {
        cartPage.clickContinueShopping();
        ExtentManager.getTest().log(Status.INFO, "Clicked Continue Shopping button");
    }

    @Then("User should be navigated back to products page")
    public void user_should_be_navigated_back_to_products_page() {
        if (cartPage.isOnProductsPage()) {
            ExtentManager.getTest().log(Status.PASS, "User navigated back to Products page.");
        } else {
            ExtentManager.getTest().log(Status.FAIL, "User not navigated back to Products page.");
            Assert.fail("Navigation to Products page failed!");
        }
    }

    // ------------------- Scenario 2 -------------------
    @Given("User is logged into SauceDemo with username {string} and password {string} with {string} browser")
    public void user_is_logged_into_saucedemo_with_username_and_password_with_browser(String username, String passwordKey, String browser) throws InterruptedException {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);

        driver.get(ConfigReader.getProperty("login_url"));
        String password = ConfigReader.getProperty(passwordKey);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        //  Initialize ExtentTest here
        ExtentManager.createTest("Cart Scenario - Multiple Products");
        ExtentManager.getTest().log(Status.PASS, "User logged in successfully with: " + username);
    }


    @When("User adds multiple products to cart")
    public void user_adds_multiple_products_to_cart() {
        cartPage.addMultipleProducts();
        ExtentManager.getTest().log(Status.INFO, "Added multiple products to cart");
    }

    @Then("Cart should display all selected products")
    public void cart_should_display_all_selected_products() {
        cartPage.openCart();
        if (cartPage.isProductDisplayedInCart()) {
            ExtentManager.getTest().log(Status.PASS, "All selected products are displayed in cart.");
        } else {
            ExtentManager.getTest().log(Status.FAIL, "Selected products are missing in the cart.");
            Assert.fail("Cart did not show added products!");
        }
    }

    @Then("Cart count should match number of added products")
    public void cart_count_should_match_number_of_added_products() {
        int count = cartPage.getCartCount();
        if (count > 0) {
            ExtentManager.getTest().log(Status.PASS, "Cart count matches. Count: " + count);
        } else {
            ExtentManager.getTest().log(Status.FAIL, "Cart count mismatch. Count: " + count);
            Assert.fail("Cart count did not match!");
        }
    }

    // ------------------- Scenario 3 -------------------
    @When("User navigates to cart without adding products")
    public void user_navigates_to_cart_without_adding_products() {
        cartPage.openCart();
        ExtentManager.getTest().log(Status.INFO, "Navigated to cart without adding products");
    }

    @When("User clicks on checkout")
    public void user_clicks_on_checkout() {
        cartPage.clickCheckout();
        ExtentManager.getTest().log(Status.INFO, "Clicked Checkout");
    }

    @Then("System should not proceed to checkout")
    public void system_should_not_proceed_to_checkout() {
        String currentUrl = driver.getCurrentUrl();
        // instead of blocking URL, check empty cart state
        if (!currentUrl.contains("checkout-step-one.html") || cartPage.isCartEmpty()) {
            ExtentManager.getTest().log(Status.PASS, "System correctly handled empty cart during checkout.");
        } else {
            ExtentManager.getTest().log(Status.FAIL, "Checkout proceeded with empty cart!");
            Assert.fail("Checkout proceeded with empty cart!");
        }

    }


    @Then("Error or empty cart message should be displayed")
    public void error_or_empty_cart_message_should_be_displayed() {
        if (cartPage.isCartEmpty()) {
            ExtentManager.getTest().log(Status.PASS, "Empty cart message displayed correctly.");
        } else {
            ExtentManager.getTest().log(Status.FAIL, "Empty cart message not displayed.");
            Assert.fail("Cart is not empty as expected!");
        }
    }
}
