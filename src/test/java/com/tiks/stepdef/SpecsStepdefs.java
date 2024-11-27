package com.tiks.stepdef;

import com.tiks.BaseTest;
import com.tiks.pages.HomePageTest;
import com.tiks.pages.SpecsInfoTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SpecsStepdefs extends BaseTest {

    protected SpecsInfoTest specsInfoTest;

    @Then("item details is displayed {string}")
    public void itemDetailsIsDisplayed(String expectedItem) {
        specsInfoTest = new SpecsInfoTest(driver);
        specsInfoTest.goToSpecsInfo(expectedItem);
    }

//    @And("displayed {string} image")
//    public void displayedImage(String imgItem) {
//        specsInfoTest.validateImgItem(imgItem);
//    }
}
