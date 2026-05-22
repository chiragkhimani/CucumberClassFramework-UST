package com.automation.steps;

import com.automation.pages.web.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class CartSteps {

    CartPage cartPage = new CartPage();

    @Then("verify user is on cart page")
    public void verify_user_is_on_cart_page() {
        Assert.assertTrue(cartPage.isCartPageDisplayed());
    }

    @Then("verify item information on cart page")
    public void verify_item_information_on_cart_page() {
        Assert.assertEquals(HomeSteps.itemsOnCart, cartPage.getItemInfoFromCart());
    }

    @When("user click on checkout button")
    public void user_click_on_checkout_button() {
        cartPage.clickOnCheckoutBtn();
    }


}
