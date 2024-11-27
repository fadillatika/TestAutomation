package com.tiks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    WebDriver driver;

    By usernameInputText = By.cssSelector("input#user-name");
    By passwordInputText = By.xpath("//*[@id=\"password\"]");
    By loginButton = By.id("login-button");

    public LoginTest (WebDriver driver){
        this.driver = driver;
    }

    public void goToLoginPage(){
        driver.get("https://saucedemo.com/");
    }

    public void inputUsername (String username){
        driver.findElement(usernameInputText).sendKeys(username);
    }

    public void inputPassword (String password){
        driver.findElement(passwordInputText).sendKeys(password);
    }

    public void clickloginButton(){
        driver.findElement(loginButton).click();
    }

    public void validateErrorLogin(String errorMessage){
        assertTrue(driver.getPageSource().contains(errorMessage));
    }

}
