package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    // 🔹 Locators
    private By country = By.id("BillingNewAddress_CountryId");
    private By state = By.id("BillingNewAddress_StateProvinceId");
    private By city = By.id("BillingNewAddress_City");
    private By address1 = By.id("BillingNewAddress_Address1");
    private By zip = By.id("BillingNewAddress_ZipPostalCode");
    private By phone = By.id("BillingNewAddress_PhoneNumber");
    
    private By continueBilling = By.cssSelector("button.new-address-next-step-button");
    private By continueShipping = By.cssSelector("button.shipping-method-next-step-button");
    private By continuePayment = By.cssSelector("button.payment-method-next-step-button");
    private By continuePaymentInfo = By.cssSelector("button.payment-info-next-step-button");
    private By confirmOrder = By.cssSelector("button.confirm-order-next-step-button");
    private By termsofcondition=By.id("termsofservice");
    private By Registerbtn=By.xpath("//button[text()='Register']");
    private By orderSuccessMsg = By.cssSelector(".section.order-completed .title");
    // 🔹 Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
    }
    public void checkboxclick(){
    	driver.findElement(termsofcondition).click();
    }
    public void registerbtnClick() {
    	driver.findElement(Registerbtn).click();
    }
    
    // 🔹 Actions
    public void fillBillingAddress(String cnt, String st, String ct, String addr, String z, String ph) {
        // Country dropdown
        WebElement countryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(country));
        new Select(countryElement).selectByVisibleText(cnt);

        // Wait for state/province dropdown to refresh
        WebElement stateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(state));
        new Select(stateElement).selectByVisibleText(st);

        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(ct);

        driver.findElement(address1).clear();
        driver.findElement(address1).sendKeys(addr);

        driver.findElement(zip).clear();
        driver.findElement(zip).sendKeys(z);

        driver.findElement(phone).clear();
        driver.findElement(phone).sendKeys(ph);

        
    }
    private void clickContinueStep(By locator) {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(locator));
        js.executeScript("arguments[0].click();", btn);
    }

    public void clickContinueBilling() {
        clickContinueStep(continueBilling);
    }

    public void clickContinueShipping() {
        clickContinueStep(continueShipping);
    }

    public void clickContinuePayment() {
        clickContinueStep(continuePayment);
    }

    public void clickContinuePaymentInfo() {
        clickContinueStep(continuePaymentInfo);
    }

    public void clickConfirmOrder() {
        clickContinueStep(confirmOrder);
    }
    
    public String getOrderSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderSuccessMsg)).getText();
    }
}
