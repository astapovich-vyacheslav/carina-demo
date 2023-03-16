package com.qaprosoft.carina.demo.utils.utilsOnliner;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

import java.util.List;

public class FilterChecker {
    public static boolean isSortedByPriceAscending(List<ExtendedWebElement> list) {
        for (int i = 1; i < list.size(); i++) {
            if (parsePrice(list.get(i).getText()) < parsePrice(list.get(i - 1).getText())) {
                return false;
            }
        }
        return true;
    }
    private static double parsePrice(String text) {
        text = text.replace(",", ".");
        char[] textPrice = new char[text.length() - 6];
        text.getChars(2, text.length() - 3, textPrice, 0);
        return Double.parseDouble(text);
    }
}
