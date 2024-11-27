package com.tiks.stepdef;

import com.tiks.BaseTest;
import com.tiks.pages.LoginTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdefs extends BaseTest {

    protected LoginTest loginTest;

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        getDriver();
        loginTest = new LoginTest(driver);
        loginTest.goToLoginPage();
    }

    @When("user input username with {string}")
    public void userInputUsernameWith(String username) {
    loginTest.inputUsername(username);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        loginTest.inputPassword(password);
    }

    @And("user clicks login button")
    public void userClickLoginButton() {
        loginTest.clickloginButton();
    }

    @Then("user able to see error message {string}")
    public void userAbleToSeeErrorMessage(String errorMessage) {
        loginTest.validateErrorLogin(errorMessage);
    }
}
