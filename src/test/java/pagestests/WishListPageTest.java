package pagestests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddItemToWishList;
import setup.BaseTest;

public class WishListPageTest extends BaseTest {

    @Test(priority =  3)
    public void addItemToWishListPage() {
        new AddItemToWishList(driver).addItem();
        new AddItemToWishList(driver).navigateToWishListPage();
    }
}
