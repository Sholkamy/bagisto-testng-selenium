package com.bagisto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//p[contains(text(), 'Account created successfully')]")
    WebElement snackbarSuccessMessage;

    @FindBy(css = "h1.font-dmserif")
    private WebElement pageTitle;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountCreatedMessageVisible() {
        return isElementVisible(snackbarSuccessMessage);
    }

    public String returnPageTitle() {
        waitForVisibility(pageTitle, 5);
        return pageTitle.getText();
    }
}
