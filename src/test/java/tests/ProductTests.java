package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

public class ProductTests extends BaseTest {

    @Test
    public void testSearchAndAddProduct() {
        HomePage home = new HomePage(getDriver());
        home.searchProduct("Apple iPhone 16 128GB");

        ProductPage product = new ProductPage(getDriver());
        Assert.assertTrue(product.getProductTitle().contains("Apple iPhone 16 128GB"),"Product title does not match!");

        product.clickAddToCart();
        Assert.assertTrue(product.getSuccessMessage().contains("The product has been added"));
    }
}
