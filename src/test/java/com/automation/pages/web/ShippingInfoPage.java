package com.automation.pages.web;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingInfoPage extends BasePage {

    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement postalCodeInput;

    @FindBy(id = "continue")
    WebElement continueBtn;

    public boolean isShippingInfoPageDisplayed() {
        return firstNameInput.isDisplayed() && lastNameInput.isDisplayed();
    }

    public void fillShippingDetails() {
        firstNameInput.sendKeys(ConfigReader.getConfigValue("shipping.firstname"));
        lastNameInput.sendKeys(ConfigReader.getConfigValue("shipping.lastname"));
        postalCodeInput.sendKeys(ConfigReader.getConfigValue("shipping.postal.code"));
    }

    public void clickOnContinueBtn() {
        continueBtn.click();
    }
}
