package com.qaprosoft.carina.demo.gui.onliner.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div/div/input")
    private ExtendedWebElement usernameForm;
    @FindBy(xpath = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div/div/div/input")
    private ExtendedWebElement passwordForm;
    @FindBy(xpath = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[3]/button")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[3]/div")
    private ExtendedWebElement infoText;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillCredentials(String username, String password) {
        usernameForm.type(username);
        passwordForm.type(password);
    }

    public HomePage login() {
        signInButton.click();
        return new HomePage(driver);
    }

    public ExtendedWebElement getUsernameForm() {
        return usernameForm;
    }

    public ExtendedWebElement getPasswordForm() {
        return passwordForm;
    }

    public ExtendedWebElement getSignInButton() {
        return signInButton;
    }

    public ExtendedWebElement getInfoText() {
        return infoText;
    }
}
