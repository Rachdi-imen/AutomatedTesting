package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

    public void searchForProduct(String productName) {
        enterSearchTerm(productName);
        clickSearchButton();
        verifyProductDisplayed();
    }

    public void searchForNonExistingProduct(String productName) {
        enterSearchTerm(productName);
        clickSearchButton();
        verifyNoResults();
    }

    private void enterSearchTerm(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
    }

    private void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    private void verifyProductDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        Assert.assertEquals(driver.findElement(productTitle).getText(), "Apple MacBook Pro 13-inch",
                "Product name does not match the expected value.");
    }

    private void verifyNoResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(noResultMessage));
        Assert.assertEquals(driver.findElement(noResultMessage).getText(), "No products were found that matched your criteria.",
                "Expected no results message not displayed.");
    }
}
