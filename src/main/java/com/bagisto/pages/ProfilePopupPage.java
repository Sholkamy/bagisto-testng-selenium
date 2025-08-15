package com.bagisto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePopupPage extends BasePage {

    @FindBy(linkText = "Sign Up")
    WebElement signupButton;

    public ProfilePopupPage(WebDriver driver) {
        super(driver);
    }

    public void openRegistrationPage() {
        waitForVisibility(signupButton, 5);
        clickButton(signupButton);
    }
}
