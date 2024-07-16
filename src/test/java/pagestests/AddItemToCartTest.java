package pagestests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddItemToCart;
import setup.BaseTest;

public class AddItemToCartTest extends BaseTest {


    /**
     * Tests the checkout process by adding a product to the cart and verifying the addition.
     */
    @Test(priority = 3)
    public void testCheckout() {
        AddItemToCart addItemPage = new AddItemToCart(driver);
        addItemPage.addProductToCart("Apple mac");

        // Assert product added to cart
        String assertMsg = addItemPage.assertProductAddedToCart();
        Assert.assertEquals(assertMsg, "The product has been added to your shopping cart",
                "Product addition message is not as expected.");
        // Navigate to shopping cart page
        addItemPage.navigateToShoppingCartPage();
    }
}
