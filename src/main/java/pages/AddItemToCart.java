package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddItemToCart {
    private final WebDriver driver;
    private final WebDriverWait wait;
    // Locators
    private final By searchBox = By.id("small-searchterms");
    private final By searchButton = By.cssSelector("button.button-1.search-box-button");
    private final By productTitle = By.cssSelector("h2.product-title");
    private final By addToCartBtn = By.id("add-to-cart-button-4");
    private final By assertAddToCartAlert = By.xpath("//p[@class='content']");
    private final By cartLink = By.cssSelector("a[href='/cart']");

    /**
     * Constructs an AddItemToCart page object.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public AddItemToCart(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Adds a product to the cart by searching for the product and clicking the add to cart button.
     *
     * @param itemName The name of the product to search for and add to the cart.
     */
    public void addProductToCart(String itemName) {
        // Input product name
        driver.findElement(searchBox).sendKeys(itemName);

        // Click on search button
        driver.findElement(searchButton).click();

        // Assert product name
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        Assert.assertEquals(driver.findElement(productTitle).getText(), "Apple MacBook Pro 13-inch");

        // Navigate to product details page
        driver.findElement(productTitle).click();
        wait.until(ExpectedConditions.urlContains("/apple-macbook-pro-13-inch"));

        // Click on add to cart button
        driver.findElement(addToCartBtn).click();
    }

    /**
     * Asserts that the product has been added to the cart by checking for the confirmation alert.
     *
     * @return The confirmation message indicating the product was added to the cart.
     */
    public String assertProductAddedToCart() {
        // Assert product added to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(assertAddToCartAlert));
        return driver.findElement(assertAddToCartAlert).getText();
    }

    /**
     * Navigates to the shopping cart page.
     */
    public void navigateToShoppingCartPage() {
        driver.findElement(cartLink).click();
        wait.until(ExpectedConditions.urlContains("/cart"));
    }
}
