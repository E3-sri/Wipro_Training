package com.saucedemo.stepdefinitions;

import com.saucedemo.base.DriverFactory;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.ConfigReader;
import com.saucedemo.utils.ExtentManager;
import com.saucedemo.utils.ScreenshotUtils;


import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class Checkout {
	

    WebDriver driver;
    LoginPage loginPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Given("User is logged with username {string} and password {string}")
    public void user_is_logged_with_username_and_password(String username, String passwordKey) throws InterruptedException {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        String loginUrl = ConfigReader.getProperty("login_url");
        driver.get(loginUrl);
        
        String password = ConfigReader.getProperty(passwordKey);


        loginPage.enterUsername(username);
        Thread.sleep(2000);
        loginPage.enterPassword(password);
        Thread.sleep(2000);
        loginPage.clickLoginButton();
        Thread.sleep(2000);
    }

    //  Step to add a single product
    @When("User clicks on the product and adds it to cart")
    public void user_clicks_on_the_product_and_adds_it_to_cart() throws InterruptedException {
        cartPage.clickAddToCart();   // add default product
     
        Thread.sleep(2000);
    }

    //  Step to add multiple products
    @When("User adds multiple products to the cart")
    public void user_adds_multiple_products_to_the_cart() throws InterruptedException {
        cartPage.addMultipleProducts();   // add 3 products
        Thread.sleep(2000);
    }

    @When("User navigates to the cart and clicks on checkout")
    public void user_navigates_to_the_cart_and_clicks_on_checkout() throws InterruptedException {
        cartPage.openCart();
        Thread.sleep(2000);

        if (cartPage.getCartCount() == 0) {   // if cart is empty, add products
            driver.navigate().back(); // back to products
            Thread.sleep(2000);
            cartPage.addMultipleProducts(); // add 3 products
            Thread.sleep(2000);
            cartPage.openCart();
            Thread.sleep(2000);
            
        }
        cartPage.clickCheckout();
        
        Thread.sleep(2000);
    }
   

    @When("User fills checkout details with {string} {string} {string}")
    public void user_fills_checkout_details_with(String firstname, String lastname, String postalcode) throws InterruptedException {
        checkoutPage.enterFirstName(firstname);
        Thread.sleep(2000);
        checkoutPage.enterLastName(lastname);
        Thread.sleep(2000);
        checkoutPage.enterPostalCode(postalcode);
        Thread.sleep(2000);
    }

    @When("User clicks on continue")
    public void user_clicks_on_continue() throws InterruptedException {
        checkoutPage.clickContinue();
        Thread.sleep(2000);

        if (checkoutPage.isErrorDisplayed())
        {
            // system restricted invalid input
            System.out.println("Validation error displayed.");
        } 
        else 
        {
            //  no error  continue
            System.out.println("Checkout, not displayed error & continued successfully.");
        }
    }

    @When("User clicks on finish")
    public void user_clicks_on_finish() throws InterruptedException {

    	 // inside your step definition
    	 try 
    	 {
    	        checkoutPage.clickFinish();
    	        Thread.sleep(500);

    	 }
    	 catch (Exception e) {
    		    String path = ScreenshotUtils.takeScreenshot(driver, "checkout_debug");
    		    System.out.println("Screenshot saved at: " + path);

    		    // log into Extent report
    		    ExtentManager.getTest().fail("Failure at Checkout").addScreenCaptureFromPath(path);

    		    throw e;
    		}

    }

    @Then("User should see the confirmation message {string}")
    public void user_should_see_the_confirmation_message(String expectedMessage) throws InterruptedException {
        String actualMessage = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(actualMessage, expectedMessage, " Confirmation message mismatch!");
        Thread.sleep(2000);

    }
    
    @When("User click on BackToHome button user should be navigated to home page")
    public void user_click_on_BackToHome_button_user_should_be_navigated_to_home_page() throws InterruptedException
    {
    	checkoutPage.clickBackHome();
    	Thread.sleep(1000);
    	driver.quit(); // close browser 
    }
}
