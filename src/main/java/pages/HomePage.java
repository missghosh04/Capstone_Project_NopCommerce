package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    // 🔹 Locators
    private By loginLink = By.className("ico-login");
    private By registerLink = By.className("ico-register");
    private By cartLink = By.className("ico-cart");
    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.cssSelector("button[type='submit']");

    // 🔹 Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // 🔹 Actions
    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void clickRegister() {
        driver.findElement(registerLink).click();
    }

    public void clickCart() {
        driver.findElement(cartLink).click();
    }

    public void searchProduct(String productName) {
        WebElement search = driver.findElement(searchBox);
        search.clear();
        search.sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    // 🔹 Validation
    public String getPageTitle() {
        return driver.getTitle();
    }
}
