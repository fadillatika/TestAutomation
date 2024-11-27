package com.tiks.stepdef;

import com.tiks.BaseTest;
import com.tiks.pages.CheckoutTest;
import com.tiks.pages.FormAddressTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FormaddressStepdefs extends BaseTest {
    protected FormAddressTest formAddressTest;

    @Then("user will redirect to form shipping address")
    public void userWillRedirectToFormShippingAddress() {
        formAddressTest = new FormAddressTest(driver);
        formAddressTest.goToFormPage();
    }

    @Given("user is on form shipping address page")
    public void userIsOnFormShippingAddressPage() {
        formAddressTest = new FormAddressTest(driver);
        formAddressTest.fillingForm();
    }

    @When("user input first name with {string}")
    public void userInputFirstNameWith(String fName) {
        formAddressTest.inputFirstName(fName);
    }

    @And("user input last name with {string}")
    public void userInputLastNameWith(String lName) {
        formAddressTest.inputLastName(lName);
    }

    @And("user input zip code with {string}")
    public void userInputZipCodeWith(String postCode) {
        formAddressTest.inputPostalCode(postCode);
    }

    @And("user clicks continue button")
    public void userClicksContinueButton() {
        formAddressTest.clickContinueButton();
    }

    @Then("user will see error message {string}")
    public void userWillSeeErrorMessage(String errorMessage) {
        formAddressTest.validateErrorMessage(errorMessage);
    }

    @Given("user has completed all checkout step")
    public void userHasCompletedAllCheckoutStep() {
        formAddressTest = new FormAddressTest(driver);
        formAddressTest.allStepsCheckout();
    }
}
