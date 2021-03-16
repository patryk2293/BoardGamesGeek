package com.seleniumlearner.helpers;

import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonMethods {

    public static void selectFromDropDownByText(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                element.click();
            }
        }
    }
}
