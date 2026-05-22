package com.automation.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends BasePage {

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(xpath = "//div[@data-test='payment-info-value']")
    WebElement paymentMethod;

    @FindBy(xpath = "//div[@data-test='subtotal-label']")
    WebElement itemSubTotalValue;

    @FindBy(css = ".inventory_item_price")
    List<WebElement> itemPrices;

    @FindBy(xpath = "//div[@data-test='total-label']")
    WebElement totalPrice;

    @FindBy(xpath = "//div[@data-test='tax-label']")
    WebElement taxPrice;

    public boolean isCheckoutPageDisplayed() {
        return isDisplay(finishBtn) && isDisplay(paymentMethod);
    }

    public boolean isFinalPriceIsMatchingWithItemTotalPrice() {
        double subTotalPrice = Double.parseDouble(itemSubTotalValue.getText().split("\\$")[1]);
        double totalItemPrice = 0;

        for (WebElement price : itemPrices) {
            totalItemPrice = totalItemPrice + Double.parseDouble(price.getText().split("\\$")[1]);
        }

        double totalPriceOnWeb = Double.parseDouble(totalPrice.getText().split("\\$")[1]);
        double totalPriceAfterTax = totalItemPrice + Double.parseDouble(taxPrice.getText().split("\\$")[1]);

        System.out.println("Price on Web===" + totalPriceOnWeb);
        System.out.println("Price after calculation===" + totalPriceAfterTax);

        return totalPriceOnWeb == totalPriceAfterTax;
    }


}
