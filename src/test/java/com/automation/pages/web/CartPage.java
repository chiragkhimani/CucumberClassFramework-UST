package com.automation.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//span[@class='title' and text()='Your Cart']")
    WebElement cartPageTitle;

    @FindBy(css = ".inventory_item_name")
    List<WebElement> itemsOnCart;

    @FindBy(id = "checkout")
    WebElement checkBtn;


    public boolean isCartPageDisplayed() {
        return cartPageTitle.isDisplayed();
    }

    public List<String> getItemInfoFromCart() {
        List<String> itemNamesOnCart = new ArrayList<>();

        for (WebElement item : itemsOnCart) {
            itemNamesOnCart.add(item.getText());
        }

        return itemNamesOnCart;
    }

    public void clickOnCheckoutBtn() {
        checkBtn.click();
    }


}
