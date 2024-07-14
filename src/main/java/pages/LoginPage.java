package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private WebDriverWait wait;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Locators
    private final By loginButton = By.cssSelector("a[href='/login?returnUrl=%2F']");
    private final By inputEmail = By.id("Email");
    private final By inputPassword = By.id("Password");
    private final By logInBtn = By.cssSelector("button.button-1.login-button");

    public void login(String email, String pwd) {
        //Click on logIn btn
       // wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();

        //Input email
        driver.findElement(inputEmail).sendKeys(email);

        //Input pwd
        driver.findElement(inputPassword).sendKeys(pwd);

        //Click on login btn
        driver.findElement(logInBtn).click();
        wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com"));

    }

}
