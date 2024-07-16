package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddItemToWishList {
    private final WebDriver driver;
    private final WebDriverWait wait;
    // Locators
    private final By electronicsMenu = By.xpath("//a[@href='/electronics']");
    private final By cellPhonesLink = By.xpath("//a[@href='/cell-phones' and @title='Show products in category Cell phones']");
    private final By wishListPageLink = By.cssSelector("a.ico-wishlist");
    private final By closeBtn = By.cssSelector("span.close");
    /**
     * Constructor for AddItemToWishList.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public AddItemToWishList(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    /**
     * Adds items to the wishlist from the cell phones category.
     */
    public void addItem() {
        // Click on the "Electronics" menu
        wait.until(ExpectedConditions.elementToBeClickable(electronicsMenu)).click();

        // Click on submenu "Cell Phones"
        wait.until(ExpectedConditions.elementToBeClickable(cellPhonesLink)).click();

        // Add each product to the wishlist by product ID
        addProductToWishlist("18"); // HTC One M8
        addProductToWishlist("19"); // HTC One Mini
        addProductToWishlist("20"); // Nokia Lumia 1020
    }

    /**
     * Adds a specific product to the wishlist using its product ID.
     *
     * @param productId The ID of the product to be added to the wishlist.
     */
    private void addProductToWishlist(String productId) {
        By productButton = By.xpath("//div[@data-productid='" + productId + "']//button[contains(@class, 'add-to-wishlist-button')]");

        wait.until(ExpectedConditions.elementToBeClickable(productButton)).click();

        // Close the popup if it appears
        waitForAndClosePopup();
    }

    /**
     * Waits for the popup to appear and closes it if visible.
     */
    private void waitForAndClosePopup() {
        try {
            // Wait for the popup to appear
            wait.until(ExpectedConditions.visibilityOfElementLocated(closeBtn));

            // Wait a moment before clicking to ensure visibility
            Thread.sleep(500); // Adjust time if needed

            // Close the popup
            wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
        } catch (Exception e) {
            System.out.println("Popup did not appear or could not be closed: " + e.getMessage());
        }
    }

    /**
     * Navigates to the wishlist page.
     */
    public void navigateToWishListPage() {
        // Click on the Wishlist page link
        wait.until(ExpectedConditions.elementToBeClickable(wishListPageLink)).click();
    }
}
