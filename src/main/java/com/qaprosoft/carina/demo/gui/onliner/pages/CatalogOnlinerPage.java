package com.qaprosoft.carina.demo.gui.onliner.pages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.db.models.onliner.Laptop;
import com.qaprosoft.carina.demo.gui.onliner.components.SortingMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CatalogOnlinerPage extends AbstractPage {

    @FindBy(xpath = "//span[@class='catalog-navigation-classifier__item-title-wrapper' and contains(text(),'Компьютеры')]")
    private ExtendedWebElement itemMenuComputerAndNetwork;
    @FindBy(xpath = "//span[@class='catalog-navigation-classifier__item-title-wrapper' and contains(text(),'Электроника')]")
    private ExtendedWebElement itemMenuElectronics;
    //@FindBy(xpath = "//a[@href='https://catalog.onliner.by/mobile?mobile_type%5B0%5D=smartphone&mobile_type%5Boperation%5D=union']")
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[1]/div[4]/div/div[2]/div[1]/div/div[1]/div[2]/div/a[1]/span")
    private ExtendedWebElement smartphonesLink;

    @FindBy(xpath = "//span[@class='catalog-navigation-classifier__item-title-wrapper']")
    private List<ExtendedWebElement> menuItemElementList;

    @FindBy(xpath = "//div[@class='catalog-navigation-list__aside-title' and contains(text(),'Ноутбуки, компьютеры, мониторы')]")
    private ExtendedWebElement itemMenuLaptop;
    @FindBy(xpath = "//div[@class='catalog-navigation-list__aside-title' and contains(text(),'Мобильные телефоны')]")
    //@FindBy(xpath = "//div[@class='catalog-navigation-list__aside-title' and contains(text(),'Мобильные телефоны')]")
    private ExtendedWebElement mobilePhonesAndAccessories;

    @FindBy(xpath = "//a[@href='https://catalog.onliner.by/notebook']")
    private ExtendedWebElement laptopLink;

    @FindBy(xpath = "//*[@id=\"schema-products\"]/div[5]/div/div[3]/div[2]/div[1]/a/span")
    private ExtendedWebElement lenovoIdeaPadLaptop;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div[4]/h1")
    private ExtendedWebElement laptopName;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/main/div/div/div[1]/div[2]/div[5]/div[1]/div/a")
    private ExtendedWebElement laptopPrice;

    @FindBy(xpath = "//label[contains(@class, 'schema-product__control')]")
    private List<ExtendedWebElement> toComparisonLabels;
    @FindBy(xpath = "//*[@id=\"schema-order\"]/a")
    private ExtendedWebElement sortingMenuElement;
    @FindBy(xpath = "//*[@id=\"compare-button-container\"]/div/div[1]/div/div/div[1]/a[2]/span")
    private ExtendedWebElement inComparison;

    @FindBy(xpath = "//*[@id=\"schema-products\"]/div[2]")
    private ExtendedWebElement productList;
    @FindBy(xpath = "//a[contains(@class,'schema-product__price-value schema-product__price-value_primary js-product-price-link')]")
    private List<ExtendedWebElement> prices;


    public List<String> getTextListItemOfMenu() {
        List<String> getMenuItemList = new ArrayList<>();

        for (ExtendedWebElement menuItemElement : menuItemElementList) {
            getMenuItemList.add(menuItemElement.getText());
        }
        return getMenuItemList;
    }

    public boolean checkIsPresentMenuItemElement() {
        for (ExtendedWebElement menuItemElement : menuItemElementList) {
            menuItemElement.isElementPresent();
        }
        return true;
    }

    public boolean isComputerMenuPresent() {
        return itemMenuComputerAndNetwork.isElementPresent();
    }
    public boolean isElectronicsMenuPresent() {
        return itemMenuElectronics.isElementPresent();
    }

    public void clickMenuItemComputerAndNetwork() {
        itemMenuComputerAndNetwork.click();
    }
    public void mobilePhonesAndAccessoriesClick() {
        mobilePhonesAndAccessories.hover();
    }

    public boolean checkIsPresentMenuItemLaptop() {
        return itemMenuLaptop.isElementPresent();
    }

    public void clickMenuItemLaptop() {
        itemMenuLaptop.click();
    }
    public void clickElectronicsMenu() {
        itemMenuElectronics.click();
    }

    public boolean checkIsPresentLinkLaptop() {
        return laptopLink.isElementPresent();
    }

    public void clickOnLinkLaptop() {
        laptopLink.click();
    }
    public void clickOnSmartphonesLink() {
        smartphonesLink.click();
    }

    public boolean isLenovoLaptopPresent() {
        return lenovoIdeaPadLaptop.isElementPresent();
    }

    public void clickOnLenovoLaptop() {
        lenovoIdeaPadLaptop.click();
    }


    public Laptop getActualLaptop() {
        Laptop laptopActual = new Laptop();
        laptopActual.setItemName(laptopName.getText());
        laptopActual.setItemPrice(laptopPrice.getText());
        return laptopActual;

    }


    public SortingMenu ClickOnSortingMenuElement() {
        sortingMenuElement.click();
        return new SortingMenu(driver);
    }

    public CatalogOnlinerPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getSmartphonesLink() {
        return smartphonesLink;
    }

    public List<ExtendedWebElement> getPrices() {
        return prices;
    }
    public void addFirstToComparison() {
        toComparisonLabels.get(0).click();
    }

    public ExtendedWebElement getInComparison() {
        return inComparison;
    }

    public List<ExtendedWebElement> getToComparisonLabels() {
        return toComparisonLabels;
    }

    public ExtendedWebElement getProductList() {
        return productList;
    }
}
