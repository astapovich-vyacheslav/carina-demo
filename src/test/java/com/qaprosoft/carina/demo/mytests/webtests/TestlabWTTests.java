package com.qaprosoft.carina.demo.mytests.webtests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.masscalculator.pages.MainPage;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestlabWTTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String NAME = "MyName";
    private static final int HEIGHT_OUT_OF_LIMIT = 500;
    private static final int WEIGHT_OUT_OF_LIMIT = 1000;

    @Test
    public static void ContainsWordsTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened(), "Page not opened");

        Assert.assertEquals(mainPage.getBannersTag().getText(), "banners", "No banners tag found");
        Assert.assertEquals(mainPage.getMenuTag().getText(), "menu", "No menu tag found");

        driver.close();
    }
    @Test
    public static void ContainsCopyrightTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened(), "Page not opened");

        Assert.assertTrue(mainPage.getCopyrightTag().getText().contains("CoolSoft by Somebody"), "No copyright string found");

        driver.close();
    }
    @Test
    public static void IsAllClearByDefaultTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened(), "Page not opened");

        Assert.assertTrue(mainPage.getHeightInput().getText().isEmpty(), "Height edit is not empty by default");
        Assert.assertTrue(mainPage.getWeightInput().getText().isEmpty(), "Weight edit is not empty by default");
        Assert.assertTrue(mainPage.getNameInput().getText().isEmpty(), "Name edit is not empty by default");
        Assert.assertFalse(mainPage.getMaleGenderButton().isChecked(), "Male gender button is checked by default");
        Assert.assertFalse(mainPage.getFemaleGenderButton().isChecked(), "Female gender button is checked by default");

        driver.close();
    }
    @Test
    public static void CalculateResultTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened(), "Page not opened");

        mainPage.enterName(NAME);
        mainPage.enterHeight(50);
        mainPage.enterWeight(3);
        mainPage.clickMale();
        mainPage.clickSubmit();

        Assert.assertNotEquals(mainPage.getNameInput(), null, "Name input is still present");
        Assert.assertNotEquals(mainPage.getHeightInput(), null, "Height input is still present");
        Assert.assertNotEquals(mainPage.getWeightInput(), null, "Weight input is still present");
        Assert.assertNotEquals(mainPage.getMaleGenderButton(), null, "Choose gender button (male) is still present");
        Assert.assertNotEquals(mainPage.getFemaleGenderButton(), null, "Choose gender button (female) is still present");

        //Assert.assertEquals(mainPage.getTextResult().getText(), "Слишком большая масса тела", "Wrong calculation result");
        Assert.assertEquals(mainPage.getTextResult().getText(), "Слишком малая масса тела", "Wrong calculation result");

        driver.close();
    }
    @Test
    public static void ContainsElementsTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened(), "Page not opened");

        Assert.assertEquals(mainPage.getInputs().size(), 3, "There must be 3 text inputs");
        Assert.assertEquals(mainPage.getGenderRadioButtonGroup().size(), 2, "There must be a group of 2 radiobuttons");
        Assert.assertNotEquals(mainPage.getSubmitButton(), null, "There must be a submit button");

        driver.close();
    }
    @Test
    public static void WrongInputTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened(), "Page not opened");

        mainPage.enterWeight(WEIGHT_OUT_OF_LIMIT);
        mainPage.enterHeight(HEIGHT_OUT_OF_LIMIT);
        mainPage.enterName(NAME);
        mainPage.clickMale();
        mainPage.clickSubmit();

        Assert.assertTrue(mainPage.getWrongInputMessage().getText().contains("Рост должен быть в диапазоне 50-300 см."),
                "No wrong height message");
        Assert.assertTrue(mainPage.getWrongInputMessage().getText().contains("Вес должен быть в диапазоне 3-500 кг."),
                "No wrong weight message");

        driver.close();
    }
    @Test
    public static void CurrentDateTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened(), "Page not opened");

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = currentDate.format(formatter);
        Assert.assertTrue(mainPage.getHeader().getText().contains(formattedDate), "Current date is not displayed");

        driver.close();
    }
}
