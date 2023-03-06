package com.qaprosoft.carina.demo.gui.saucedemo.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.saucedemo.pages.ItemPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Item extends AbstractUIObject {
    @FindBy(xpath = ".//div[@class = 'inventory_item_name']")
    private ExtendedWebElement itemName;

    @FindBy(xpath = ".//div[@class = 'inventory_item_desc']")
    private ExtendedWebElement itemInfo;

    @FindBy(xpath = ".//div[@class='inventory_item_price']")
    private ExtendedWebElement itemPrice;

    @FindBy(xpath = ".//button[contains(@id, 'add-to-cart')]")
    private ExtendedWebElement addItemToCart;

    @FindBy(xpath = ".//button[contains(@id, 'remove')]")
    private ExtendedWebElement removeItemFromCart;

    public Item(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getItemName () {
        return itemName.getText();
    }

    public String getItemInfo () {
        return itemInfo.getText();
    }

    public String getItemPrice () {
        return itemPrice.getText();
    }

    public void addItemToCart () {
        addItemToCart.click();
    }

    public void removeItemFromCart () {
        removeItemFromCart.click();
    }

    public ItemPage openItemPage () {
        itemName.click();
        return new ItemPage(driver);
    }
}
