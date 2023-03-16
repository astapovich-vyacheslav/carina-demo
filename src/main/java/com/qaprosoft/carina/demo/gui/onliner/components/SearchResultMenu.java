package com.qaprosoft.carina.demo.gui.onliner.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.db.models.onliner.Item;
import com.qaprosoft.carina.demo.gui.onliner.pages.ItemPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultMenu extends AbstractUIObject {

    @FindBy(xpath = "//input[@type='checkbox'][1]")
    private ExtendedWebElement checkBox1;
    @FindBy(xpath = "//*[@id=\"search-page\"]/div[2]/ul/li[1]/div/div/div[2]/div/a")
    private ExtendedWebElement samsungA53link;
    @FindBy(xpath = "//*[@id=\"search-page\"]/div[2]")
    private ExtendedWebElement searchResult;
    @FindBy(xpath = "//div[contains(@class,'result__item_product')]//div[contains(@class,'title')]")
    private List<ExtendedWebElement> searchResults;
    public SearchResultMenu(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getCheckBox1() {
        return checkBox1;
    }

    public ItemPage samsungA53linkClick() {
        samsungA53link.click();
        return new ItemPage(getDriver());
    }

    public ArrayList<String> getItemNames() {
        ArrayList<String> result = new ArrayList<>();
        searchResults.forEach(r -> result.add(r.getText()));
        return result;
    }

    public ExtendedWebElement getSamsungA53link() {
        return samsungA53link;
    }
}
