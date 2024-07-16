package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutProcess {
    private final WebDriver driver;
    private final WebDriverWait wait;
    // Locators
    private final By checkoutButton = By.id("checkout");
    private final By agreeServiceCheckbox = By.id("termsofservice");
    private final By countryOption = By.xpath("//option[normalize-space()='United States']");
    private final By stateOption = By.xpath("//option[normalize-space()='Alabama']");
    private final By cityNameField = By.id("BillingNewAddress_City");
    private final By addressOneField = By.id("BillingNewAddress_Address1");
    private final By addressTwoField = By.id("BillingNewAddress_Address2");
    private final By zipCodeField = By.id("BillingNewAddress_ZipPostalCode");
    private final By phoneNumberField = By.id("BillingNewAddress_PhoneNumber");
    private final By faxNumberField = By.id("BillingNewAddress_FaxNumber");
    private final By continueButton = By.name("save");
    private final By shippingMethodOption = By.id("shippingoption_0");
    private final By shippingMethodButton = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
    private final By paymentMethodOption = By.id("paymentmethod_0");
    private final By paymentMethodButton = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    private final By confirmOrderButton = By.xpath("//*[@id=\"payment-info-buttons-container\"]/button");
    private final By finalConfirmOrderButton = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button");
    private final By confirmOrderMessage = By.xpath("//div[@class='page-body checkout-data']//div[@class='section order-completed']//div[@class='title']/strong");
    /**
     * Constructs a CheckoutProcess object.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public CheckoutProcess(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Executes the checkout process by agreeing to terms and filling out the shipping and payment information.
     *
     * @param cityName   The city for the billing address.
     * @param addressOne The first line of the billing address.
     * @param addressTwo The second line of the billing address.
     * @param zipCode    The postal code for the billing address.
     * @param phone      The phone number for the billing address.
     * @param fax        The fax number for the billing address.
     */
    public void checkoutItem(String cityName, String addressOne, String addressTwo, String zipCode, String phone, String fax) {
        agreeTerms();
        fillShippingForm(cityName, addressOne, addressTwo, zipCode, phone, fax);
        shippingMethod();
        paymentMethod();
        confirmOrder();
    }

    private void agreeTerms() {
        // Click on agree service checkbox
        wait.until(ExpectedConditions.visibilityOfElementLocated(agreeServiceCheckbox));
        driver.findElement(agreeServiceCheckbox).click();
        // Click checkout button
        driver.findElement(checkoutButton).click();
    }

    private void fillShippingForm(String cityName, String addressOne, String addressTwo, String zipCode, String phone, String fax) {
        // Select country
        wait.until(ExpectedConditions.elementToBeClickable(countryOption));
        driver.findElement(countryOption).click();

        // Select state
        wait.until(ExpectedConditions.elementToBeClickable(stateOption));
        driver.findElement(stateOption).click();

        // Input city
        driver.findElement(cityNameField).sendKeys(cityName);

        // Input address lines
        driver.findElement(addressOneField).sendKeys(addressOne);
        driver.findElement(addressTwoField).sendKeys(addressTwo);

        // Input zip code
        driver.findElement(zipCodeField).sendKeys(zipCode);

        // Input phone number
        driver.findElement(phoneNumberField).sendKeys(phone);

        // Input fax number
        driver.findElement(faxNumberField).sendKeys(fax);

        // Click on continue button
        driver.findElement(continueButton).click();
    }

    private void shippingMethod() {
        // Wait for shipping method option and select it
        wait.until(ExpectedConditions.visibilityOfElementLocated(shippingMethodOption));
        driver.findElement(shippingMethodOption).click();

        // Click on shipping method button
        driver.findElement(shippingMethodButton).click();
    }

    private void paymentMethod() {
        // Wait for payment method option and select it
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentMethodOption));
        driver.findElement(paymentMethodOption).click();
        driver.findElement(paymentMethodButton).click();
    }

    private void confirmOrder() {
        // Confirm the order
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(finalConfirmOrderButton)).click();
    }

    /**
     * Asserts that the order confirmation message is displayed after completing the order.
     *
     * @return The confirmation message displayed on the screen.
     */
    public String assertOrderConfirmation() {
        // Assert confirmation message
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderMessage));
        return driver.findElement(confirmOrderMessage).getText();
    }
}
