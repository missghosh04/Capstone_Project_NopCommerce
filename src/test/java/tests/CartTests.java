package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class CartTests extends BaseTest {

    @Test
    public void testCartFlow() throws InterruptedException {
        HomePage home = new HomePage(getDriver());
        home.searchProduct("Apple iPhone 16 128GB");

        ProductPage product = new ProductPage(getDriver());
        product.clickAddToCart();
        Thread.sleep(2000);
        product.closebutton();
        Thread.sleep(2000);
        home.clickCart();
        CartPage cart = new CartPage(getDriver());

        Assert.assertTrue(cart.getCartTitle().contains("Shopping cart"));
        Assert.assertTrue(cart.getProductName().contains("Apple iPhone 16 128GB"));
    }
}
