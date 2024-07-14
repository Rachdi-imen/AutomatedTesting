package pagestests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddItemToCart;
import setup.BaseTest;

public class AddItemToCartTest extends BaseTest {

    String name = "Apple mac";

    @Test(priority = 3)
    public void testCheckout() {

        new AddItemToCart(driver).addProductToCart(name);
        //assert product added to cart
        Assert.assertEquals(new AddItemToCart(driver).assertProductAddedToCart(), "The product has been added to your shopping cart");
        //navigate To Shopping Cart Page
        new AddItemToCart(driver).navigateToShoppingCartPage();


    }
}
