package com.qaprosoft.carina.demo.mytests.webtests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.saucedemo.components.SidebarMenu;
import com.qaprosoft.carina.demo.gui.saucedemo.components.SortingMenu;
import com.qaprosoft.carina.demo.gui.saucedemo.components.Item;
import com.qaprosoft.carina.demo.gui.saucedemo.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//import io.github.bionigarcia.wdm.WebDriverManager;

import java.lang.invoke.MethodHandles;

public class SaucedemoTests implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testLoginWithWrongCredentials () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        LoginPage loginPage = new LoginPage(driver);

        LOGGER.info("Opening page");
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");

        loginPage.fillUsername("qwerty");
        loginPage.fillPassword("12345678");
        loginPage.login();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error message is not present");

        driver.close();
    }

    @Test
    public void testLoginLogout() {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        LOGGER.info("Opening page");
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");

        LOGGER.info("Logging in");
        loginPage.fillAllFields();
        HomePage homePage = loginPage.login();
        Assert.assertTrue(homePage.isPageOpened(), "Login failed");

        LOGGER.info("Logging out");
        SidebarMenu sidebarMenu = homePage.openMenu();
        homePage.waitUntil(ExpectedConditions.elementToBeClickable(sidebarMenu.getLogoutButton().getElement()), 10);
        loginPage = sidebarMenu.logout();
        Assert.assertTrue(loginPage.isPageOpened(), "Logout failed");

        driver.close();
    }

    @Test
    public void testCart() {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        LOGGER.info("Opening page");
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");

        LOGGER.info("Logging in");
        loginPage.fillAllFields();
        HomePage homePage = loginPage.login();
        Assert.assertTrue(homePage.isPageOpened(), "Login failed");

        LOGGER.info("Add all items to the cart");
        homePage.addAllItemToCart();
        Assert.assertEquals(homePage.getItemsCountCart(), "6", "Unable to fill the cart");

        LOGGER.info("Going to cart");
        CartPage cartPage = homePage.clickCart();
        homePage.removeAllItemsFromCart();

        LOGGER.info("Return to the home page");
        homePage = cartPage.back();
        Assert.assertTrue(homePage.isPageOpened(), "Returning to the menu failed");

        driver.close();
    }

    @Test
    public void testItemPage() {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        LOGGER.info("Opening page");
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened.");

        LOGGER.info("Logging in");
        loginPage.fillAllFields();
        HomePage homePage = loginPage.login();
        Assert.assertTrue(homePage.isPageOpened(), "Login failed.");

        LOGGER.info("Selecting item");
        Item item = homePage.selectItem("Sauce Labs Backpack");
        String itemName = item.getItemName();
        String itemInfo = item.getItemInfo();
        String itemPrice = item.getItemPrice();

        LOGGER.info("Opening item page");
        ItemPage itemPage = item.openItemPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(itemPage.getItemName(), itemName, "Invalid item name.");
        softAssert.assertEquals(itemPage.getItemInfo(), itemInfo, "Invalid item description.");
        softAssert.assertEquals(itemPage.getItemPrice(), itemPrice, "Invalid item price.");
        softAssert.assertAll();

        LOGGER.info("Return to the home page");
        homePage = itemPage.backToHomePage();
        Assert.assertTrue(homePage.isPageOpened(), "Returning to the main page failed");

        driver.close();
    }

    @Test
    public void testSearch() {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        LOGGER.info("Opening page");
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened.");

        LOGGER.info("Logging in");
        loginPage.fillAllFields();

        HomePage homePage = loginPage.login();
        Assert.assertTrue(homePage.isPageOpened(), "Login failed.");

        LOGGER.info("sorting A to Z");
        SortingMenu sortingMenu = homePage.clickSort();
        homePage = sortingMenu.sortFromAtoZ();
        homePage.getAllItems().forEach(a -> LOGGER.info(a.getItemName()));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getAllItems().get(0).getItemName(), "Sauce Labs Backpack",
                "Sorting doesn't work");
        softAssert.assertEquals(homePage.getAllItems().get(1).getItemName(), "Sauce Labs Bike Light",
                "Sorting doesn't work");
        softAssert.assertEquals(homePage.getAllItems().get(2).getItemName(), "Sauce Labs Bolt T-Shirt",
                "Sorting doesn't work");

        LOGGER.info("sorting Z to A");
        sortingMenu = homePage.clickSort();
        homePage = sortingMenu.sortFromZtoA();
        homePage.getAllItems().forEach(a -> LOGGER.info(a.getItemName()));
        softAssert.assertEquals(homePage.getAllItems().get(0).getItemName(), "Test.allTheThings() T-Shirt (Red)",
                "Sorting doesn't work");
        softAssert.assertEquals(homePage.getAllItems().get(1).getItemName(), "Sauce Labs Onesie",
                "Sorting doesn't work");
        softAssert.assertEquals(homePage.getAllItems().get(2).getItemName(), "Sauce Labs Fleece Jacket",
                "Sorting doesn't work");

        LOGGER.info("sorting lower price to higher price");
        sortingMenu = homePage.clickSort();
        homePage = sortingMenu.sortFromLowToHigh();
        homePage.getAllItems().forEach(a -> LOGGER.info(a.getItemName() + " = " + a.getItemPrice()));
        softAssert.assertEquals(homePage.getAllItems().get(0).getItemPrice(), "$7.99",
                "Sorting doesn't work");
        softAssert.assertEquals(homePage.getAllItems().get(1).getItemPrice(), "$9.99",
                "Sorting doesn't work");
        softAssert.assertEquals(homePage.getAllItems().get(2).getItemPrice(), "$15.99",
                "Sorting doesn't work");

        LOGGER.info("sorting higher price to lower price");
        sortingMenu = homePage.clickSort();
        homePage = sortingMenu.sortFromHighToLow();
        homePage.getAllItems().forEach(a -> LOGGER.info(a.getItemName() + " = " + a.getItemPrice()));
        softAssert.assertEquals(homePage.getAllItems().get(0).getItemPrice(), "$49.99",
                "Sorting doesn't work");
        softAssert.assertEquals(homePage.getAllItems().get(1).getItemPrice(), "$29.99",
                "Sorting doesn't work");
        softAssert.assertEquals(homePage.getAllItems().get(2).getItemPrice(), "$15.99",
                "Sorting doesn't work");
        softAssert.assertAll();

        driver.close();
    }

    @Test
    public void testAllPages () {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        LOGGER.info("Started opening page");
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened.");

        LOGGER.info("Try to access values");
        loginPage.fillAllFields();

        HomePage homePage = loginPage.login();
        Assert.assertTrue(homePage.isPageOpened(), "Login failed.");

        SidebarMenu sidebarMenu = homePage.openMenu();
        homePage.waitUntil(ExpectedConditions.elementToBeClickable(sidebarMenu.getAllItemsButton().getElement()), 10);
        sidebarMenu.openAllItems();
        Assert.assertTrue(homePage.isPageOpened(), "Failed when try to open All Item page.");

        sidebarMenu.openAboutPage();
        Assert.assertEquals(sidebarMenu.getDriver().getCurrentUrl(), "https://saucelabs.com/",
                "Failed when try to open About page.");

        loginPage.open();
        loginPage.fillAllFields();
        homePage = loginPage.login();
        Assert.assertTrue(homePage.isPageOpened(), "Failed when try to open Home page.");

        homePage.selectItem("Sauce Labs Bike Light").addItemToCart();
        Assert.assertEquals(homePage.getItemsCountCart(), "1", "Something wrong with filling cart.");

        sidebarMenu = homePage.openMenu();
        sidebarMenu.waitUntil(ExpectedConditions.elementToBeClickable(sidebarMenu.getResetLink().getElement()), 10);
        sidebarMenu.openResetLink();
        homePage = sidebarMenu.closeMenu();

        Assert.assertFalse(homePage.isItemsPresent(), "Cart is not empty.");

        driver.close();
    }
}
