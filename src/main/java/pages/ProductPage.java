package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By productTitle = By.xpath("//h2[@class='product-title']/a[contains(text(),'Apple iPhone 16 128GB')]");
    private By addToCartButton = By.xpath("//button[text()='Add to cart']");
    private By successMessage = By.cssSelector(".bar-notification.success");
    private By closebutton=By.xpath("//*[@id=\"bar-notification\"]/div/span");
    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void closebutton() {
    	driver.findElement(closebutton).click();
    }
    // Actions
    public String getProductTitle() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        return titleElement.getText();
    }


    public void clickAddToCart() {
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addButton.click();
    }

    public String getSuccessMessage() {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return messageElement.getText();
    }
}
