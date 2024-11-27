package com.tiks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutTest {
    WebDriver driver;

    By cartTitle = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By itemNameList = By.className("inventory_item_name");
    By checkoutButton = By.id("checkout");

    public CheckoutTest (WebDriver driver){
        this.driver = driver;
    }

    public void goToCartPage(){
        WebElement cartElement = driver.findElement(cartTitle);
        assertTrue(cartElement.isDisplayed());
        assertEquals("Your Cart", cartElement.getText());
    }

    public void verifyListItems(List<String> expectedItem) {
        List<WebElement> cartItem = driver.findElements(itemNameList);

        List<String> actualItem = new ArrayList<>();
        for (WebElement item : cartItem) {
            actualItem.add(item.getText());
        }
        for (String expectedItems : expectedItem) {
            assertTrue(actualItem.contains(expectedItems));
        }
    }

    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }
}
