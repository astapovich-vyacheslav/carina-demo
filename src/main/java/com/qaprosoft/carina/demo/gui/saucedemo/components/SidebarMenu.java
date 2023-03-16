package com.qaprosoft.carina.demo.gui.saucedemo.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.saucedemo.pages.HomePage;
import com.qaprosoft.carina.demo.gui.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SidebarMenu extends AbstractUIObject {
    @FindBy(id = "inventory_sidebar_link")
    private ExtendedWebElement inventoryLink;

    @FindBy(id = "about_sidebar_link")
    private ExtendedWebElement aboutLink;

    @FindBy(id = "logout_sidebar_link")
    private ExtendedWebElement logoutLink;
    @FindBy(id = "reset_sidebar_link")
    private ExtendedWebElement resetLink;

    @FindBy(xpath = ".//button[contains(@id, 'react-burger-cross-btn')]")
    private ExtendedWebElement closeMenuButton;

    public SidebarMenu(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com");
    }

    public LoginPage logout () {
        logoutLink.click();
        return new LoginPage(driver);
    }

    public void openAllItems () {
        inventoryLink.click();
    }

    public void openAboutPage () {
        aboutLink.click();
    }

    public void openResetLink () {
        resetLink.click();
    }

    public HomePage closeMenu () {
        closeMenuButton.click();
        return new HomePage(driver);
    }

    public ExtendedWebElement getLogoutButton() {
        return logoutLink;
    }
    public ExtendedWebElement getAllItemsButton() {
        return inventoryLink;
    }
    public ExtendedWebElement getResetLink() {
        return resetLink;
    }

}
