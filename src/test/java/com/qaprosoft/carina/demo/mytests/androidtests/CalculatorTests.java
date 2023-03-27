package com.qaprosoft.carina.demo.mytests.androidtests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.calculator.HistoryPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.calculator.MainPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.calculator.components.OptionsMenu;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Capabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CalculatorTests implements IAbstractTest, IMobileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static String ZERO_DIVISION;
    private static String FORMAT_ERROR;
    private static String NEGATIVE_SQRT;
    private static AndroidDriver driver;
    @BeforeClass
    public static void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, "D:\\JavaTestAutomation\\androidapps\\Calculator_8.4 (503542421)_Apkpure.apk");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            LOGGER.error(e.getMessage());
        }


        ZERO_DIVISION = R.TESTDATA.get("zero_division");
        FORMAT_ERROR = R.TESTDATA.get("format_error");
        NEGATIVE_SQRT = R.TESTDATA.get("negative_sqrt");
    }
    @Test
    public void testButtons() {
        MainPage mainPage = new MainPage(driver);
        mainPage.getClearButton().click();
        Assert.assertTrue(mainPage.getPreview().getText().isEmpty(), "Clear button error");
        Assert.assertTrue(mainPage.getFormula().getText().isEmpty(), "Clear button error");
        int i = 0;
        String cmpString = "";
        for (WebElement k:
             mainPage.getDigitKeys()) {
            k.click();
            cmpString += i;
            Assert.assertEquals(mainPage.getFormula().getText(), cmpString, "Button click error");
            i++;
        }
    }

    @Test
    public void testOperations() {
        MainPage mainPage = new MainPage(driver);
        mainPage.getClearButton().click();
        Assert.assertTrue(mainPage.getPreview().getText().isEmpty(), "Clear button error");
        Assert.assertTrue(mainPage.getFormula().getText().isEmpty(), "Clear button error");
        //Addition
        mainPage.getKey2().click();
        mainPage.getAddOp().click();
        mainPage.getKey2().click();
        Assert.assertEquals(mainPage.getFormula().getText(), "2+2", "Writing error");
        Assert.assertEquals(mainPage.getPreview().getText(), "4", "Adding error");
        //Multiplication
        mainPage.getMulOp().click();
        mainPage.getKey3().click();
        Assert.assertNotEquals(mainPage.getPreview().getText(), "12", "Operation order error");
        Assert.assertEquals(mainPage.getPreview().getText(), "8", "Multiplication error");
        //Equals
        mainPage.getEqualsButton().click();
        Assert.assertEquals(mainPage.getResult().getText(), "8", "Equals button error");
        //Division
        mainPage.getDivOp().click();
        mainPage.getKey4().click();
        Assert.assertEquals(mainPage.getPreview().getText(), "2", "Division button error");
        //Subtraction
        mainPage.getSubOp().click();
        mainPage.getKey2().click();
        Assert.assertEquals(mainPage.getPreview().getText(), "0", "Subtraction button error");
        //Equals
        mainPage.getEqualsButton().click();
        Assert.assertEquals(mainPage.getResult().getText(), "0", "Equals button error");
    }
    @Test
    public void testErrorInput() {
        MainPage mainPage = new MainPage(driver);
        mainPage.getClearButton().click();
        Assert.assertTrue(mainPage.getPreview().getText().isEmpty(), "Clear button error");
        Assert.assertTrue(mainPage.getFormula().getText().isEmpty(), "Clear button error");
        //zero division test
        mainPage.getKey1().click();
        mainPage.getDivOp().click();
        mainPage.getKey0().click();
        mainPage.getEqualsButton().click();
        Assert.assertEquals(mainPage.getPreview().getText(), ZERO_DIVISION, "No division by zero error message");
        mainPage.getClearButton().click();
        Assert.assertTrue(mainPage.getPreview().getText().isEmpty(), "Clear button error");
        Assert.assertTrue(mainPage.getFormula().getText().isEmpty(), "Clear button error");

        //wrong bracket test
        mainPage.getParenthesis().click();
        mainPage.getEqualsButton().click();
        Assert.assertEquals(mainPage.getPreview().getText(), FORMAT_ERROR, "No wrong format message");
        mainPage.getClearButton().click();
        Assert.assertTrue(mainPage.getPreview().getText().isEmpty(), "Clear button error");
        Assert.assertTrue(mainPage.getFormula().getText().isEmpty(), "Clear button error");

        //sqrt negative test
        mainPage.getSqrtOp().click();
        mainPage.getSubOp().click();
        mainPage.getKey1().click();
        mainPage.getEqualsButton().click();
        Assert.assertEquals(mainPage.getPreview().getText(), NEGATIVE_SQRT, "No negative sqrt message");
        mainPage.getClearButton().click();
        Assert.assertTrue(mainPage.getPreview().getText().isEmpty(), "Clear button error");
        Assert.assertTrue(mainPage.getFormula().getText().isEmpty(), "Clear button error");
    }

    @Test
    public void testOperationsOrder() {
        MainPage mainPage = new MainPage(driver);
        mainPage.getClearButton().click();
        Assert.assertTrue(mainPage.getPreview().getText().isEmpty(), "Clear button error");
        Assert.assertTrue(mainPage.getFormula().getText().isEmpty(), "Clear button error");

        mainPage.getKey2().click();
        mainPage.getAddOp().click();
        mainPage.getKey3().click();
        Assert.assertEquals(mainPage.getPreview().getText(), "5", "Addition error");
        mainPage.getMulOp().click();
        Assert.assertEquals(mainPage.getPreview().getText(), "5", "Update error");
        mainPage.getKey2().click();
        Assert.assertEquals(mainPage.getPreview().getText(), "8", "Wrong operation order");
        mainPage.getPowOp().click();
        Assert.assertEquals(mainPage.getPreview().getText(), "8", "Update error");
        mainPage.getKey4().click();
        Assert.assertEquals(mainPage.getPreview().getText(), "50", "Wrong operation order");
    }
    @Test
    public void testHistory() {
        MainPage mainPage = new MainPage(driver);
        mainPage.getClearButton().click();
        Assert.assertTrue(mainPage.getPreview().getText().isEmpty(), "Clear button error");
        Assert.assertTrue(mainPage.getFormula().getText().isEmpty(), "Clear button error");

        mainPage.getKey7().click();
        mainPage.getAddOp().click();
        mainPage.getKey3().click();
        Assert.assertEquals(mainPage.getFormula().getText(), "7+3", "Writing error");
        mainPage.getEqualsButton().click();
        Assert.assertEquals(mainPage.getResult().getText(), "10", "Addition error");
        OptionsMenu optionsMenu = mainPage.clickOnMoreOptions();
        Assert.assertTrue(optionsMenu.allElementsPresent());
        HistoryPage historyPage = optionsMenu.clickOnHistory();
        Assert.assertTrue(historyPage.allElementsPresent());
        Assert.assertEquals(historyPage.getHistoryFormula().getText(), "7+3", "History update error");
        historyPage.getBackButton().click();
        Assert.assertTrue(mainPage.allElementsPresent(), "Return button error");
    }
}
