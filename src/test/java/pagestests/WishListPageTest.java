package pagestests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddItemToWishList;
import setup.BaseTest;

public class WishListPageTest extends BaseTest {

    /**
     * Test to add items to the wishlist and navigate to the wishlist page.
     */
    @Test(priority = 3)
    public void addItemToWishListPage() {
        // Add items to the wishlist
        new AddItemToWishList(driver).addItem();

        // Navigate to the wishlist page
        new AddItemToWishList(driver).navigateToWishListPage();
    }
}
