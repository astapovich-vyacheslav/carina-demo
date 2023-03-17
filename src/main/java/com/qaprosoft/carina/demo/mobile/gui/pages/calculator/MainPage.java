package com.qaprosoft.carina.demo.mobile.gui.pages.calculator;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.calculator.components.OptionsMenu;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AbstractPage{
    @AndroidFindBy(id = "com.google.android.calculator:id/digit_1")
    private ExtendedWebElement key1;
    @AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
    private ExtendedWebElement key2;
    @AndroidFindBy(id = "com.google.android.calculator:id/digit_3")
    private ExtendedWebElement key3;
    @AndroidFindBy(id = "com.google.android.calculator:id/digit_4")
    private ExtendedWebElement key4;
    @AndroidFindBy(id = "com.google.android.calculator:id/digit_5")
    private ExtendedWebElement key5;
    @AndroidFindBy(id = "com.google.android.calculator:id/digit_6")
    private ExtendedWebElement key6;
    @AndroidFindBy(id = "com.google.android.calculator:id/digit_7")
    private ExtendedWebElement key7;
    @AndroidFindBy(id = "com.google.android.calculator:id/digit_8")
    private ExtendedWebElement key8;
    @AndroidFindBy(id = "com.google.android.calculator:id/digit_9")
    private ExtendedWebElement key9;
    @AndroidFindBy(id = "com.google.android.calculator:id/digit_0")
    private ExtendedWebElement key0;
    @AndroidFindBy(id = "com.google.android.calculator:id/op_div")
    private ExtendedWebElement divOp;
    @AndroidFindBy(id = "com.google.android.calculator:id/op_mul")
    private ExtendedWebElement mulOp;
    @AndroidFindBy(id = "com.google.android.calculator:id/op_sub")
    private ExtendedWebElement subOp;
    @AndroidFindBy(id = "com.google.android.calculator:id/op_add")
    private ExtendedWebElement addOp;
    @AndroidFindBy(id = "com.google.android.calculator:id/op_sqrt")
    private ExtendedWebElement sqrtOp;
    @AndroidFindBy(id = "com.google.android.calculator:id/op_pow")
    private ExtendedWebElement powOp;
    @AndroidFindBy(id = "com.google.android.calculator:id/formula")
    private ExtendedWebElement formula;
    @AndroidFindBy(id = "com.google.android.calculator:id/formula_container")
    private ExtendedWebElement formulaContainer;
    @AndroidFindBy(id = "com.google.android.calculator:id/result_preview")
    private ExtendedWebElement preview;
    @AndroidFindBy(id = "com.google.android.calculator:id/eq")
    private ExtendedWebElement equalsButton;
    @AndroidFindBy(id = "com.google.android.calculator:id/clr")
    private ExtendedWebElement clearButton;
    @AndroidFindBy(id = "com.google.android.calculator:id/parens")
    private ExtendedWebElement parenthesis;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"More options\"]")
    private ExtendedWebElement moreOptions;
    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    private ExtendedWebElement result;

    private final List<WebElement> digitKeys;



    public MainPage(WebDriver driver) {
        super(driver);
        digitKeys = new ArrayList<>();
        String idPart = "com.google.android.calculator:id/digit_";
        for (int i = 0; i < 10; i++) {
            digitKeys.add(driver.findElement(By.id(idPart + Integer.toString(i))));
        }
    }

    public ExtendedWebElement getKey1() {
        return key1;
    }

    public ExtendedWebElement getKey2() {
        return key2;
    }

    public ExtendedWebElement getKey3() {
        return key3;
    }

    public ExtendedWebElement getKey4() {
        return key4;
    }

    public ExtendedWebElement getKey5() {
        return key5;
    }

    public ExtendedWebElement getKey6() {
        return key6;
    }

    public ExtendedWebElement getKey7() {
        return key7;
    }

    public ExtendedWebElement getKey8() {
        return key8;
    }

    public ExtendedWebElement getKey9() {
        return key9;
    }

    public ExtendedWebElement getKey0() {
        return key0;
    }

    public ExtendedWebElement getFormula() {
        return formula;
    }

    public List<WebElement> getDigitKeys() {
        return digitKeys;
    }

    public ExtendedWebElement getDivOp() {
        return divOp;
    }

    public ExtendedWebElement getMulOp() {
        return mulOp;
    }

    public ExtendedWebElement getSubOp() {
        return subOp;
    }

    public ExtendedWebElement getAddOp() {
        return addOp;
    }

    public ExtendedWebElement getPreview() {
        return preview;
    }

    public ExtendedWebElement getEqualsButton() {
        return equalsButton;
    }

    public ExtendedWebElement getFormulaContainer() {
        return formulaContainer;
    }

    public ExtendedWebElement getClearButton() {
        return clearButton;
    }

    public ExtendedWebElement getParenthesis() {
        return parenthesis;
    }

    public ExtendedWebElement getSqrtOp() {
        return sqrtOp;
    }

    public ExtendedWebElement getPowOp() {
        return powOp;
    }

    public ExtendedWebElement getResult() {
        return result;
    }
    public OptionsMenu clickOnMoreOptions() {
        moreOptions.click();
        return new OptionsMenu(driver);
    }
}
