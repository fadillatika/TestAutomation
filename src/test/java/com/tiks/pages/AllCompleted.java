package com.tiks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AllCompleted {
    WebDriver driver;

    By completedTitle = By.xpath("//*[@id='header_container']/div[2]/span");

    public AllCompleted(WebDriver driver){
        this.driver = driver;
    }

    public void goToCompletedPage(){
        WebElement completedElement = driver.findElement(completedTitle);
        assertTrue(completedElement.isDisplayed());
        assertEquals("Checkout: Complete!", completedElement.getText());
    }
}
