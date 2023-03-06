package com.qaprosoft.carina.demo.gui.saucedemo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.saucedemo.components.DropDownMenu;
import com.qaprosoft.carina.demo.gui.saucedemo.components.SortingMenu;
import com.qaprosoft.carina.demo.gui.saucedemo.components.Item;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {
    @FindBy(id = "react-burger-menu-btn")
    private ExtendedWebElement dropDownMenu;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']//span")
    private ExtendedWebElement cartItemsNumber;

    @FindBy(xpath = "//div[@class = 'inventory_item']")
    private List<Item> itemList;

    @FindBy(xpath = ".//select[@class='product_sort_container']")
    private ExtendedWebElement sortContainer;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/inventory.html");
    }

    public DropDownMenu openMenu() {
        dropDownMenu.click();
        return new DropDownMenu(driver);
    }

    public boolean isItemsPresent() {
        return cartItemsNumber.isElementPresent(1);
    }

    public String getItemsCountCart() {
        return cartItemsNumber.getText();
    }

    public CartPage clickCart() {
        cartButton.click();
        return new CartPage(driver);
    }

    public void addAllItemToCart () {
        for (Item item : itemList) {
            item.addItemToCart();
        }
    }

    public void removeAllItemsFromCart () {
        for (Item item : itemList) {
            item.removeItemFromCart();
        }
    }

    public Item selectItem (String itemName) {
        for (Item item : itemList) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        throw new RuntimeException("Item was not found on this page.");
    }

    public SortingMenu clickSort () {
        sortContainer.click();
        return new SortingMenu(driver);
    }

    public List<Item> getAllItems () {
        return itemList;
    }
}
