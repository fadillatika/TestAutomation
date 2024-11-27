package com.tiks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest {
    WebDriver driver;

    By productTitle = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    By buttonSort = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");
    By sortByPrice = By.className("inventory_item_price");
    By cartBadge = By.className("shopping_cart_badge");
    By cartLink = By.className("shopping_cart_link");
    public HomePageTest (WebDriver driver) {

        this.driver = driver;
    }

    public void goToHomePage(){
        WebElement productElement = driver.findElement(productTitle);
        assertTrue(productElement.isDisplayed());
        assertEquals("Sauce Labs Backpack", productElement.getText());
    }

    public void sortingItems(){
        driver.findElement(buttonSort).click();
    }

    public void dropDownOptions(String filterOption){
        WebElement dropDownElement = driver.findElement(buttonSort);
        Select select = new Select(dropDownElement);
        select.selectByVisibleText(filterOption);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyItemSorted(){
        List<WebElement> productPrices = driver.findElements(sortByPrice);
        List<Double> prices = new ArrayList<>();

        for (WebElement priceElement : productPrices) {
            String priceText = priceElement.getText().replace("$", "").replace(",", "");
            prices.add(Double.parseDouble(priceText));
        }

        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        assertTrue("Produk tidak terurut dengan benar", prices.equals(sortedPrices));
    }

    public void addItemToCart(String product){
        WebElement addToCartButton = driver.findElement( By.id("add-to-cart-" + product.toLowerCase().replace(" ", "-")));
        addToCartButton.click();
    }

    public void verifyProductAdded(String totalItem){
        String itemCount = driver.findElement(cartBadge).getText();
        assertEquals(totalItem, itemCount);
    }

    public void clickCartIcon(){
        driver.findElement(cartLink).click();
    }

    public void clickItem(String itemSpec){
        WebElement itemTitle = driver.findElement(By.linkText(itemSpec));
        itemTitle.click();
    }
}
