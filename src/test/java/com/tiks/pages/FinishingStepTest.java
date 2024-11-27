package com.tiks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FinishingStepTest {
    WebDriver driver;

    By finishingTitle = By.xpath("//*[@id='header_container']/div[2]/span");
    By finishButton = By.id("finish");

    public FinishingStepTest (WebDriver driver){
        this.driver= driver;
    }

    public void goToFinishingPage(){
        WebElement finishingElement = driver.findElement(finishingTitle);
        assertTrue(finishingElement.isDisplayed());
        assertEquals("Checkout: Overview", finishingElement.getText());
    }

    public void clickButtonFinish(){
        driver.findElement(finishButton).click();
    }

}
