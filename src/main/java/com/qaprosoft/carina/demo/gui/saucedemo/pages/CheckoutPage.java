package com.qaprosoft.carina.demo.gui.saucedemo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {
    @FindBy(xpath = "//input[@id='first-name']")
    private ExtendedWebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private ExtendedWebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private ExtendedWebElement zipCode;

    @FindBy(xpath = "//input[@id='continue']")
    private ExtendedWebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/checkout-step-one.html");
    }

    public void completeForm() {
        firstName.type("Testing");
        lastName.type("Checkout");
        zipCode.type("220018");
    }

    public CheckoutSecondPage clickContinue() {
        continueButton.click();
        return new CheckoutSecondPage(driver);
    }
}
