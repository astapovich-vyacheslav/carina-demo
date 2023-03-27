package com.qaprosoft.carina.demo.gui.onliner.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SortingMenu extends AbstractUIObject {
    @FindBy(xpath = "//*[@id=\"schema-order\"]/div[2]/div/div[2]/span")
    private ExtendedWebElement cheaperButton;
    public SortingMenu(WebDriver driver) {
        super(driver);
    }
    public void cheaperButtonClick() {
        cheaperButton.click();
    }

    public ExtendedWebElement getCheaperButton() {
        return cheaperButton;
    }
}
