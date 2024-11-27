package com.tiks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FormAddressTest {
    WebDriver driver;

    By formShipping = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By firstNameBox = By.id("first-name");
    By lastNameBox = By.id("last-name");
    By postalCodeBox = By.id("postal-code");
    By continueButton =  By.id("continue");

    public FormAddressTest(WebDriver driver){
        this.driver = driver;
    }

    public void validatePageTitle(){
        WebElement formShippingElement = driver.findElement(formShipping);
        assertTrue(formShippingElement.isDisplayed());
        assertEquals("Checkout: Your Information", formShippingElement.getText());

    }

    public void goToFormPage(){
        validatePageTitle();
    }

    public void fillingForm(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();
        validatePageTitle();
    }

    public void inputFirstName(String fName){
        driver.findElement(firstNameBox).sendKeys(fName);
    }

    public void inputLastName(String lName){
        driver.findElement(lastNameBox).sendKeys(lName);
    }

    public void inputPostalCode(String postCode){
        driver.findElement(postalCodeBox).sendKeys(postCode);
    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }

    public void validateErrorMessage(String errorMessage){
        assertTrue(driver.getPageSource().contains(errorMessage));
    }

    public void allStepsCheckout(){
        fillingForm();
        inputFirstName("zayn");
        inputLastName("malik");
        inputPostalCode("40374");
        clickContinueButton();
    }
}
