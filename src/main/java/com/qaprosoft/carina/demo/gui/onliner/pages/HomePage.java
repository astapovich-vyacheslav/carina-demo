package com.qaprosoft.carina.demo.gui.onliner.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.onliner.components.InfoMenu;
import com.qaprosoft.carina.demo.gui.onliner.components.SearchResultMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"userbar\"]/div/div[1]/a")
    private ExtendedWebElement infoMenu;
    @FindBy(xpath = "//*[@id=\"fast-search\"]/form/input[1]")
    private  ExtendedWebElement searchEdit;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getInfoMenu() {
        return infoMenu;
    }
    public InfoMenu clickInfoMenu() {
        infoMenu.click();
        return new InfoMenu(driver);
    }
    public SearchResultMenu search(String input) {
        searchEdit.click();
        searchEdit.type(input);
        return new SearchResultMenu(driver);
    }
}
