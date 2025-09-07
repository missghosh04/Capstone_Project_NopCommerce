package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

public class PaymentTests extends BaseTest {

    @Test
    public void testPaymentProcess() throws InterruptedException {
    	 HomePage home = new HomePage(getDriver());
    	 home.clickRegister();
    	 RegisterPage register = new RegisterPage(getDriver());
    	 register.registerUser("female", "Soumi", "Ghosh", 
                              "soumi" + System.currentTimeMillis() + "@gmail.com",
                              "Password123");
        home.searchProduct("Apple iPhone 16 128GB");
        
        ProductPage product = new ProductPage(getDriver());
        product.clickAddToCart();
        Thread.sleep(1000);
        product.closebutton();
        Thread.sleep(1000);
        home.clickCart();
        
        CartPage cart = new CartPage(getDriver());

        CheckoutPage checkout = new CheckoutPage(getDriver());
        checkout.checkboxclick();
        cart.clickCheckout();
        Thread.sleep(3000);
        checkout.fillBillingAddress(
                "United States of America", "New York", "New York City",
                "123 Test Street", "10001", "1234567890"
            );
        checkout.clickContinueBilling();
        Thread.sleep(1000);
        // Step 2: Shipping Method
        checkout.clickContinueShipping();
        Thread.sleep(1000);
        PaymentPage payment = new PaymentPage(getDriver());
        payment.selectCreditCardPayment();
        payment.enterCardDetails("Soumi Ghosh", "4111111111111111", "05", "2027", "123");

        checkout.clickConfirmOrder();
    }
}
