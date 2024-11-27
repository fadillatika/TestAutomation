package com.tiks.stepdef;

import com.tiks.BaseTest;
import com.tiks.pages.FinishingStepTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FinishingStepdefs extends BaseTest {

    protected FinishingStepTest finishingStepTest;

    @Then("user will redirect to finishing page")
    public void userWillRedirectToFinishingPage() {
        finishingStepTest = new FinishingStepTest(driver);
        finishingStepTest.goToFinishingPage();
    }

    @And("user is on checkout overview page")
    public void userIsOnCheckoutOverviewPage() {
        finishingStepTest = new FinishingStepTest(driver);
        finishingStepTest.goToFinishingPage();
    }

    @When("user clicks finish button")
    public void userClicksFinishButton() {
        finishingStepTest.clickButtonFinish();
    }
}
