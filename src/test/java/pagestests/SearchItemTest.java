package pagestests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchItem;
import setup.BaseTest;

public class SearchItemTest extends BaseTest {

    String existingProductName = "Apple mac";
    String nonExistingProductName = "Hello test";

    @Test(priority = 3)
    public void searchValidItem() {
        SearchItem searchItemPage = new SearchItem(driver);
        searchItemPage.searchForProduct(existingProductName);
        String result = searchItemPage.verifyProductDisplay();

        Assert.assertEquals(result, "Apple MacBook Pro 13-inch",
                "Product name does not match the expected value.");
    }

    @Test(priority = 4)
    public void searchNonValidItem() {
        SearchItem searchItemPage = new SearchItem(driver);
        searchItemPage.searchForProduct(nonExistingProductName);
        String result = searchItemPage.verifyProductDisplay();

        Assert.assertEquals(result, "No products were found that matched your criteria.",
                "Expected no results message not displayed.");
    }
}
