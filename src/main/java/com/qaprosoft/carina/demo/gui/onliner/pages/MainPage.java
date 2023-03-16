package com.qaprosoft.carina.demo.gui.onliner.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.db.models.onliner.Item;
import com.qaprosoft.carina.demo.gui.onliner.components.SearchResultMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"userbar\"]/div[1]/div/div/div[1]")
    private ExtendedWebElement signIn;

    @FindBy(xpath = "//*[@id=\"fast-search\"]/form/input[1]")
    private  ExtendedWebElement searchEdit;

    @FindBy(xpath = "//header/div[2]/div[1]/nav[1]/ul[1]/li[1]/a[2]/span[1]")
    private ExtendedWebElement catalog;

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private ExtendedWebElement searchElement;

    @FindBy(xpath ="//a[@class='category__title' and contains(text(),'Ноутбуки')]")
    private ExtendedWebElement menuLaptop;

    @FindBy(xpath = "//*[@id=\"search-page\"]/div[2]")
    private ExtendedWebElement searchResult;

    @FindBy(xpath = "//div[contains(@class,'result__item_product')]//div[contains(@class,'title')]")
    private List<ExtendedWebElement> searchResults;
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[3]")
    private ExtendedWebElement electronics;


    public boolean isCatalogPresent() {
        return catalog.isElementPresent();
    }

    public CatalogOnlinerPage clickOnCatalog() {
        catalog.click();
        return new CatalogOnlinerPage(driver);
    }
    public void clickOnElectronics() {
        electronics.click();
    }

    public boolean checkIsPresentSearchElement() {
        return searchElement.isElementPresent();
    }

    public void inputDataInSearch() {
        searchElement.type("Ноутбуки");
    }
    public void kk(){
        searchElement.hover();
    }

    public boolean checkIsPresentMenuLaptop(){
        return menuLaptop.isElementPresent();
    }


    public MainPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.onliner.by/");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public LoginPage clickSignInButton() {
        signIn.click();
        return new LoginPage(driver);
    }

    public ExtendedWebElement getSignIn() {
        return signIn;
    }

    public SearchResultMenu search(String input) {
        searchEdit.click();
        searchEdit.type(input);
        return new SearchResultMenu(getDriver());
    }
//        public ArrayList<String> search(String input) {
//        searchEdit.click();
//        searchEdit.type(input);
//        ArrayList<String> result = new ArrayList<>();
//        searchResults.forEach(r -> result.add(r.getText()));
//        return result;
//    }
}
