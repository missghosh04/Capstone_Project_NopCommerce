package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    // 🔹 Locators
    private By cartTitle = By.cssSelector("div.page-title h1");
    private By productName = By.cssSelector(".product .product-name");
    private By checkoutButton = By.id("checkout");
    
    // 🔹 Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // 🔹 Actions
    public String getCartTitle() {
        return driver.findElement(cartTitle).getText();
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
