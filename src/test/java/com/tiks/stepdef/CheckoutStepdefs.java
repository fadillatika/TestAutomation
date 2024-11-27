package com.tiks.stepdef;

import com.tiks.BaseTest;
import com.tiks.pages.CheckoutTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class CheckoutStepdefs extends BaseTest {

    protected CheckoutTest checkoutTest;

    @And("user redirect to cart page")
    public void userRedirectToCartPage() {
        checkoutTest = new CheckoutTest(driver);
        checkoutTest.goToCartPage();
    }

    @Then("cart displays the correct list of items")
    public void cartDisplaysTheCorrectListOfItems(List<String> expectedItem) {
        checkoutTest.verifyListItems(expectedItem);
    }

    @Given("user is on cart page")
    public void userIsOnCartPage() {
        checkoutTest = new CheckoutTest(driver);
        checkoutTest.goToCartPage();

    }

    @When("user clicks checkout button")
    public void userClicksCheckoutButton() {
        checkoutTest.clickCheckoutButton();
    }
}
