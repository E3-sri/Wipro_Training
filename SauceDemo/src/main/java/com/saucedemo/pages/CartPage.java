package com.saucedemo.pages;

import java.time.Duration;
//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    
    private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By removeButton = By.id("remove-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");
    private By cartCount = By.className("shopping_cart_badge");
    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");
    private By cartItems = By.className("cart_item");

    
    // Multiple product locators
    private By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By addBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By addBoltShirt = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickAddToCart() {
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addBtn.click();
    }
    
    public void addMultipleProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(addBackpack)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addBikeLight)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addBoltShirt)).click();
    }

   
    public void openCart() {
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cart.click();
    }
    
   
   
    public int getCartCount() {
        try {
            WebElement countElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartCount));
            return Integer.parseInt(countElement.getText());
        } catch (Exception e) {
            return 0; // no badge means cart empty
        }
    }

    public boolean isProductDisplayedInCart() {
        return driver.findElements(cartItems).size() > 0;
    }

    public void clickContinueShopping() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueBtn.click();
    }

    public void clickCheckout() {
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutBtn.click();
    }

    public boolean isOnProductsPage() {
        return driver.getCurrentUrl().contains("inventory.html");
    }

    public void addProduct(String productId) {
        By locator = By.id("add-to-cart-" + productId);
        try {
            WebElement productBtn = wait.until(ExpectedConditions.elementToBeClickable(locator));
            productBtn.click();
        } catch (Exception e) {
            // fallback if Selenium click fails
            WebElement productBtn = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productBtn);
        }
        
    }
    
    
    public boolean isCartEmpty() {
        return getCartCount() == 0;
    }

    public void clickRemove() {
        WebElement removeBtn = wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        removeBtn.click();
    }
    


  }

