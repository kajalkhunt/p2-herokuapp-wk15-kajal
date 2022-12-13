package com.herokuapp.testsuite;

import com.herokuapp.customlisteners.CustomListeners;
import com.herokuapp.pages.LoginPage;
import com.herokuapp.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani
 */
@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {


    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        loginPage = new LoginPage();
    }


    @Test (groups = {"sanity", "regression"})
    public void UserShouldLoginSuccessfullyWithValidCredentials() {
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Secure Area";
        Assert.assertEquals(loginPage.getSecureAreaText(), expectedMessage, "User Not Logged In");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheUsernameErrorMessage() {
        loginPage.enterUserName("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Your username is invalid!";
        Assert.assertEquals(loginPage.invalidUserAndPasswordMessage(), expectedMessage, "User Logged in Successfully");

    }

    @Test(groups = {"regression"})
    public void verifyThePasswordErrorMessage() {
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Your password is invalid!";
        Assert.assertEquals(loginPage.invalidUserAndPasswordMessage(), expectedMessage, "User Logged in Successfully");


    }
}
