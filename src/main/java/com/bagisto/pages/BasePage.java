package com.bagisto.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickButton(WebElement element) {
        element.click();
    }

    protected void setInputText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected void setCheckbox(WebElement checkbox, boolean shouldBeChecked) {
        boolean isChecked = checkbox.isSelected();

        if (shouldBeChecked && !isChecked) {
            checkbox.click();
        } else if (!shouldBeChecked && isChecked) {
            checkbox.click();
        }
    }

    protected WebElement waitForVisibility(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean isElementVisible(WebElement element) {
        try {
            return waitForVisibility(element, 10).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

}
