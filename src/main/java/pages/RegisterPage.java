package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    // Locators
    private final By registerButton = By.linkText("Register");
    private final By genderFemaleRadioButton = By.id("gender-female");
    private final By firstNameField = By.id("FirstName");
    private final By lastNameField = By.id("LastName");
    private final By dayOfBirthField = By.name("DateOfBirthDay");
    private final By monthOfBirthField = By.name("DateOfBirthMonth");
    private final By yearOfBirthField = By.name("DateOfBirthYear");
    private final By emailField = By.id("Email");
    private final By companyField = By.id("Company");
    private final By passwordField = By.id("Password");
    private final By confirmPasswordField = By.id("ConfirmPassword");
    private final By registerSubmitButton = By.id("register-button");
    private final By continueButton = By.xpath("//a[@class='button-1 register-continue-button']");
    private final By logOutButton = By.cssSelector("a[href='/logout']");

    /**
     * Constructs a RegisterPage object.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Registers a new user with the provided details.
     *
     * @param firstname The first name of the user.
     * @param lastname  The last name of the user.
     * @param day       The day of birth of the user.
     * @param month     The month of birth of the user.
     * @param year      The year of birth of the user.
     * @param email     The email of the user.
     * @param company   The company name of the user.
     * @param password  The password for the user account.
     */
    public void register(String firstname, String lastname, String day, String month,
                         String year, String email, String company, String password) {

        // Click on register button
        driver.findElement(registerButton).click();

        // Choose Female Gender
        driver.findElement(genderFemaleRadioButton).click();

        // Input first name
        driver.findElement(firstNameField).sendKeys(firstname);

        // Input last name
        driver.findElement(lastNameField).sendKeys(lastname);

        // Select day of birth
        wait.until(ExpectedConditions.visibilityOfElementLocated(dayOfBirthField));
        Select selectDay = new Select(driver.findElement(dayOfBirthField));
        selectDay.selectByVisibleText(day);

        // Select month of birth
        wait.until(ExpectedConditions.visibilityOfElementLocated(monthOfBirthField));
        Select selectMonth = new Select(driver.findElement(monthOfBirthField));
        selectMonth.selectByVisibleText(month);

        // Select year of birth
        wait.until(ExpectedConditions.visibilityOfElementLocated(yearOfBirthField));
        Select selectYear = new Select(driver.findElement(yearOfBirthField));
        selectYear.selectByVisibleText(year);

        // Input email
        driver.findElement(emailField).sendKeys(email);

        // Input company name
        driver.findElement(companyField).sendKeys(company);

        // Input password
        driver.findElement(passwordField).sendKeys(password);

        // Confirm password
        driver.findElement(confirmPasswordField).sendKeys(password);

        // Click on register button
        wait.until(ExpectedConditions.elementToBeClickable(registerSubmitButton));
        driver.findElement(registerSubmitButton).click();

        // Click on continue button
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
        driver.findElement(continueButton).click();
    }

    /**
     * Logs out the current user.
     */
    public void logOut() {
        // Click on logout button
        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutButton));
        driver.findElement(logOutButton).click();
    }
}
