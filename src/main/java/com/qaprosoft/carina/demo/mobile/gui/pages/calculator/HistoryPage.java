package com.qaprosoft.carina.demo.mobile.gui.pages.calculator;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;

public class HistoryPage extends AbstractPage {
    @AndroidFindBy(id = "com.google.android.calculator:id/history_formula")
    private ExtendedWebElement historyFormula;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private ExtendedWebElement backButton;
    public HistoryPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getHistoryFormula() {
        return historyFormula;
    }

    public ExtendedWebElement getBackButton() {
        return backButton;
    }
}
