package com.herokuapp.pages;

import com.herokuapp.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id = "username")
    WebElement userNameBox;

    @CacheLookup
    @FindBy(id = "password")
    WebElement userPasswordBox;

    @CacheLookup
    @FindBy(name = "Password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h2[text()=' Secure Area']")
    WebElement secureAreaText;

    @CacheLookup
    @FindBy(xpath = "//div[@id='flash-messages']")
    WebElement invalidCredentialMessage;

    public void enterUserName(String userNameText) {
        Reporter.log("Entering "+ userNameText + " User Name " + userNameBox.toString());
        sendTextToElement(userNameBox, userNameText);
    }

    public void enterPassword(String passwordText) {
        Reporter.log("Entering "+ passwordText + " User Name " + userPasswordBox.toString());
        sendTextToElement(userPasswordBox, passwordText);
    }

    public void clickOnLoginButton(){
        Reporter.log("click on Loging Button" + loginButton.toString());
        clickOnElement(loginButton);
    }

    public String getSecureAreaText() {
        Reporter.log("verify Secure Area text "+  secureAreaText.toString());
        return getTextFromElement(secureAreaText);
    }

    public String invalidUserAndPasswordMessage(){
        Reporter.log("Entering invalid user and password " + invalidCredentialMessage.toString());
        return getTextFromElement(invalidCredentialMessage).substring(0,25);
    }
}
