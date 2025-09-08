package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProductPage {

    private WebDriver driver;

    // Locators
    private By filterDropdown = By.className("product_sort_container");
    private By firstProduct = By.id("item_4_title_link");
    private By backToProductsBtn = By.id("back-to-products");
    private By twitterIcon = By.cssSelector("a[href*='twitter']");
    private By facebookIcon = By.cssSelector("a[href*='facebook']");
    private By linkedinIcon = By.cssSelector("a[href*='linkedin']");
    private By addToCartBtn = By.cssSelector("button.btn_inventory");
    private By productList = By.id("react-burger-menu-btn");
    private By allItems    = By.id("inventory_sidebar_link");// all products
    private By logout_Button= By.id("logout_sidebar_link");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnHomePage() {
        return driver.getCurrentUrl().contains("inventory.html");
    }

    public void clickFilter() {
        driver.findElement(filterDropdown).click();
    }

    public void chooseFilterOption(String option) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(filterDropdown));
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }

    public void clickFirstProduct() {
        driver.findElement(firstProduct).click();
    }

   

    // ✅ Random social media click
    public String clickRandomSocialMediaIcon() {
        List<By> icons = Arrays.asList(twitterIcon, facebookIcon, linkedinIcon);
        Random rand = new Random();
        By chosenIcon = icons.get(rand.nextInt(icons.size()));

        WebElement icon = driver.findElement(chosenIcon);
        String href = icon.getAttribute("href");
        icon.click();
        return href; // return expected URL to verify later
    }

    public void addProductToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void clickBackToProducts() {
        driver.findElement(backToProductsBtn).click();
    }

    
    public int getProductCount() {
        return driver.findElements(productList).size();
    }
    public boolean isProductOpened() {
        return driver.getCurrentUrl().contains("inventory-item.html");
    }
    public void productList() {
        driver.findElement(productList).click();
    }

  

    public void clickLogout() {
        driver.findElement(logout_Button).click();
    }
    public boolean isOnLoginPage() {
        // SauceDemo login page always has "login-button" visible
        try {
            return driver.getCurrentUrl().contains("saucedemo.com") &&
                   driver.findElement(By.id("login-button")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

 
    
    
   

}
