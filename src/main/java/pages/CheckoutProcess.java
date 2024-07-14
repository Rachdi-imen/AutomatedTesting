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

    public CheckoutProcess(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Locators
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


    public void checkoutItem(String cityName, String addressOne, String addressTwo, String zipCode, String phone, String fax) {

        agreeTerms();
        fillShippingForm(cityName, addressOne, addressTwo, zipCode, phone, fax);
        shippingMethod();
        payementMethod();
        confirmOrder();
        verifyOrderConfirmation();
    }

    private void agreeTerms() {
        // Click On Agree Service Checkbox
        wait.until(ExpectedConditions.visibilityOfElementLocated(agreeServiceCheckbox));
        driver.findElement(agreeServiceCheckbox).click();
        //click checkout Btn
        driver.findElement(checkoutButton).click();

    }

    private void fillShippingForm(String cityName, String addressOne, String addressTwo, String zipCode, String phone, String fax) {
        //Select Country
        wait.until(ExpectedConditions.elementToBeClickable(countryOption));
        driver.findElement(countryOption).click();

        //Select City
        wait.until(ExpectedConditions.elementToBeClickable(stateOption));
        driver.findElement(stateOption).click();

        //Input City
        driver.findElement(cityNameField).sendKeys(cityName);

        // Input address 1 and 2
        driver.findElement(addressOneField).sendKeys(addressOne);
        driver.findElement(addressTwoField).sendKeys(addressTwo);

        //Input ZipCode
        driver.findElement(zipCodeField).sendKeys(zipCode);

        //Input phone
        driver.findElement(phoneNumberField).sendKeys(phone);

        //Input fax
        driver.findElement(faxNumberField).sendKeys(fax);

        //Click On Continue Btn
        driver.findElement(continueButton).click();
    }

    private void shippingMethod() {
        //Shipping Page
        wait.until(ExpectedConditions.visibilityOfElementLocated(shippingMethodOption));
        //click on shippingMethodOption
        driver.findElement(shippingMethodOption).click();

        //click on shippingMethodButton
        driver.findElement(shippingMethodButton).click();
    }

    private void payementMethod() {
        // Payement Page
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentMethodOption));
        driver.findElement(paymentMethodOption).click();
        driver.findElement(paymentMethodButton).click();
    }

    private void confirmOrder() {
        //Confirm Order Page
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(finalConfirmOrderButton)).click();
    }

    private void verifyOrderConfirmation() {
        //assert Confirm Msg
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderMessage));
        Assert.assertEquals(driver.findElement(confirmOrderMessage).getText(), "Your order has been successfully processed!");
    }
}

