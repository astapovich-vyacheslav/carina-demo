package com.qaprosoft.carina.demo.gui.saucedemo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CompletePage extends AbstractPage {
    @FindBy(xpath = "//button[@id='back-to-products']")
    private ExtendedWebElement homePageButton;

    public CompletePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/checkout-complete.html");
    }

    public HomePage backToHomePage() {
        homePageButton.click();
        return new HomePage(driver);
    }
}
