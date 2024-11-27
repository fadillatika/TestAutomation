package com.tiks.stepdef;

import com.tiks.BaseTest;
import com.tiks.pages.HomePageTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeStepdefs extends BaseTest {

    protected HomePageTest homePageTest;

    @Then("user is on homepage")
    public void userIsOnHomepage() {
        homePageTest = new HomePageTest(driver);
        homePageTest.goToHomePage();
    }

    @Given("user is on home page")
    public void userIsOnHomePage() {
        homePageTest = new HomePageTest(driver);
        homePageTest.goToHomePage();
    }

    @When("user clicks sort dropdown")
    public void userClicksSortDropdown() {
        homePageTest.sortingItems();
    }

    @And("user selects {string}")
    public void userSelects(String filterOption) {
        homePageTest.dropDownOptions(filterOption);
    }

    @Then("the products on homepage sorted by descending price")
    public void theProductsOnHomepageSortedByDescendingPrice() {
        homePageTest.verifyItemSorted();
    }

    @When("user clicks add to cart on {string}")
    public void userClicksOn(String product) {
        homePageTest.addItemToCart(product);

    }

    @Then("product added to the cart and cart icon shows {string}")
    public void productAddedToTheCart(String totalItem) {
        homePageTest.verifyProductAdded(totalItem);

    }

    @When("user clicks cart icon")
    public void userClicksCartIcon() {
        homePageTest.clickCartIcon();

    }

    @When("user clicks on the {string} title")
    public void userClicksOnTheTitle(String itemSpec) {
        homePageTest.clickItem(itemSpec);
    }

    @Given("user has added {string} to the cart")
    public void userHasAddedToTheCart(String product) {
        homePageTest = new HomePageTest(driver);
        homePageTest.addItemToCart(product);
    }
}
