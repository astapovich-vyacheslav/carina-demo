package com.qaprosoft.carina.demo.gui.masscalculator.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends AbstractPage {
    @FindBy(xpath = "//td[contains(text(), 'menu')]")
    private ExtendedWebElement menuTag;
    @FindBy(xpath = "//td[contains(text(), 'banners')]")
    private ExtendedWebElement bannersTag;
    @FindBy(xpath = "//td[contains(text(), 'CoolSoft by Somebody')]")
    private ExtendedWebElement copyrightTag;
    @FindBy(xpath = "//input[contains(@type, 'text') and contains(@name, 'name')]")
    private ExtendedWebElement nameInput;
    @FindBy(xpath = "//input[contains(@type, 'text') and contains(@name, 'height')]")
    private ExtendedWebElement heightInput;
    @FindBy(xpath = "//input[contains(@type, 'text') and contains(@name, 'weight')]")
    private ExtendedWebElement weightInput;
    @FindBy(xpath = "//input[contains(@type, 'radio') and contains(@name, 'gender') and contains(@value, 'f')]")
    private ExtendedWebElement femaleGenderButton;
    @FindBy(xpath = "//input[contains(@type, 'radio') and contains(@name, 'gender') and contains(@value, 'm')]")
    private ExtendedWebElement maleGenderButton;
    @FindBy(xpath = "//input[contains(@type, 'submit')]")
    private ExtendedWebElement submitButton;
    @FindBy(xpath = "//td[contains(text(), 'масса тела')]")
    private ExtendedWebElement textResult;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td[2]/form/table/tbody/tr[1]/td")
    private ExtendedWebElement wrongInputMessage;
    @FindBy(xpath = "//td[contains(text(), 'Расчёт веса')]")
    private ExtendedWebElement header;
    @FindBy(xpath = "//input[contains(@name, 'gender')]")
    private List<ExtendedWebElement> genderRadioButtonGroup;
    @FindBy(xpath = "//input[contains(@type, 'text')]")
    private List<ExtendedWebElement> inputs;
    public MainPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("http://svyatoslav.biz/testlab/wt/");
    }
    public void enterName(String name) {
        nameInput.type(name);
    }
    public void enterWeight(int w) {
        weightInput.type(Integer.toString(w));
    }
    public void enterHeight(int h) {
        heightInput.type(Integer.toString(h));
    }
    public void clickMale() {
        maleGenderButton.click();
    }
    public void clickFemale() {
        femaleGenderButton.click();
    }
    public void clickSubmit() {
        submitButton.click();
    }

    public ExtendedWebElement getMenuTag() {
        return menuTag;
    }

    public ExtendedWebElement getBannersTag() {
        return bannersTag;
    }

    public ExtendedWebElement getCopyrightTag() {
        return copyrightTag;
    }

    public ExtendedWebElement getNameInput() {
        return nameInput;
    }

    public ExtendedWebElement getHeightInput() {
        return heightInput;
    }

    public ExtendedWebElement getWeightInput() {
        return weightInput;
    }

    public ExtendedWebElement getFemaleGenderButton() {
        return femaleGenderButton;
    }

    public ExtendedWebElement getMaleGenderButton() {
        return maleGenderButton;
    }

    public ExtendedWebElement getSubmitButton() {
        return submitButton;
    }

    public ExtendedWebElement getTextResult() {
        return textResult;
    }

    public ExtendedWebElement getWrongInputMessage() {
        return wrongInputMessage;
    }

    public ExtendedWebElement getHeader() {
        return header;
    }

    public List<ExtendedWebElement> getGenderRadioButtonGroup() {
        return genderRadioButtonGroup;
    }

    public List<ExtendedWebElement> getInputs() {
        return inputs;
    }
}
