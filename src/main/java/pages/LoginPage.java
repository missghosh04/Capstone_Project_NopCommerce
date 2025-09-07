package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // 🔹 Locators
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.cssSelector("button.login-button");
    private By logoutLink = By.className("ico-logout");
    private By errorMessage = By.cssSelector(".message-error");
    
    // 🔹 Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 🔹 Actions
    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    public void logout() {
        driver.findElement(logoutLink).click();
    }

    // 🔹 Validation
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
