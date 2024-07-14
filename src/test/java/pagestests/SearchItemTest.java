package pagestests;

import org.testng.annotations.Test;
import pages.SearchItem;
import setup.BaseTest;

public class SearchItemTest extends BaseTest {

    String existingProductName = "Apple mac";
    String nonExistingProductName = "Hello test";

    @Test(priority = 3)
    public void searchTest(){
        new SearchItem(driver).searchForProduct(existingProductName);
        new SearchItem(driver).searchForNonExistingProduct(nonExistingProductName);

    }
}
