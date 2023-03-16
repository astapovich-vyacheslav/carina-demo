package com.qaprosoft.carina.demo.gui.onliner.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.onliner.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.onliner.pages.MainPage;
import groovy.util.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InfoMenu extends AbstractUIObject {
    @FindBy(xpath = "//*[@id=\"userbar\"]/div/div[1]/div/div[1]/div[1]/div[2]/div/a")
    private ExtendedWebElement logoutButton;
    public InfoMenu(WebDriver driver) {
        super(driver);
    }

    public MainPage logoutButtonClick() {
        logoutButton.click();
        return new MainPage(driver);
    }
}
