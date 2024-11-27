package com.tiks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpecsInfoTest {
    WebDriver driver;

    By itemName = By.cssSelector("[data-test='inventory-item-name']");


    public SpecsInfoTest(WebDriver driver){
        this.driver = driver;
    }

    public void goToSpecsInfo(String expectedItem){
        WebElement itemNameElement = driver.findElement(itemName);
        assertTrue(itemNameElement.isDisplayed());
        assertEquals(expectedItem, itemNameElement.getText());
    }
}
