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

    public AddItemToCart(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Locators
    private final By searchBox = By.id("small-searchterms");
    //private final By selectName = By.id("ui-id-4");
    private final By searchButton = By.cssSelector("button.button-1.search-box-button");
    private  final By productTitle = By.cssSelector("h2.product-title");
    private final By addToCartBtn = By.id("add-to-cart-button-4");
    private final By assertAddToCartAlert = By.cssSelector("p.content");
    private final By cartLink = By.cssSelector("a[href='/cart']");

    public void addProductToCart(String itemName){
        //input product name
        driver.findElement(searchBox).sendKeys(itemName);

        //Click On search Btn
        driver.findElement(searchButton).click();

        //Assert Product name = "Apple MacBook Pro 13-inch"
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        Assert.assertEquals(driver.findElement(productTitle).getText(), "Apple MacBook Pro 13-inch");

        //navigate to "https://demo.nopcommerce.com/apple-macbook-pro-13-inch"
        driver.findElement(productTitle).click();
        wait.until(ExpectedConditions.urlContains("/apple-macbook-pro-13-inch"));

        //click on addTo cart btn
        driver.findElement(addToCartBtn).click();

    }

    public String assertProductAddedToCart(){
        //assert product added to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(assertAddToCartAlert));
        return driver.findElement(assertAddToCartAlert).getText();
    }
    public void navigateToShoppingCartPage(){
        driver.findElement(cartLink).click();
        wait.until(ExpectedConditions.urlContains("/cart"));
    }

}
