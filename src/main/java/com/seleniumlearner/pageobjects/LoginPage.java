package com.seleniumlearner.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By signInButtonLocator = By.xpath("//li/a[@ggloginbutton='']");
    private By loginFieldsContentLocator = By.cssSelector("div[class='modal-content']");
    private By usernameFieldLocator = By.id("inputUsername");
    private By passwordFieldLocator = By.id("inputPassword");
    private By errorMessageLocator = By.cssSelector("span[class='help-block']");
    private By logInButtonLocator = By.xpath("//div/button[@type='submit'][@class='btn btn-primary']");
    private By usernameTextLocator = By.cssSelector("span[class='mygeek-dropdown-username text-truncate']");

    public LoginPage clickOnSignIn() {
        driver.findElement(signInButtonLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginFieldsContentLocator));
        return this;
    }

    public LoginPage typeCredentials(String username, String password) {
        driver.findElement(usernameFieldLocator).sendKeys(username);
        driver.findElement(passwordFieldLocator).sendKeys(password);
        return this;
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(errorMessageLocator), "Invalid username or password"));
        return driver.findElement(errorMessageLocator).getText();
    }

    public void logIn() {
        driver.findElement(logInButtonLocator).click();
    }

    public String getConfirmationName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextLocator)).getText();
    }
}
