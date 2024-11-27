package com.tiks.stepdef;

import com.tiks.BaseTest;
import com.tiks.pages.AllCompleted;
import io.cucumber.java.en.Then;

public class AllCompletedStepdefs extends BaseTest {
    protected AllCompleted allCompleted;

    @Then("checkout is complete")
    public void checkoutIsComplete() {
        allCompleted = new AllCompleted(driver);
        allCompleted.goToCompletedPage();
    }
}
