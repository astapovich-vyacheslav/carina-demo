package com.qaprosoft.carina.demo.mobile.gui.pages.calculator.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.mobile.gui.pages.calculator.HistoryPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;

public class OptionsMenu extends AbstractUIObject {
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/" +
            "android.widget.RelativeLayout/android.widget.TextView")
    private ExtendedWebElement history;
    public OptionsMenu(WebDriver driver) {
        super(driver);
    }

    public HistoryPage clickOnHistory() {
        history.click();
        return new HistoryPage(driver);
    }
}
