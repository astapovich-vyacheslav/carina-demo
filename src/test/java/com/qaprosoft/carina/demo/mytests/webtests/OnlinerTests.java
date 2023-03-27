package com.qaprosoft.carina.demo.mytests.webtests;

import com.qaprosoft.carina.demo.db.models.onliner.Laptop;
import com.qaprosoft.carina.demo.gui.onliner.components.InfoMenu;
import com.qaprosoft.carina.demo.gui.onliner.components.SortingMenu;
import com.qaprosoft.carina.demo.gui.onliner.pages.*;

import com.qaprosoft.carina.demo.utils.utilsOnliner.FilterChecker;
import com.qaprosoft.carina.demo.utils.utilsOnliner.LaptopBuilder;
import com.zebrunner.carina.utils.R;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

@SuppressWarnings("SpellCheckingInspection")
public class OnlinerTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static String username;
    private static String password;
    private static String invalidUsername;
    private static String invalidPassword;
    @BeforeClass
    public static void setUp() {
        username = R.TESTDATA.get("onliner_username");
        password = R.TESTDATA.get("password");
        invalidPassword = R.TESTDATA.get("invalid_password");
        invalidUsername = R.TESTDATA.get("invalid_onliner_username");
    }
    @Test
    public void testLoginLogout() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Opening page");
        mainPage.open();
        Assert.assertTrue(mainPage.getSignIn().isElementPresent(), "Sign in button not found");

        LoginPage loginPage = mainPage.clickSignInButton();
        Assert.assertTrue(loginPage.getPasswordForm().isElementPresent(), "Password form not found");
        Assert.assertTrue(loginPage.getUsernameForm().isElementPresent(), "Username form not found");
        Assert.assertTrue(loginPage.getSignInButton().isElementPresent(), "Sign in button not found");

        LOGGER.info("Logging in");
        loginPage.fillCredentials(username, password);
        HomePage homePage = loginPage.login();
        //CAPCHA!
        loginPage.waitUntil(ExpectedConditions.elementToBeClickable(homePage.getInfoMenu().getElement()), 100);
        Assert.assertTrue(homePage.getInfoMenu().isElementPresent(), "info menu is not present");

        LOGGER.info("Opening info menu");
        InfoMenu infoMenu = homePage.clickInfoMenu();
        mainPage = infoMenu.logoutButtonClick();

        LOGGER.info("Logging out");
        Assert.assertTrue(mainPage.getSignIn().isElementPresent(), "Sign in button not found");
        driver.close();
    }

    //тест проверки нахождения определенной модели ноутбука Lenovo MateBook D 15 AMD BoM-WDQ9 53013JJX
    @Test
    public void testLenovoLaptopSearch() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Opening page");
        mainPage.open();
        Assert.assertTrue(mainPage.isCatalogPresent(), "Catalog is not found");
        CatalogOnlinerPage catalogOnlinerPage = mainPage.clickOnCatalog();
        Assert.assertTrue(catalogOnlinerPage.isComputerMenuPresent(), "Computer and Network is not found");
        catalogOnlinerPage.clickMenuItemComputerAndNetwork();
        Assert.assertTrue(catalogOnlinerPage.checkIsPresentMenuItemLaptop(), "Item Menu Laptop is not found");
        catalogOnlinerPage.clickMenuItemLaptop();
        Assert.assertTrue(catalogOnlinerPage.checkIsPresentLinkLaptop(), "Link laptop is not found");
        catalogOnlinerPage.clickOnLinkLaptop();
        Assert.assertTrue(catalogOnlinerPage.isLenovoLaptopPresent(), "Laptop Lenovo is not found");
        catalogOnlinerPage.clickOnLenovoLaptop();
        Laptop expectedLaptop = LaptopBuilder.createExpectedLaptop();
        Laptop actualLaptop = catalogOnlinerPage.getActualLaptop();
        Assert.assertEquals(actualLaptop, expectedLaptop, "Laptop Lenovo is not found");
        driver.close();
    }

    @Test
    public void testSmartphoneSorting() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Opening page");
        mainPage.open();
        Assert.assertTrue(mainPage.isCatalogPresent(), "Catalog is not found");
        CatalogOnlinerPage catalogOnlinerPage = mainPage.clickOnCatalog();
        Assert.assertTrue(catalogOnlinerPage.isElectronicsMenuPresent(), "Electronics menu is not found");
        catalogOnlinerPage.clickElectronicsMenu();
        Assert.assertTrue(catalogOnlinerPage.getMobilePhonesAndAccessories().isElementPresent(), "Mobile phones and accessories are not found");
        catalogOnlinerPage.mobilePhonesAndAccessoriesClick();
        catalogOnlinerPage.waitUntil(ExpectedConditions.elementToBeClickable(catalogOnlinerPage.getSmartphonesLink().getElement()), 10);
        Assert.assertTrue(catalogOnlinerPage.getSmartphonesLink().isElementPresent(), "Smartphones link is not found");
        catalogOnlinerPage.clickOnSmartphonesLink();
        Assert.assertTrue(catalogOnlinerPage.getSortingMenuElement().isElementPresent(), "Sorting menu is not found");
        SortingMenu sortingMenu = catalogOnlinerPage.ClickOnSortingMenuElement();
        Assert.assertTrue(sortingMenu.getCheaperButton().isElementPresent(), "Sorting by price ascending button is not found");
        sortingMenu.cheaperButtonClick();
        Assert.assertTrue(FilterChecker.isSortedByPriceAscending(catalogOnlinerPage.getPrices()), "Products are not sorted correctly");
        driver.close();
    }

    @Test
    public void testLoginWithWrongCredentials() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Opening page");
        mainPage.open();
        Assert.assertTrue(mainPage.getSignIn().isElementPresent(), "Sign in button not found");

        LoginPage loginPage = mainPage.clickSignInButton();
        Assert.assertTrue(loginPage.getPasswordForm().isElementPresent(), "Password form not found");
        Assert.assertTrue(loginPage.getUsernameForm().isElementPresent(), "Username form not found");
        Assert.assertTrue(loginPage.getSignInButton().isElementPresent(), "Sign in button not found");

        LOGGER.info("Logging in");
        loginPage.fillCredentials(invalidUsername, invalidPassword);
        loginPage.login();
        loginPage.waitUntil(ExpectedConditions.elementToBeClickable(loginPage.getInfoText().getElement()), 100);
        Assert.assertEquals(loginPage.getInfoText().getText(), "Неверный логин или пароль", "No wrong input message");
        driver.close();
    }
    @Test
    public void testAddingToComparison() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Opening page");
        mainPage.open();
        Assert.assertTrue(mainPage.isCatalogPresent(), "Catalog is not found");
        CatalogOnlinerPage catalogOnlinerPage = mainPage.clickOnCatalog();
        Assert.assertTrue(catalogOnlinerPage.isElectronicsMenuPresent(), "Electronics menu not found");
        catalogOnlinerPage.clickElectronicsMenu();
        Assert.assertTrue(catalogOnlinerPage.getMobilePhonesAndAccessories().isElementPresent(), "Mobile phones and accessories are not found");
        catalogOnlinerPage.mobilePhonesAndAccessoriesClick();
        catalogOnlinerPage.waitUntil(ExpectedConditions.elementToBeClickable(catalogOnlinerPage.getSmartphonesLink().getElement()), 10);
        Assert.assertTrue(catalogOnlinerPage.getSmartphonesLink().isElementPresent(), "Smartphones link is not found");
        catalogOnlinerPage.clickOnSmartphonesLink();
        catalogOnlinerPage.waitUntil(ExpectedConditions.elementToBeClickable(catalogOnlinerPage.getProductList().getElement()), 10);
        Assert.assertFalse(catalogOnlinerPage.getToComparisonLabels().isEmpty(), "Smartphones link is not found");
        catalogOnlinerPage.addFirstToComparison();
        Assert.assertEquals(catalogOnlinerPage.getInComparison().getText(), "1 товар", "Adding to comparison error");
        driver.close();
    }
}
