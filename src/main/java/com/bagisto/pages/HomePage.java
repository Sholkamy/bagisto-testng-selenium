package com.bagisto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(linkText = "Accept")
    WebElement acceptCookiesButton;

    @FindBy(xpath = "//span[@aria-label='Profile']")
    WebElement profileIcon;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        clickButton(acceptCookiesButton);
    }

    public void openProfilePopup() {
        clickButton(profileIcon);
    }

}
