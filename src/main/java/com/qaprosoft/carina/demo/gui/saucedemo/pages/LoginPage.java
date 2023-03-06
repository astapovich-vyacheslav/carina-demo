package com.qaprosoft.carina.demo.gui.saucedemo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(id = "user-name")
    private ExtendedWebElement username;

    @FindBy(id = "password")
    private ExtendedWebElement password;

    @FindBy(id = "login-button")
    private ExtendedWebElement buttonLogIn;

    @FindBy(xpath = "//h3[@data-test='error']")
    private ExtendedWebElement errorWindow;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(username);
    }

    public HomePage login() {
        buttonLogIn.click();
        return new HomePage(driver);
    }

    public void fillAllFields() {
        username.type("standard_user");
        password.type("secret_sauce");
    }

    public boolean isErrorWindowPresent() {
        return errorWindow.isElementPresent();
    }

    public String getErrorMessage() {
        return errorWindow.getText();
    }

    public void fillUsername(String userName) {
        username.type(userName);
    }

    public void fillPassword(String passWord) {
        password.type(passWord);
    }
}
