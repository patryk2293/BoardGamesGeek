package com.seleniumlearner.tests;

import com.seleniumlearner.config.ReadProperties;
import com.seleniumlearner.pageobjects.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class LoginTests extends BaseTest {

    String username = ReadProperties.getUsername();
    String password = ReadProperties.getPassword();

    @Test
    public void correctLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnSignIn()
                .typeCredentials(username, password)
                .logIn();

        String nameAfterLogin = loginPage.getConfirmationName();
        Assert.assertEquals("Login failed", username, nameAfterLogin);
    }

    @Test
    public void bothEmptyFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnSignIn()
                .typeCredentials("", "")
                .logIn();

        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals("Message is not the same: ", "Invalid username or password", actualErrorMessage);
    }

    @Test
    public void incorrectUsernameField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnSignIn()
                .typeCredentials("", password)
                .logIn();

        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals("Message is not the same: ", "Invalid username or password", actualErrorMessage);
    }

    @Test
    public void incorrectPasswordField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnSignIn()
                .typeCredentials(username, "Elo")
                .logIn();

        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals("Message is not the same: ", "Invalid username or password", actualErrorMessage);
    }
}
