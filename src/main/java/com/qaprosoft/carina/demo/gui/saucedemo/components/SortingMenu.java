package com.qaprosoft.carina.demo.gui.saucedemo.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.saucedemo.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SortingMenu extends AbstractUIObject {
    @FindBy(xpath = ".//select[@class='product_sort_container']//option[@value = 'az']")
    private ExtendedWebElement nameAtoZ;

    @FindBy(xpath = ".//select[@class='product_sort_container']//option[@value = 'za']")
    private ExtendedWebElement nameZtoA;

    @FindBy(xpath = ".//select[@class='product_sort_container']//option[@value = 'lohi']")
    private ExtendedWebElement priceLowToHigh;

    @FindBy(xpath = ".//select[@class='product_sort_container']//option[@value = 'hilo']")
    private ExtendedWebElement priceHighToLow;

    public SortingMenu(WebDriver driver) {
        super(driver);
    }

    public HomePage sortFromAtoZ () {
        nameAtoZ.click();
        return new HomePage(driver);
    }

    public HomePage sortFromZtoA () {
        nameZtoA.click();
        return new HomePage(driver);
    }

    public HomePage sortFromLowToHigh () {
        priceLowToHigh.click();
        return new HomePage(driver);
    }

    public HomePage sortFromHighToLow () {
        priceHighToLow.click();
        return new HomePage(driver);
    }
}
