package com.tiks.stepdef;

import com.tiks.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CucumberHooks extends BaseTest {
    @Before ("not @LoginRequired")
    public void beforeTest() {
        getDriver();

        driver.get("https://saucedemo.com/");
        WebElement usernameField = driver.findElement(By.cssSelector("input#user-name"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();
    }

    @After
    public void afterTest(){
        driver.close();
    }
}
