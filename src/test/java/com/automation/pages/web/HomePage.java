package com.automation.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenuIcon;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;

    @FindBy(css = ".product_sort_container")
    WebElement filterDropdown;

    @FindBy(css = ".shopping_cart_link")
    WebElement cartIcon;

    @FindBy(css = ".shopping_cart_badge")
    WebElement cartValue;

    String XPATH_ADD_TO_CART_BTN_FOR_ITEM = "//div[@class='inventory_item_name ' and text()='%s']/ancestor::div[@class='inventory_item']//button";


    public void clickOnBurgerMenu() {
        burgerMenuIcon.click();
    }

    public void clickLogoutLink() {
        logoutLink.click();
    }

    public boolean isHomePageDisplayed() {
        return filterDropdown.isDisplayed() && cartIcon.isDisplayed();
    }

    public void clickOnAddToCartButtonForItem(String itemName) {
        String xpath = String.format(XPATH_ADD_TO_CART_BTN_FOR_ITEM, itemName);
        driver.findElement(By.xpath(xpath)).click();
    }

    public String getCartValue() {
        return cartValue.getText();
    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }
}
