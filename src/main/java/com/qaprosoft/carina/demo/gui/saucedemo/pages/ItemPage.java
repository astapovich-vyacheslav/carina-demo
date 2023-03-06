package com.qaprosoft.carina.demo.gui.saucedemo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class,'inventory_details_name')]")
    private ExtendedWebElement itemName;

    @FindBy(xpath = "//div[contains(@class,'inventory_details_desc ')]")
    private ExtendedWebElement itemInfo;

    @FindBy(xpath = "//div[@class = 'inventory_details_price']")
    private ExtendedWebElement itemPrice;

    @FindBy(xpath = ".//button[contains(@id, 'back-to-products')]")
    private ExtendedWebElement backToHomePage;

    public ItemPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(itemName);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getItemInfo() {
        return itemInfo.getText();
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }

    public HomePage backToHomePage() {
        backToHomePage.click();
        return new HomePage(driver);
    }
}
