package pagestests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchItem;
import setup.BaseTest;

public class SearchItemTest extends BaseTest {
    private static final Logger log = Logger.getLogger(SearchItemTest.class);

    @Test(priority = 6)
    public void searchValidItem() {
        log.info("Starting valid product search for Apple MacBook Pro.");
        SearchItem searchItem = new SearchItem(driver);
        searchItem.searchForProduct("Apple MacBook Pro 13-inch");
        String result = searchItem.verifyProductDisplay();
        log.info("Result for valid product: " + result);
        Assert.assertTrue(result.contains("Apple MacBook Pro"), "Product title does not match.");
    }

    @Test(priority = 7)
    public void searchNonValidItem() {
        log.info("Starting invalid product search for: " + "USB");
        SearchItem searchItem = new SearchItem(driver);
        searchItem.searchForProduct("USB");
        String result = searchItem.verifyProductDisplay();
        log.info("Result for invalid product: " + result);

    }
}
