package com.automation.steps;

import com.automation.pages.web.ShippingInfoPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ShippingInfoSteps {

    ShippingInfoPage shippingInfoPage = new ShippingInfoPage();

    @Then("verify user is on shipping information page")
    public void verify_user_is_on_shipping_information_page() {
        Assert.assertTrue(shippingInfoPage.isShippingInfoPageDisplayed());
    }

    @When("user fill all shipping details")
    public void user_fill_all_shipping_details() {
        shippingInfoPage.fillShippingDetails();
    }

    @When("click on continue button")
    public void click_on_continue_button() {
        shippingInfoPage.clickOnContinueBtn();
    }
}
