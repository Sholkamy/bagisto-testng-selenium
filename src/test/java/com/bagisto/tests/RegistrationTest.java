package com.bagisto.tests;

import com.bagisto.pages.HomePage;
import com.bagisto.pages.LoginPage;
import com.bagisto.pages.ProfilePopupPage;
import com.bagisto.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    HomePage homeObject;
    ProfilePopupPage profileObject;
    RegistrationPage RegistrationObject;
    LoginPage loginObject;

    @Test
    public void userAbleToRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.acceptCookies();
        homeObject.openProfilePopup();

        profileObject = new ProfilePopupPage(driver);
        profileObject.openRegistrationPage();

        RegistrationObject = new RegistrationPage(driver);
        RegistrationObject.userRegistration("Assem", "Sholqamy",
                "assemsholkamy05@gmail.com","Assem123",true);

        loginObject = new LoginPage(driver);
        Assert.assertTrue(loginObject.isAccountCreatedMessageVisible());
        Assert.assertEquals(loginObject.returnPageTitle(), "Customer Login");
    }
}
