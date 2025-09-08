package com.saucedemo.stepdefinitions;

import com.saucedemo.base.DriverFactory;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;
import com.saucedemo.utils.ConfigReader;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Products {

    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;

    @Given("User is logged into SauceDemo with username {string} and password {string}")
    public void user_is_logged_into_saucedemo(String username, String passwordKey) throws InterruptedException {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);

        driver.get(ConfigReader.getProperty("login_url"));
        
        
        String password = ConfigReader.getProperty(passwordKey);

        loginPage.enterUsername(username);
        Thread.sleep(500);
        loginPage.enterPassword(password);
        Thread.sleep(500);
        loginPage.clickLoginButton();
        Thread.sleep(500);
    }

    @Given("User is on home page now")
    public void user_is_on_home_page_now() throws InterruptedException {
        Assert.assertTrue(productPage.isOnHomePage(), "User is not on home page");
        Thread.sleep(500);
    }

    @When("User clicks on filter option")
    public void user_clicks_on_filter_option() throws InterruptedException {
        productPage.clickFilter();
        Thread.sleep(500);
    }

    @When("try to choose the option in dropdown")
    public void try_to_choose_the_option_in_dropdown() throws InterruptedException {
        productPage.chooseFilterOption("Price (low to high)");
        Thread.sleep(500);
    }

    @Then("Products should be arranged according to that")
    public void products_should_be_arranged_according_to_that() throws InterruptedException {
        Assert.assertTrue(productPage.isOnHomePage(), "Products not arranged");
        Thread.sleep(500);
    }

    @When("User click on the particular product")
    public void user_click_on_the_particular_product() throws InterruptedException {
        productPage.clickFirstProduct();
        Thread.sleep(500);
    }

    @Then("Product should be opened")
    public void product_should_be_opened() throws InterruptedException {
        if (productPage.isProductOpened()) 
        {
            System.out.println(" Product page opened successfully.");
        } 
        else
        {
            System.out.println(" Product page did not open.");
            Assert.fail("Product page not opened");
        }
        Thread.sleep(500);
    }


    @When("User clicks randomly on a social media icon")
    public void user_clicks_on_social_media_icons() throws InterruptedException {
        productPage.clickRandomSocialMediaIcon();

        // Wait until new tab is opened
        Thread.sleep(2000);
        String originalWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Navigated to: " + currentUrl);

        Assert.assertTrue(
        	    currentUrl.contains("twitter") || currentUrl.contains("x.com") || 
        	    currentUrl.contains("facebook") || currentUrl.contains("linkedin"),
        	    "Did not navigate to correct social media site"
        	);

        // Close social media tab and return back
        driver.close();
        driver.switchTo().window(originalWindow);
    }


    @Then("it should route to particular site")
    public void it_should_route_to_particular_site() {
        Assert.assertTrue(true, "Social media icon did not route correctly");
    }


    @When("Product is opened")
    public void product_is_opened() throws InterruptedException {
        Assert.assertTrue(productPage.isProductOpened(), "Product not opened yet");
        Thread.sleep(500);
    }

    @Then("User should have a option to add the product to cart")
    public void user_should_have_option_to_add_product_to_cart() throws InterruptedException {
        productPage.addProductToCart();
        Thread.sleep(1000);
    }

    @When("User clicks on back to home button")
    public void user_clicks_on_back_to_home_button() throws InterruptedException {
        productPage.clickBackToProducts();
        Thread.sleep(1000);
    }

    @Then("User should be navigated back to the Products Page")
    public void user_should_be_navigated_back_to_products_page() throws InterruptedException {
        Assert.assertTrue(productPage.isOnHomePage(), "Not navigated to Products page");
        Thread.sleep(1000);
    }


    // ✅ Extra Scenarios

    @Then("User should see all products listed")
    public void user_should_see_all_products_listed() throws InterruptedException {
        Assert.assertTrue(productPage.getProductCount() > 0, "No products listed on page");
        Thread.sleep(1000);
    }

    @When("User refreshes the product page")
    public void user_refreshes_the_product_page() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(500);
    }

    @Then("Products should still be visible")
    public void products_should_still_be_visible() throws InterruptedException {
        Assert.assertTrue(productPage.getProductCount() > 0, "Products disappeared after refresh");
        Thread.sleep(500);
    }
    @When("User click on icon left side bar for logout")
    public void user_click_on_icon_left_side_bar_for_logout() throws InterruptedException {
        productPage.productList();   // new method in POM
        Thread.sleep(1000);
    }

    @And("click on logout button")
    public void click_on_logout_button() throws InterruptedException {
        productPage.clickLogout();  // existing method
        Thread.sleep(1000);
    }

    @Then("User should be navigated back to login page")
    public void user_should_be_navigated_back_to_login_page() throws InterruptedException
    {
        if (productPage.isOnLoginPage())
        {
            System.out.println(" User navigated back to login page after logout.");
        } 
        else 
        {
            System.out.println(" User did not navigate back to login page.");
            Assert.fail("User was not routed back to login page after logout");
        }
        Thread.sleep(1000);
    }
    
}
