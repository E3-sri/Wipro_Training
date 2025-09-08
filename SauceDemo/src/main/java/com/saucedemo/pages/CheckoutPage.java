package com.saucedemo.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.interactions.Actions;



public class CheckoutPage 
{
    private WebDriver driver;
    private WebDriverWait wait;
    

    // Locators – Step One (Your Information)
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    // Locators – Step Two (Overview)
    private By itemList = By.className("cart_item");
    private By totalPrice = By.className("summary_total_label");
 //   private By finishButton = By.id("finish");

    // Locators – Step Three (Complete)
   // private By confirmationMessage = By.("complete-header");
    private By backHomeButton = By.xpath("//*[@id=\"back-to-products\"]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---- Step One Actions ----
    public void enterFirstName(String firstname) {
        WebElement fn = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        fn.clear();
        fn.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        WebElement ln = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        ln.clear();
        ln.sendKeys(lastname);
    }

    public void enterPostalCode(String postalcode) {
        WebElement pc = wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField));
        pc.clear();
        pc.sendKeys(postalcode);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public boolean isErrorDisplayed() {
        return driver.findElements(errorMessage).size() > 0;
    }

    // ---- Step Two Actions ----
    public int getNumberOfItemsInOverview() {
        List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(itemList));
        return items.size();
    }

    public String getTotalPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice)).getText();
    }



    public void clickFinish() {
        try {
            // Count items in overview
            int items = getNumberOfItemsInOverview();

            WebElement finishBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

            if (items > 2) {
                // Scroll only if there are multiple items
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", finishBtn);
                System.out.println("Scrolled to Finish button because multiple items are present.");
            } else {
                System.out.println("Single item in cart, no scroll needed.");
            }

            wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();

        } catch (Exception e) {
            // Retry with JS click as backup
            WebElement finishBtn = driver.findElement(By.id("finish"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", finishBtn);
            System.out.println("Retrying Finish button click using JS executor.");
        }
    }

    // ---- Step Three Actions ----
    public String getConfirmationMessage() 
    {
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkout_complete_container > h2")));
        return header.getText().trim();
    }

    public void clickBackHome() {
        try {
            WebElement backBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(backHomeButton));

            // Scroll into view
            ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", backBtn);

            // Small wait to stabilize UI
            Thread.sleep(1000);

            // Try clicking
            backBtn.click();

            // Verify navigation to Products Page
            if (driver.getCurrentUrl().contains("inventory.html")) {
                System.out.println(" successfully User navigated back to Products page.");
            } 
            else 
            {
                System.out.println(" Back button clicked but user not navigated to Products page.");
            }

        } 
        catch (Exception e)
        {
            System.out.println(" Back button not found or not clickable.");
            e.printStackTrace();
        }
    }
   
}
