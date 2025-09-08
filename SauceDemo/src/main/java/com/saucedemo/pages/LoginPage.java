package com.saucedemo.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) throws InterruptedException {
        usernameField.clear();
        usernameField.sendKeys(username);
        Thread.sleep(1000);  // wait 2 seconds to observe
    }

    public void enterPassword(String password) throws InterruptedException {
        passwordField.clear();
        passwordField.sendKeys(password);
        Thread.sleep(1000);  // wait 2 seconds to observe
    }

    public void clickLoginButton() throws InterruptedException {
        loginBtn.click();
        // wait until page transitions (URL contains inventory.html OR error shown)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.or(
            ExpectedConditions.urlContains("inventory.html"),
            ExpectedConditions.visibilityOf(errorMessage)
        ));
        Thread.sleep(1000); // just to observe
    }


    public String getErrorMessage() {
        try
        {
            return errorMessage.getText();
        } 
        catch (Exception e) 
        {
            return "";
        }
    }
}
