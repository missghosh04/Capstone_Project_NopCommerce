package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;
import pages.RegisterPage;

public class CheckoutTests extends BaseTest {

    @Test
    public void testCheckoutFlow() throws InterruptedException {
    	 HomePage home = new HomePage(getDriver());
    	 home.clickRegister();
    	 RegisterPage register = new RegisterPage(getDriver());
    	 register.registerUser("female", "Soumi", "Ghosh", 
                              "soumi" + System.currentTimeMillis() + "@gmail.com",
                              "Password123");
        home.searchProduct("Apple iPhone 16 128GB");
        
        ProductPage product = new ProductPage(getDriver());
        product.clickAddToCart();
        product.closebutton();
        Thread.sleep(2000);
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
        // Step 3: Payment Method
        checkout.clickContinuePayment();
        Thread.sleep(1000);
        // Step 4: Payment Info
        checkout.clickContinuePaymentInfo();
        Thread.sleep(1000);
        // Step 5: Confirm Order
        checkout.clickConfirmOrder();

            String msg = checkout.getOrderSuccessMessage();
            System.out.println("Order Success Msg: " + msg);
            Assert.assertTrue(msg.contains("Your order has been successfully processed!"), "Order was not completed!");
    }
}
