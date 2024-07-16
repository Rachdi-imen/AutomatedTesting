package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchItem {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public SearchItem(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private final By searchBox = By.id("small-searchterms");
    private final By searchButton = By.cssSelector("button.button-1.search-box-button");
    private final By productTitle = By.cssSelector("h2.product-title");
    private final By noResultMessage = By.cssSelector("div.no-result");

    /**
     * Searches for a product using the provided product name.
     *
     * @param productName The name of the product to search for.
     */
    public void searchForProduct(String productName) {
        enterSearchTerm(productName);
        clickSearchButton();
    }

    /**
     * Enters the search term into the search box.
     *
     * @param productName The name of the product to enter into the search box.
     */
    private void enterSearchTerm(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
    }

    /**
     * Clicks the search button to initiate the product search.
     */
    private void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    /**
     * Verifies whether the product is displayed or if no results were found.
     *
     * @return The product title if displayed, or the no results message if not found.
     */
    public String verifyProductDisplay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));

        if (!driver.findElements(productTitle).isEmpty()) {
            return driver.findElement(productTitle).getText();
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(noResultMessage));
            return driver.findElement(noResultMessage).getText();
        }
    }
}
