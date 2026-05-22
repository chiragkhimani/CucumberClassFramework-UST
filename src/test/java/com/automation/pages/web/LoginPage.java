package com.automation.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement signInBtn;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement invalidLoginErrMsg;

    public void openWebsite() {
        driver.get("https://www.saucedemo.com/");
    }

    public void doLogin(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInBtn.click();
    }

    public boolean isLoginPageDisplayed() {
        return usernameInput.isDisplayed() && passwordInput.isDisplayed();
    }

    public String getInvalidLoginErrMsg() {
        return invalidLoginErrMsg.getText();
    }
}
