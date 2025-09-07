package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTests extends BaseTest {

    @Test
    public void testUserRegistration() {
        HomePage home = new HomePage(getDriver());
        home.clickRegister();

        RegisterPage register = new RegisterPage(getDriver());
        register.registerUser("female", "Soumi", "Ghosh", 
                              "soumi" + System.currentTimeMillis() + "@gmail.com",
                              "Password123");

        Assert.assertTrue(register.getSuccessMessage().contains("completed"));
    }
}
