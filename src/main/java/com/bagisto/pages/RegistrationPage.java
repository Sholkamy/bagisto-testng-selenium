package com.bagisto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    @FindBy(name = "first_name")
    WebElement firstNameField;

    @FindBy(name = "last_name")
    WebElement lastNameField;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(name = "password_confirmation")
    WebElement passwordConfirmationField;

    @FindBy(xpath = "//label[@for='agreement']")
    WebElement conditionsCheckbox;

    @FindBy(xpath = "//button[normalize-space()='Register']")
    WebElement registerButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void userRegistration(String firstName, String lastName, String email, String password, boolean conditionsValue) {
        waitForVisibility(firstNameField, 10);
        setInputText(firstNameField, firstName);
        setInputText(lastNameField, lastName);
        setInputText(emailField, email);
        setInputText(passwordField, password);
        setInputText(passwordConfirmationField, password);
        setCheckbox(conditionsCheckbox, conditionsValue);
        clickButton(registerButton);
    }
}
