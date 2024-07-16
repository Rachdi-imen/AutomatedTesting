package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    // Locators
    private final By loginButton = By.cssSelector("a[href='/login?returnUrl=%2F']");
    private final By inputEmail = By.id("Email");
    private final By inputPassword = By.id("Password");
    private final By logInBtn = By.cssSelector("button.button-1.login-button");
    /**
     * Constructs a LoginPage object.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Logs in to the application using the provided email and password.
     *
     * @param email The email of the user.
     * @param pwd   The password of the user.
     */
    public void login(String email, String pwd) {
        // Click on the login button
        driver.findElement(loginButton).click();

        // Input email
        driver.findElement(inputEmail).sendKeys(email);

        // Input password
        driver.findElement(inputPassword).sendKeys(pwd);

        // Click on the login button
        driver.findElement(logInBtn).click();
    }

    /**
     * Asserts that the login was successful by checking the URL.
     */
    public void assertSuccessLogin() {
        wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com"));
        Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com"), "URL does not match.");
    }
}
