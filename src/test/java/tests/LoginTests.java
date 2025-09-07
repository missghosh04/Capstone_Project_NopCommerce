package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void testValidLogin() {
        HomePage home = new HomePage(getDriver());
        home.clickLogin();

        LoginPage login = new LoginPage(getDriver());
        login.login("soumi@gmail.com", "Password123"); // Replace with valid credential
    }

    @Test
    public void testInvalidLogin() {
        HomePage home = new HomePage(getDriver());
        home.clickLogin();

        LoginPage login = new LoginPage(getDriver());
        login.login("wrong@demo.com", "wrongpass");

        Assert.assertTrue(login.getErrorMessage().contains("unsuccessful"));
    }
}
