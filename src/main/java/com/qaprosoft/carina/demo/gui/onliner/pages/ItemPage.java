package com.qaprosoft.carina.demo.gui.onliner.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends AbstractPage
{
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div[4]/h1")
    private ExtendedWebElement itemName;
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/main/div/div/div[1]/div[2]/div[5]/div[1]/div/a")
    private ExtendedWebElement itemPrice;
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getItemName() {
        return itemName;
    }

    public ExtendedWebElement getItemPrice() {
        return itemPrice;
    }
}
